package com.example.rickandmortycharacters.model.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Character {

    @SerializedName("info")
    @Expose
    private Info info;

    @SerializedName("results")
    @Expose
    public List<Results> results = null;

    public Info getInfo() {
        return info;
    }

    public List<Results> getResults() {
        return results;
    }
}

