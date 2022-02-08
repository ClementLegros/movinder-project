package com.example.movinder_project.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MatchResultPlaceHolderAPI {
    @GET("/match/{idUtilisateur}")
    Call<List<MatchResult>> getMatchResult(@Path(value = "idUtilisateur", encoded = false)int idUtilisateur);




}
