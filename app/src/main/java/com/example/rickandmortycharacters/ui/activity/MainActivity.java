package com.example.rickandmortycharacters.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.presentations.presenter.MainPresenter;
import com.example.rickandmortycharacters.presentations.view.MainView;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    ListView characterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterListView = (ListView) findViewById(R.id.character_list);
    }

    @Override
    public void setAdapter(List<CharacterResults> characters) {
        CharacterAdapter adapter = new CharacterAdapter(this, R.layout.character_list_item, characters);
        characterListView.setAdapter(adapter);
    }
}