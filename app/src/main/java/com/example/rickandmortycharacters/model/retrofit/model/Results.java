package com.example.rickandmortycharacters.model.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("species")
    @Expose
    public String species;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("gender")
    @Expose
    public String gender;

    @SerializedName("origin")
    @Expose
    public Location origin;

    @SerializedName("location")
    @Expose
    public Location location;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("episode")
    @Expose
    public List<String> episode = null;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("created")
    @Expose
    public String created;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
