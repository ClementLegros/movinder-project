package com.example.movinder_project.Model;

import java.util.List;

import javax.xml.transform.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmPlaceHolderAPI {
    @GET("/films")
    Call<List<Film>> getsFilms();
}
