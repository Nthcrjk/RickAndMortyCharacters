package com.example.rickandmortycharacters.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.adapter.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.model.DetailEpisode.DetailEpisode;
import com.example.rickandmortycharacters.presentations.presenter.DetailEpisodePresenter;
import com.example.rickandmortycharacters.presentations.view.DetailEpisodeView;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class DetailEpisodeActivity extends MvpAppCompatActivity implements DetailEpisodeView {

    @InjectPresenter
    DetailEpisodePresenter presenter;

    CharacterAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager manager;

    private TextView detailEpisodeName, detailEpisodeAirDate, detailEpisodeEpisode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_episode);

        detailEpisodeName = (TextView) findViewById(R.id.detail_episode_name);
        detailEpisodeAirDate = (TextView) findViewById(R.id.detail_episode_air_date);
        detailEpisodeEpisode = (TextView) findViewById(R.id.detail_episode_episode);

        recyclerView = (RecyclerView) findViewById(R.id.detail_episode_recycle_view);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void showDetailEpisode(DetailEpisode detailEpisode) {
        detailEpisodeName.setText(detailEpisode.getName());
        detailEpisodeAirDate.setText(detailEpisode.getAir_date());
        detailEpisodeEpisode.setText(detailEpisode.getEpisode());
    }

    @Override
    public void setCharacterAdapter(List<CharacterResults> characterResults) {
        adapter = new CharacterAdapter(this, characterResults);
        recyclerView.setAdapter(adapter);
    }
}