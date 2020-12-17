package com.example.rickandmortycharacters.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.model.adapter.NewAdapter;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.presentations.presenter.MainPresenter;
import com.example.rickandmortycharacters.presentations.view.MainView;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.character_recycle_view);
    }

    @Override
    public void setAdapter(List<CharacterResults> characters) {
        NewAdapter adapter = new NewAdapter(this, characters);
        recyclerView.setAdapter(adapter);
    }
}