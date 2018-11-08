package com.example.user.panasivan_android_task2;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends ListViewLoader {
    JsonHelper helper;
    List<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        helper = new JsonHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        films = helper.getFilms();
    }


}
