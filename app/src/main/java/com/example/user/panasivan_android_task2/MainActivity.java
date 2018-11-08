package com.example.user.panasivan_android_task2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    JsonHelper helper;
    List<Film> films;
    private List<Genre> genres = new ArrayList<>();

    ListView genresList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        helper = new JsonHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        films = helper.getFilms();

        for(Film film: films){
            for(Genre genre: film.getGenres()){
                if(!genres.contains(genre)){
                    genres.add(genre);
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
            }
        };
        genresList.setOnItemClickListener(genreListener);
    }


}
