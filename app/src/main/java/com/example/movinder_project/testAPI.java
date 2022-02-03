package com.example.movinder_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movinder_project.Model.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class testAPI extends AppCompatActivity {

    private TextView textView;
    private PlaceholderAPI myPlaceholderAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        textView = findViewById(R.id.tvId);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com/user")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myPlaceholderAPI = retrofit.create(PlaceholderAPI.class);
        get_all_posts();


    }

    void get_all_posts(){
        Call<List<Utilisateur>> call = myPlaceholderAPI.getPosts();
        call.enqueue(new Callback<List<Utilisateur>>() {

            @Override
            public void onResponse(Call<List<Utilisateur>> call,
                                   Response<List<Utilisateur>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Got something");
                    List<Utilisateur> posts = response.body();
                    for (Utilisateur u: posts) {
                        Log.d("Success", u.getNom());
                        String content = u.getIdUser() + "\n";
                        content += u.getE_mail() + "\n";
                        content += u.getNum() + "\n";
                        content += u.getMdp() + "\n";
                        content += u.getSexe() + "\n";
                        content+= u.getOrientation() + "\n\n";
                        textView.append(content);
                    }
                } else {
                    textView.setText("Code " + response.code());
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

}


