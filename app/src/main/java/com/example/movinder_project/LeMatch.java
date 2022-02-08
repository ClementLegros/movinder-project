package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.movinder_project.Model.MatchResult;
import com.example.movinder_project.Model.MatchResultPlaceHolderAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeMatch extends AppCompatActivity {

    private MatchResultPlaceHolderAPI myMatchResultPlaceHolderAPI;
    private List<MatchResult> listMatchResult;

    private int idUser;
    private LinearLayout linearLayoutMatch;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_match);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            this.idUser = extras.getInt("idUser");
        }

        linearLayoutMatch = findViewById(R.id.linear_layout_match);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myMatchResultPlaceHolderAPI = retrofit.create(MatchResultPlaceHolderAPI.class);

        getMatchResult();

    }

    void getMatchResult()
    {
        context = this;
        Call<List<MatchResult>> call = myMatchResultPlaceHolderAPI.getMatchResult(idUser);
        call.enqueue(new Callback<List<MatchResult>>() {

            @Override
            public void onResponse(Call<List<MatchResult>> call, Response<List<MatchResult>> response) {
                if (response.isSuccessful()) {
                    Log.d("API", "Reponse des MatchResult");
                    listMatchResult = response.body();
                    for(MatchResult r : listMatchResult)
                    {
                        Button btn1 = new Button(context);
                        btn1.setText("Match avec : " + r.getNom_utilisateur());
                        linearLayoutMatch.addView(btn1);
                    }
                } else {
                    Log.d("Success", "Casser un truc");
                    //return;
                }
            }
            @Override
            public void onFailure(Call<List<MatchResult>> call, Throwable t) {
                Log.d("Success", "Casser un truc");
            }
        });
    }
}