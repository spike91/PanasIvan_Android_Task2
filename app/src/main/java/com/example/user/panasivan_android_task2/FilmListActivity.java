package com.example.user.panasivan_android_task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class FilmListActivity extends SearchableActivity {
    List<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);
        Intent intent = getIntent();
        films = intent.getParcelableArrayListExtra("films");
        RecyclerView recyclerView = findViewById(R.id.films_list);
        FilmListAdapter adapter = new FilmListAdapter(this, films);
        recyclerView.setAdapter(adapter);
    }
}
