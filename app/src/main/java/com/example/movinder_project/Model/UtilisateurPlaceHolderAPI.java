package com.example.movinder_project.Model;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UtilisateurPlaceHolderAPI {
    @GET("/user")
    Call<List<Utilisateur>> getsUsers();

    @GET("/login/{login}/{password}")
    Call<List<Utilisateur>> getUser(@Path(value="login", encoded=false) String login, @Path(value="password", encoded=false) String password);
}
