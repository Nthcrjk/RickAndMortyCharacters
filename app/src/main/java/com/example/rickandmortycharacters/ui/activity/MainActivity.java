package com.example.rickandmortycharacters.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.adapter.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.adapter.diffutil.CharacterDiffUtilCallBack;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.presentations.presenter.MainPresenter;
import com.example.rickandmortycharacters.presentations.view.MainView;

import java.util.ArrayList;
import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    MainPresenter presenter;

    private CharacterAdapter adapter = null;
    private RecyclerView recyclerView;
    LinearLayoutManager manager;

    private boolean loading = true;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private List<List<CharacterResults>> listOfListsOfCharacters = new ArrayList<>();
    private int pagesLoaded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.character_recycle_view);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0)
                {
                    visibleItemCount = manager.getChildCount();
                    totalItemCount = manager.getItemCount();
                    pastVisiblesItems = manager.findFirstVisibleItemPosition();
                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.e("meow", "presenter.getMew())");
                            //adapter.getData().add(presenter.getLoadList().get(0));
                            adapter.getData().addAll(presenter.getLoadList());
                            adapter.notifyDataSetChanged();
                            pagesLoaded++;

                        }
                    }
                }
            }
        });
    }

    @Override
    public void setAdapter(List<CharacterResults> characters) {
        if (adapter == null){
            pagesLoaded++;
            adapter = new CharacterAdapter(this, characters);
            recyclerView.setAdapter(adapter);
        }

    }



}