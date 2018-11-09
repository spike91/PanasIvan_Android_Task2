package com.example.user.panasivan_android_task2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

public class FilmListActivity extends AppCompatActivity {
    List<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);
        JsonHelper helper = new JsonHelper(this);
        films = helper.getFilms();
        RecyclerView recyclerView = findViewById(R.id.films_list);
        FilmListAdapter adapter = new FilmListAdapter(this, films);
        recyclerView.setAdapter(adapter);
    }
//
//    public void filmOnClick(View view){
//        Toast.makeText(this, view.toString(), Toast.LENGTH_LONG).show();
//    }
}
