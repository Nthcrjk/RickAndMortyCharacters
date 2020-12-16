package com.example.rickandmortycharacters.model.retrofit.model.CharacterList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterInfo {
    @SerializedName("pages")
    @Expose
    private Integer pages;

    public Integer getPages() {
        return pages;
    }

}
