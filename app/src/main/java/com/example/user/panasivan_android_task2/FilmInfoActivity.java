package com.example.user.panasivan_android_task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FilmInfoActivity extends AppCompatActivity {
    Film film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);
        JsonHelper helper = new JsonHelper(this);
        film = helper.getFilms().get(0);
        TextView title = findViewById(R.id.film_title);
        title.setText(film.getTitle());
        title = findViewById(R.id.film_year);
        title.setText(film.getYear());
        title = findViewById(R.id.film_awards);
        title.setText(film.getAwards());
        title = findViewById(R.id.film_runtime);
        title.setText(film.getRuntime());
        title = findViewById(R.id.film_plot);
        title.setText(film.getPlot());
        title = findViewById(R.id.film_actor);
        String text = "";
        List<Person> persons = film.getActors();
        for(Person item: persons){
            text += item.getName();
            if(persons.indexOf(item) < persons.size() - 1){
                text += ", ";
            }
        }
        title.setText(text);

        title = findViewById(R.id.film_writer);
        text = "";
        persons = film.getWriters();
        for(Person item: persons){
            text += item.getName();
            // TODO: description
            if(persons.indexOf(item) < persons.size() - 1){
                text += ", ";
            }
        }
        title.setText(text);

        title = findViewById(R.id.film_director);
        text = "";
        persons = film.getDirectors();
        for(Person item: persons){
            text += item.getName();
            if(persons.indexOf(item) < persons.size() - 1){
                text += ", ";
            }
        }
        title.setText(text);

        title = findViewById(R.id.film_country);
        text = "";
        List<Country> countries = film.getCountries();
        for(Country item: countries){
            text += item.getName();
            if(countries.indexOf(item) < countries.size() - 1){
                text += ", ";
            }
        }
        title.setText(text);

        title = findViewById(R.id.film_language);
        text = "";
        List<Language> languages = film.getLanguages();
        for(Language item: languages){
            text += item.getName();
            if(languages.indexOf(item) < languages.size() - 1){
                text += ", ";
            }
        }
        title.setText(text);

        title = findViewById(R.id.film_genre);
        text = "";
        List<Genre> genres = film.getGenres();
        for(Genre item: genres){
            text += item.getName();
            if(genres.indexOf(item) < genres.size() - 1){
                text += ", ";
            }
        }
        title.setText(text);
    }
}
