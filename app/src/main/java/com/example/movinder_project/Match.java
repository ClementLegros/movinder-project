package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.movinder_project.Model.Conversation;
import com.example.movinder_project.Model.Film;
import com.example.movinder_project.Model.FilmPlaceHolderAPI;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class Match extends AppCompatActivity {

    private int idUser;
    private FilmPlaceHolderAPI myFilmPlaceHolderAPI;
    private Context context;
    private List<Film> movieList;
    private UtilisateurPlaceHolderAPI myUtilisateurPlaceHolderAPI;

    private int idFilmActuelle;
    private Uri uriFilm;

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

    public void likeMovie(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisateurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);
        movieLikedOrNot(true);
    }

    public void dontLikeMovie(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisateurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);
        movieLikedOrNot(false);
    }

    void movieLikedOrNot(boolean avis)
    {
        Call<ResponseBody> call = myUtilisateurPlaceHolderAPI.registerLike(idUser, idFilmActuelle, avis);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("API", "Like insert");
                } else {
                    Log.d("API", "Like Failed");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("API", "The request API as a problem");
            }
        });
    }

    public void goToMessage(View view) {
        Intent i = new Intent(this, ConversationView.class);
        i.putExtra("idUser", idUser);
        startActivity(i);
    }
}