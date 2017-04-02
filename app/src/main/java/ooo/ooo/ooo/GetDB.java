package ooo.ooo.ooo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by hang on 2017/3/6.
 */

public class GetDB {
    private Context context;
    private String sdpath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath()+"/mydatabase";//sdpath用于存放保存的路径。
    private String filename = "word.db"; //filename用于保存文件名。


    public GetDB(Context context) {
        this.context = context;
    }

    public SQLiteDatabase getDB() {
        File dir = new File(sdpath);
        if (!dir.exists()) {
            dir.mkdir();
        }//如果该目录不存在，创建该目录
        String databasefilename = sdpath+"/"+filename;//其值等于database的路径
        File filepath = new File(databasefilename);
        if (!filepath.exists()) {//如果文件不存在
            try {
                InputStream inputStream = context.getResources().openRawResource(R.raw.word); //将raw中的word.db放入输入流中
                FileOutputStream fileOutputStream = new FileOutputStream(databasefilename); //将新的文件放入输出流中
                byte[] buff = new byte[8192];
                int len = 0;
                while ((len = inputStream.read(buff)) > 0) {
                    fileOutputStream.write(buff, 0, len);
                }
                fileOutputStream.close();
                inputStream.close();
            } catch (Exception e) {
                Log.i("info","unable copy");
                e.printStackTrace();
            }
        }//写入文件结束
        Log.i("filepath"," "+filepath);
        SQLiteDatabase database = SQLiteDatabase.openDatabase(filepath.getPath(),null,SQLiteDatabase.OPEN_READWRITE);//利用openDatabase方法打开数据库。
        return database;
    }
}