package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;


import com.example.movinder_project.Model.MatchResult;
import com.example.movinder_project.Model.MatchResultPlaceHolderAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MatchResultView extends AppCompatActivity {
    MatchResultPlaceHolderAPI myMatchResultPlaceHolderAPI;
    private List<MatchResult> listMatchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         myMatchResultPlaceHolderAPI = retrofit.create(MatchResultPlaceHolderAPI.class);



        getMatchResult();
    }

    void getMatchResult()
    {

        Call<List<MatchResult>> call = myMatchResultPlaceHolderAPI.getMatchResult(1);

        call.enqueue(new Callback<List<MatchResult>>() {

            @Override
            public void onResponse(Call<List<MatchResult>> call, Response<List<MatchResult>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Reponse des MatchResult");


                } else {
                    Log.d("Success", "Casser un truc");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<MatchResult>> call, Throwable t) {
                Log.d("Success", "Casser un truc");
            }
        });
    }
}