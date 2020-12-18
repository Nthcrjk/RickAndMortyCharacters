package com.example.rickandmortycharacters.model.retrofit.api;

import com.example.rickandmortycharacters.model.retrofit.model.CharacterInfo.CharacterInfo;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterList;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonApi {

    @GET("character")
    Call<CharacterInfo> getInfo(@Query("page") int page);

    @GET("character")
    Observable<CharacterList> getCharacterList(@Query("page") int page);

    @GET("character/{id}")
    Observable<DetailCharacter> getCharacterById(@Path("id") String id);
}
