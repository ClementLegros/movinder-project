package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.movinder_project.Model.Film;
import com.example.movinder_project.Model.FilmPlaceHolderAPI;
import com.example.movinder_project.Model.InputStreamOperations;
import com.example.movinder_project.Model.MySingleton;
import com.example.movinder_project.Model.Utilisateur;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Match extends AppCompatActivity {

    private int idUser;
    private FilmPlaceHolderAPI myFilmPlaceHolderAPI;
    private Context context;
    private List<Film> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        this.idUser = 999;
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            this.idUser = extras.getInt("idUser");
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myFilmPlaceHolderAPI = retrofit.create(FilmPlaceHolderAPI.class);


        get_movies();

    }

    void get_movies() {
        Call<List<Film>> call = myFilmPlaceHolderAPI.getsFilms();
        call.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Reponse des films");
                } else {
                    Log.d("Success", "Casser un truc");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.d("Success", "Casser un truc²");
            }
        });
    }

}