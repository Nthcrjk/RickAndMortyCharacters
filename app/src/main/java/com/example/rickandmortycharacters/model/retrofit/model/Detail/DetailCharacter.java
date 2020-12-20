package com.example.rickandmortycharacters.model.retrofit.model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailCharacter {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("species")
    @Expose
    private String species;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("origin")
    @Expose
    private DetailCharacterLocation origin;

    @SerializedName("location")
    @Expose
    private DetailCharacterLocation location;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("episode")
    @Expose
    private List<String> episode;

    @SerializedName("created")
    @Expose
    private String created;

    public int getId() {
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

    public DetailCharacterLocation getOrigin() {
        return origin;
    }

    public DetailCharacterLocation getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public String getCreated() {
        return created;
    }
}
