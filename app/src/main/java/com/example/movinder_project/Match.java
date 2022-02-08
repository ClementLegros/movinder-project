package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movinder_project.Model.Conversation;
import com.example.movinder_project.Model.Film;
import com.example.movinder_project.Model.FilmPlaceHolderAPI;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Random;

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
    public List<Film> movieList;
    private UtilisateurPlaceHolderAPI myUtilisateurPlaceHolderAPI;

    private int indexFilm;
    private List<Integer> listIdFilm;
    private int idFilmActuelle;
    private ImageView imgViewMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            this.idUser = extras.getInt("idUser");
        }

        imgViewMovie = findViewById(R.id.imageViewFilm);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myFilmPlaceHolderAPI = retrofit.create(FilmPlaceHolderAPI.class);
        get_movies();

        indexFilm = 0;

    }

    void get_movies() {
        context = this;
        Call<List<Film>> call = myFilmPlaceHolderAPI.getsFilms();
        call.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Reponse des films");
                    movieList = response.body();

                    Film filmFetch = movieList.get(indexFilm);
                    idFilmActuelle = filmFetch.getId_film();
                    Picasso.get().load(filmFetch.getAffiche()).into(imgViewMovie);

                    indexFilm += 1;

                    //afficherFilmForMatch();²
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

    public void afficherFilmSuivant()
    {
        if(indexFilm == 4)
        {
            //Intent i = new Intent(this, "lol");
            //startActivity(i);
        }

        Film filmFetch = movieList.get(indexFilm);
        idFilmActuelle = filmFetch.getId_film();
        Picasso.get().load(filmFetch.getAffiche()).into(imgViewMovie);

        indexFilm += 1;

    }



    //#region buttonMovie

    public void likeMovie(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisateurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);
        movieLikedOrNot(true);

        afficherFilmSuivant();
    }

    public void dontLikeMovie(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisateurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);
        movieLikedOrNot(false);

        afficherFilmSuivant();
    }

    public void notSeenMovie(View view) {

        afficherFilmSuivant();
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


    //#endregion
}