package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movinder_project.Model.Utilisateur;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    private UtilisateurPlaceHolderAPI myUtilisayeurPlaceHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void toRegister(View view) {

        /* A COMPLETER */

        EditText editTextNom = findViewById(R.id.editTextNom);
        EditText editTextPassword = findViewById(R.id.userPassword);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextTel = findViewById(R.id.editTextPhone);

        /* A COMPLETER */

        String nom = editTextNom.getText().toString();
        String password = editTextPassword.getText().toString();
        String email = editTextEmail.getText().toString();
        String tel = editTextTel.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisayeurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);

        //Lié la methode registerAPI
    }

    public void registerAPI(String nom, String password, String email, String num, String sexe, String orientation)
    {
        Call<ResponseBody> call = myUtilisayeurPlaceHolderAPI.registerUser(nom, email, num, password, sexe, orientation);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("API", "Register Success");
                } else {
                    Log.d("API", "Register Failed");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("API", "The request API as a problem");
            }
        });
    }

    //test commit

}