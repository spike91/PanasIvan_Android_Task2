package com.example.user.panasivan_android_task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class FilmInfoActivity extends SearchableActivity {
    Film film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);
        Intent intent = getIntent();
        film = intent.getParcelableExtra("film");
        TextView field = findViewById(R.id.film_title);
        field.setText(film.getTitle());
        field = findViewById(R.id.film_year);
        field.setText(film.getYear());
        field = findViewById(R.id.film_awards);
        field.setText(film.getAwards());
        field = findViewById(R.id.film_runtime);
        field.setText(film.getRuntime());
        field = findViewById(R.id.film_plot);
        field.setText(film.getPlot());

        field = findViewById(R.id.film_actor);
        StringBuffer text = new StringBuffer();
        List<Person> persons = film.getActors();
        for(Person item: persons){
            text.append(item.getName());
            if(persons.indexOf(item) < persons.size() - 1){
                text.append(", ");
            }
        }
        field.setText(text);

        field = findViewById(R.id.film_writer);
        text = new StringBuffer();
        persons = film.getWriters();
        for(Person item: persons){
            text.append(item.getName());
            for(Role role: item.getRoles()){
                String description = role.getDescription();
                String name = role.getName();
                if(name.equalsIgnoreCase("Writer") && description != null){
                    text.append(" " + role.getDescription());
                }
            }
            if(persons.indexOf(item) < persons.size() - 1){
                text.append(", ");
            }
        }
        field.setText(text);

        field = findViewById(R.id.film_director);
        text = new StringBuffer();
        persons = film.getDirectors();
        for(Person item: persons){
            text.append(item.getName());
            if(persons.indexOf(item) < persons.size() - 1){
                text.append(", ");
            }
        }
        field.setText(text);

        field = findViewById(R.id.film_country);
        text = new StringBuffer();
        List<Country> countries = film.getCountries();
        for(Country item: countries){
            text.append(item.getName());
            if(countries.indexOf(item) < countries.size() - 1){
                text.append(", ");
            }
        }
        field.setText(text);

        field = findViewById(R.id.film_language);
        text = new StringBuffer();
        List<Language> languages = film.getLanguages();
        for(Language item: languages){
            text.append(item.getName());
            if(languages.indexOf(item) < languages.size() - 1){
                text.append(", ");
            }
        }
        field.setText(text);

        field = findViewById(R.id.film_genre);
        text = new StringBuffer();
        List<Genre> genres = film.getGenres();
        for(Genre item: genres){
            text.append(item.getName());
            if(genres.indexOf(item) < genres.size() - 1){
                text.append(", ");
            }
        }
        field.setText(text);
    }
}
