package com.example.rickandmortycharacters.model.retrofit.model.CharacterList;

import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailInfo;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailResults;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterList {
    @SerializedName("info")
    @Expose
    private CharacterInfo info;

    @SerializedName("results")
    @Expose
    private List<CharacterResults> results = null;

    public List<CharacterResults> getResults() {
        return results;
    }
}
