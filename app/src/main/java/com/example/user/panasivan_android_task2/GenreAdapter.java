package com.example.user.panasivan_android_task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GenreAdapter extends ArrayAdapter<Genre> {

    private LayoutInflater inflater;
    int layout;
    private List<Genre> genres;

    public GenreAdapter(Context context, int resource, List<Genre> genres) {
        super(context, resource, genres);
        this.genres = genres;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView nameView = (TextView) view.findViewById(R.id.name);

        Genre state = genres.get(position);

        nameView.setText(state.getName());

        return view;
    }
}
