package com.example.rickandmortycharacters.presentations.view;

import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void setAdapter(List<CharacterResults> characters);

}
