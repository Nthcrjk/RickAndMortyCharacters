package com.example.rickandmortycharacters.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.presentations.view.DetailView;

import moxy.MvpAppCompatActivity;

public class DetailActivity extends MvpAppCompatActivity implements DetailView {

    public static void start(Context caller){
        Intent intent = new Intent(caller, DetailActivity.class);
        caller.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_detail);
    }
}
