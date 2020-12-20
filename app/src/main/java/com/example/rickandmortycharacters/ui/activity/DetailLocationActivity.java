package com.example.rickandmortycharacters.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.adapter.adapter.CharacterAdapter;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.model.DetailLocation.DetailLocation;
import com.example.rickandmortycharacters.presentations.presenter.DetailLocationPresenter;
import com.example.rickandmortycharacters.presentations.view.DetailLocationView;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class DetailLocationActivity extends MvpAppCompatActivity implements DetailLocationView {

    @InjectPresenter
    DetailLocationPresenter presenter;

    CharacterAdapter adapter = null;
    private RecyclerView residentsRecycleView;
    private LinearLayoutManager manager;

    private TextView locationName, locationType, locationDemention, locationResidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);

        locationName = (TextView) findViewById(R.id.location_name);
        locationType = (TextView) findViewById(R.id.location_type);
        locationDemention = (TextView) findViewById(R.id.location_demention);
        locationResidents = (TextView) findViewById(R.id.location_residents_text_view);

        residentsRecycleView = (RecyclerView) findViewById(R.id.location_residents_recycler_view);

        manager = new LinearLayoutManager(this);
        residentsRecycleView.setLayoutManager(manager);
    }

    @Override
    public void showLocation(DetailLocation detailLocation) {
        locationName.setText(detailLocation.getName());
        locationType.setText(detailLocation.getType());
        locationDemention.setText(detailLocation.getDimension());
    }

    @Override
    public void setCharacterAdapter(List<CharacterResults> characterResults) {
        if (adapter == null)
        adapter = new CharacterAdapter(this, characterResults);
        residentsRecycleView.setAdapter(adapter);
    }
}