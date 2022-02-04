package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movinder_project.Model.Database;
import com.example.movinder_project.Model.Utilisateur;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "API";
    private UtilisateurPlaceHolderAPI myUtilisayeurPlaceHolderAPI;
    List<Utilisateur> posts;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database db = new Database();
        db.connect();
    }

    public void tryToLog(View view) {
        EditText editTextUsername = findViewById(R.id.userLogin);
        String username = editTextUsername.getText().toString();

        EditText editTextPassword = findViewById(R.id.userPassword);
        String password = editTextPassword.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisayeurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);
        get_user_test_credential(username , password);
    }

    public void get_user_test_credential(String username, String password)
    {
        context = this;
        Call<List<Utilisateur>> call = myUtilisayeurPlaceHolderAPI.getUser(username , password);
        call.enqueue(new Callback<List<Utilisateur>>() {
            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Got something");
                     posts = response.body();
                    Utilisateur user = posts.get(0);
                    Intent i = new Intent(context, Match.class);
                    i.putExtra("idUser", user.getId_utilisateur());
                    startActivity(i);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Le login ou le mot de passe est incorrect";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Context context = getApplicationContext();
                CharSequence text = "Le login ou le mot de passe est incorrect";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}