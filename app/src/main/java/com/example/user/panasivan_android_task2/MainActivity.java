package com.example.user.panasivan_android_task2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends SearchableActivity {
    private JsonHelper helper;
    private List<Film> films;
    private Context self;
    private List<Genre> genres = new ArrayList<>();
    private ListView genresList;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelableArrayList("films", (ArrayList<? extends Parcelable>) films);
        savedInstanceState.putParcelableArrayList("genres", (ArrayList<? extends Parcelable>) genres);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new JsonHelper(this);

        if (savedInstanceState != null) {
            films = savedInstanceState.getParcelableArrayList("films");
            genres = savedInstanceState.getParcelableArrayList("genres");

        } else {
            films = helper.getFilms();

            for(Film film: films){
                for(Genre genre: film.getGenres()){
                    if(!genres.contains(genre)){
                        genres.add(genre);
                    }
                }
            }
        }


        genresList = findViewById(R.id.genresList);
        GenreAdapter genreAdapter = new GenreAdapter(this, R.layout.genre_item, genres);
        genresList.setAdapter(genreAdapter);
        AdapterView.OnItemClickListener genreListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Genre selectedGenre = (Genre) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(self, FilmListActivity.class);
                List<Film> filmsToIntent = new ArrayList<>();
                for(Film film: films){
                    if(film.getGenres().contains(selectedGenre)){
                        filmsToIntent.add(film);
                    }
                }
                intent.putParcelableArrayListExtra("films", (ArrayList<? extends Parcelable>) filmsToIntent);
                startActivity(intent);
            }
        };
        genresList.setOnItemClickListener(genreListener);
    }


}
