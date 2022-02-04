package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movinder_project.Model.Film;
import com.example.movinder_project.Model.FilmPlaceHolderAPI;
import com.example.movinder_project.Model.InputStreamOperations;
import com.example.movinder_project.Model.Utilisateur;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

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

        ArrayList<Film> listFilm = get_movies();
        Film f1 = listFilm.get(0);
        Context context = getApplicationContext();
        CharSequence text = String.valueOf(f1.getId());
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public ArrayList<Film> get_movies()
    {
        ArrayList<Film> listFilm = new ArrayList<Film>();

        try {
            String myurl= "https://api.themoviedb.org/3/movie/550?api_key=92727e623f9ba5a35f7e0b0ad09ea275";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperations.InputStreamToString(inputStream);

            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);
            // On récupère le tableau d'objets qui nous concernent
            JSONArray array = new JSONArray(jsonObject.getString("personnes"));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                // On fait le lien Personne - Objet JSON
                Film f = new Film(obj.getInt("id"));
                listFilm.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des personnes
        return listFilm;
    }
}