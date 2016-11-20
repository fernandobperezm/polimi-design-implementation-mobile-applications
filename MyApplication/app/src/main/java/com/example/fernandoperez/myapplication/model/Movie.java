package com.example.fernandoperez.myapplication.model;

/**
 * Created by fernandoperez on 10/20/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    @Expose
    @SerializedName("Title")
    private String title;

    @Expose
    @SerializedName("Director")
    private String directorName;

//    private String title;
//    private String directorName;
    public Movie() {}

    public Movie (String title, String directorName){
        this.title = title;
        this.directorName = directorName;
    }

    @Override
    public String toString(){
        return title + " - " + directorName;
    }

    public static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();

        //TODO: write down the movies list.
        return movies;

    }

    public String getTitle(){
        return this.title;
    }

    public String getDirector() {
        return this.directorName;
    }
}
