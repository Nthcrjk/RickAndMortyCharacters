package com.example.rickandmortycharacters.model.retrofit.service;

import com.example.rickandmortycharacters.model.retrofit.api.CharacterJsonApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    public final String TAG = this.getClass().getName();
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";

    private Retrofit retrofit;
    private CharacterJsonApi api;

    public CharacterJsonApi getApi() {
        return api;
    }

    public Service() {
        retrofit = createRetrofit();

        CharacterJsonApi api = retrofit.create(CharacterJsonApi.class);
    }

    private Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
