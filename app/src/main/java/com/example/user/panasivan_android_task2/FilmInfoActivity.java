package com.example.user.panasivan_android_task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class FilmInfoActivity extends AppCompatActivity {
    Film film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);
        JsonHelper helper = new JsonHelper(this);
        film = helper.getFilms().get(0);
        TextView title = findViewById(R.id.film_title_label);
        title.setText("Title");
        title = findViewById(R.id.film_title);
        title.setText(film.getTitle());
        title = findViewById(R.id.film_year);
        title.setText(film.getYear());
    }
}
