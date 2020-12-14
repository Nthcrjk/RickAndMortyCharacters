package com.example.rickandmortycharacters.model.retrofit.api;

import com.example.rickandmortycharacters.model.retrofit.model.Character;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterJsonApi {
    @GET("character")
    Call<Character> getCharacters();
}
