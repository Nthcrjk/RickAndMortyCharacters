package com.example.rickandmortycharacters.model.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }
}
