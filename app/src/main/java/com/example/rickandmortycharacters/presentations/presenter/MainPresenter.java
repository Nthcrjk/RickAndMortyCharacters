package com.example.rickandmortycharacters.presentations.presenter;

import com.example.rickandmortycharacters.model.retrofit.CharactersService;
import com.example.rickandmortycharacters.presentations.view.MainView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public MainPresenter(){

        CharactersService service = new CharactersService();
    }
}
