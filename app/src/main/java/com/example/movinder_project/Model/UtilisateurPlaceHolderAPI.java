package com.example.movinder_project.Model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UtilisateurPlaceHolderAPI {
    @GET("/user")
    Call<List<Utilisateur>> getsUsers();

    @GET("/login/{login}/{password}")
    Call<List<Utilisateur>> getUser(@Path(value="login", encoded=false) String login, @Path(value="password", encoded=false) String password);

    @FormUrlEncoded
    @POST("/registerUser")
    Call<ResponseBody> registerUser(@Field("nom") String nom, @Field("email") String email, @Field("num") String num, @Field("mdp") String mdp, @Field("sexe") String sexe, @Field("orientation") String orientation);

    @FormUrlEncoded
    @POST("/registerLike")
    Call<ResponseBody> registerLike(@Field("idUser") int idUser, @Field("idFilm") int idFilm, @Field("avis") boolean avis);

}
