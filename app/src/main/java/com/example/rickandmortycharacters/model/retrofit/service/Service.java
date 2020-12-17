package com.example.rickandmortycharacters.model.retrofit.service;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    public final String TAG = this.getClass().getName();
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";

    private Retrofit retrofit;
    private JsonApi api;

    public JsonApi getApi() {
        api = retrofit.create(JsonApi.class);
        return api;
    }

    public Service() {
        retrofit = createRetrofit();
    }

    private Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
