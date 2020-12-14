package com.example.rickandmortycharacters.model.retrofit.service;

import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.Character;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    public final String TAG = this.getClass().getName();
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";

    private Retrofit retrofit;
    private JsonApi api;
    private final Disposable[] disposables;

    public JsonApi getApi() {
        JsonApi api = retrofit.create(JsonApi.class);
        return api;
    }

    public Service() {
        disposables = new Disposable[1];
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
