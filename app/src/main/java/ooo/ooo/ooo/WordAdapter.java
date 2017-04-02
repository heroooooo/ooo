package ooo.ooo.ooo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.lzyzsd.randomcolor.RandomColor;

import java.util.List;

/**
 * Created by hang on 2017/3/6.
 */

public class WordAdapter extends BaseAdapter {
    public List<Word> wordsList;
    public Context mContext;
    RandomColor randomColor ;

    public WordAdapter(List<Word> wordsList, Context mContext) {
        this.wordsList = wordsList;
        this.mContext = mContext;
 //       randomColor = new RandomColor();
    }

    @Override
    public int getCount() {
        return wordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list,parent,false);
            holder = new ViewHolder();
            holder.word = (TextView) convertView.findViewById(R.id.word);
            holder._en = (TextView) convertView.findViewById(R.id._en);
//            holder._am = (TextView) convertView.findViewById(R.id._am);
            holder.meaning = (TextView) convertView.findViewById(R.id.meaning);
            holder.id=(TextView)convertView.findViewById(R.id.id);
            convertView.setTag(holder);   //将Holder存储到convertView中
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.id.setText(String.valueOf(wordsList.get(position).getId()));
        holder.word.setText(wordsList.get(position).getWord());
        holder.word.setTextColor(randomColor.randomColor());
        holder._en.setText(wordsList.get(position).get_en());
        holder._en.setTextColor(randomColor.randomColor());
//        holder._am.setText(wordsList.get(position).get_am());
       holder.meaning.setText(wordsList.get(position).getMeaning());
        holder.meaning.setTextColor(randomColor.randomColor());
        return convertView;
    }
    static class ViewHolder{
        TextView id;
        TextView word;
        TextView _en;
//        TextView _am;
        TextView meaning;
    }
}

