package com.example.user.panasivan_android_task2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SearchAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Film> listItemStorage;
    private Film item;
    public SearchAdapter(Context context, List<Film> films) {
        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemStorage = films;
    }
    @Override
    public int getCount() {
        return listItemStorage.size();
    }
    @Override
    public Object getItem(int position) {
        return listItemStorage.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        item = listItemStorage.get(position);
        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.films_list_item, parent, false);
            listViewHolder.filmTitle = convertView.findViewById(R.id.title);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.filmTitle.setText(listItemStorage.get(position).getTitle());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inflater.getContext(), FilmInfoActivity.class);
                intent.putExtra("film", item);
                inflater.getContext().startActivity(intent);
            }
        });
        return convertView;
    }
    static class ViewHolder{
        TextView filmTitle;
    }
}
