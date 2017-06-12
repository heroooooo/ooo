package ooo.ooo.ooo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public SQLiteDatabase db;
    public Preference preference;
    public List<Word> list;
    public ListView listView;
    public  int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setTitle("                                                                    ^_^");
        list=getWordslist();
        listView=(ListView)findViewById(R.id.list_view);
        WordAdapter wadper= new WordAdapter(list,MainActivity.this);
        listView.setAdapter(wadper);
    }


    public List<Word> getWordslist() {

        GetDB DB = new GetDB(getApplicationContext());
        db = DB.getDB();
        List<Word> wordsList = new ArrayList<Word>();
        Cursor cursor = db.rawQuery("select * from wordlist",null);
        if (cursor.moveToFirst()) {
          /*  for (int i = 0; i <cursor.getCount(); i++)*/
          int a=0;
            id=1;
          while (cursor.moveToNext()){
//              cursor.move(i);
                Word word = new Word(String.valueOf(id++),cursor.getString(cursor.getColumnIndex("word")),
                        cursor.getString(cursor.getColumnIndex("phonetic_symbol_en")),
                        cursor.getString(cursor.getColumnIndex("phonetic_symbol_am")),
                        cursor.getString(cursor.getColumnIndex("meaning")));
                wordsList.add(word);
            }
        }
        cursor.close();
        return wordsList;
    }
}
