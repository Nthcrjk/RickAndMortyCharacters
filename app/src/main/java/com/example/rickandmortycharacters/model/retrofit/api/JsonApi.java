package com.example.rickandmortycharacters.model.retrofit.api;

import com.example.rickandmortycharacters.model.retrofit.model.CharacterInfo.CharacterInfo;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterList;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;
import com.example.rickandmortycharacters.model.retrofit.model.DetailLocation.DetailLocation;
import com.example.rickandmortycharacters.model.retrofit.model.EpisodItem.EpisodeItem;

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
    Observable<DetailCharacter> getDetailCharacterById(@Path("id") String id);

    @GET("character/{id}")
    Observable<CharacterResults> getCharacterListById(@Path("id") String id);

    @GET("episode/{id}")
    Observable<EpisodeItem> getEpisodeById(@Path("id") String id);

    @GET("location/{id}")
    Observable<DetailLocation> getLocationById(@Path("id") String id);




}
