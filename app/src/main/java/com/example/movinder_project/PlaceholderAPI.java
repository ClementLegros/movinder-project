package com.example.movinder_project;

import com.example.movinder_project.Model.Utilisateur;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderAPI {
    @GET("posts")
    Call<List<Utilisateur>> getPosts();

}
