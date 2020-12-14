package com.example.rickandmortycharacters.model.retrofit.api;

import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface JsonApi {
    @GET("character")
    Observable<DetailCharacter> getDetailCharacters();
}
