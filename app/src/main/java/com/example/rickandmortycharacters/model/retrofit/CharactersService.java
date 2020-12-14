package com.example.rickandmortycharacters.model.retrofit;

import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.CharacterJsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.Character;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharactersService {

    public final String TAG = "meow";
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";


    public CharactersService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CharacterJsonApi api = retrofit.create(CharacterJsonApi.class);
        Call<Character> call = api.getCharacters();
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Log.e(TAG, Integer.toString(response.body().getInfo().getCount()));
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });




    }
}
