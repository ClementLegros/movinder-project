package com.example.movinder_project.Model;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmPlaceHolderAPI {
    @GET("/discover/movie?sort_by=popularity.desc&api_key=04c35731a5ee918f014970082a0088b1&page=1")
    Call<Result> getsFilms();
}
