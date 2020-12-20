package com.example.rickandmortycharacters.model.retrofit.model.DetailLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailLocation {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("dimension")
    @Expose
    private String dimension;

    @SerializedName("residents")
    @Expose
    private List<String> residents;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public List<String> getResidents() {
        return residents;
    }
}
