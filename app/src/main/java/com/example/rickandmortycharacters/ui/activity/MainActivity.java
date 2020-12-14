package com.example.rickandmortycharacters.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.model.adapter.CharacterState;
import com.example.rickandmortycharacters.presentations.presenter.MainPresenter;
import com.example.rickandmortycharacters.presentations.view.MainView;

import java.util.ArrayList;
import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setAdapter(List<CharacterState> characters) {
        CharacterAdapter adapter = new CharacterAdapter(this, R.layout.character_list_item, characters);
    }
}