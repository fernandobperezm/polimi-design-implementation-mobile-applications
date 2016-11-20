package com.example.fernandoperez.myapplication;

import android.view.ViewDebug;

import com.example.fernandoperez.myapplication.model.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fernandoperez on 10/27/16.
 */

public interface MovieRestService {


    @GET("/?")
    public Call<Movie> getMovie(@Query("i") String imbdID);

}
