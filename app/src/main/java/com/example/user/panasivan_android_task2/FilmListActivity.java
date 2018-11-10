package com.example.user.panasivan_android_task2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FilmListActivity extends SearchableActivity {
    private List<Film> films;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelableArrayList("films", (ArrayList<? extends Parcelable>) films);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        if (savedInstanceState != null) {
            films = savedInstanceState.getParcelableArrayList("films");

        } else {
            Intent intent = getIntent();
            films = intent.getParcelableArrayListExtra("films");
        }

        RecyclerView recyclerView = findViewById(R.id.films_list);
        FilmListAdapter adapter = new FilmListAdapter(this, films);
        recyclerView.setAdapter(adapter);
    }
}
