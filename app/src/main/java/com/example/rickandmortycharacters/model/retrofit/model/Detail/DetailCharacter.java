package com.example.rickandmortycharacters.model.retrofit.model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailCharacter {

    @SerializedName("info")
    @Expose
    private DetailInfo info;

    @SerializedName("results")
    @Expose
    private List<DetailResults> results = null;

    public DetailInfo getInfo() {
        return info;
    }

    public List<DetailResults> getResults() {
        return results;
    }

}

