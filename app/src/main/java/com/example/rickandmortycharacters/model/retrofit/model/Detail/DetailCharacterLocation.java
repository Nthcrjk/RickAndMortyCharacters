package com.example.rickandmortycharacters.model.retrofit.model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailCharacterLocation {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
