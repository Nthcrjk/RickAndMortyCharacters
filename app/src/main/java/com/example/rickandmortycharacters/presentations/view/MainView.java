package com.example.rickandmortycharacters.presentations.view;

import com.example.rickandmortycharacters.model.adapter.CharacterState;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void setAdapter(List<CharacterState> characters);

}
