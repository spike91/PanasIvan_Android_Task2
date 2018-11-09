package com.example.user.panasivan_android_task2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Film> films;

    public FilmListAdapter(Context context, List<Film> films) {
        this.films = films;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FilmListAdapter.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.films_list_item, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inflater.getContext(), FilmInfoActivity.class);
                inflater.getContext().startActivity(intent);
            }
        });
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        params.height = viewGroup.getMeasuredHeight() / 10;
        view.setLayoutParams(params);
        return new FilmListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmListAdapter.ViewHolder viewHolder, int i) {
        Film film = films.get(i);
        viewHolder.titleView.setText(film.getTitle());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        final TextView titleView;
        ViewHolder(View view){
            super(view);
            titleView = view.findViewById(R.id.title);
        }
    }
}
