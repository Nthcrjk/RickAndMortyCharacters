package com.example.rickandmortycharacters.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.adapter.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.adapter.diffutil.CharacterDiffUtilCallBack;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.presentations.presenter.MainPresenter;
import com.example.rickandmortycharacters.presentations.view.MainView;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private List<CharacterResults> allLoadedCharacters;

    @InjectPresenter
    MainPresenter presenter;

    private CharacterAdapter adapter = null;

    private RecyclerView recyclerView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.character_recycle_view);

        button = (Button) findViewById(R.id.button);
    }

    @Override
    public void setAdapter(List<CharacterResults> characters) {
        if (adapter == null){
            adapter = new CharacterAdapter(this, characters);
            recyclerView.setAdapter(adapter);
        } else{
            CharacterDiffUtilCallBack characterDiffUtilCallBack = new CharacterDiffUtilCallBack(adapter.getData(), characters);
            DiffUtil.DiffResult characterDiffResult = DiffUtil.calculateDiff(characterDiffUtilCallBack);
            characterDiffResult.dispatchUpdatesTo(adapter);
        }

    }

    @Override
    public void updateAdapter(List<CharacterResults> characters) {
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

            }
        });
    }

}