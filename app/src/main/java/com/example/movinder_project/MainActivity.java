package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.movinder_project.Model.Database;
import com.example.movinder_project.Model.Utilisateur;
import com.example.movinder_project.Model.UtilisateurPlaceHolderAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private static final String TAG = "API";
    private UtilisateurPlaceHolderAPI myUtilisayeurPlaceHolderAPI;


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

        String url ="https://themovinder.herokuapp.com/login/Albert/123456";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myUtilisayeurPlaceHolderAPI = retrofit.create(UtilisateurPlaceHolderAPI.class);
        get_user_test_credential(username , password);
    }

    void get_user_test_credential(String username, String password)
    {
        Call<List<Utilisateur>> call = myUtilisayeurPlaceHolderAPI.getUser(username , password);
        call.enqueue(new Callback<List<Utilisateur>>() {
            @Override
            public void onResponse(Call<List<Utilisateur>> call, retrofit2.Response<List<Utilisateur>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Got something");
                    List<Utilisateur> posts = response.body();
                    for(Utilisateur u: posts)
                    {
                        Context context = getApplicationContext();
                        CharSequence text = u.getOrientation();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                } else {
                    //textView.setText("Code " + response.code());
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
                //extView.setText(t.getMessage());
                Context context = getApplicationContext();
                CharSequence text = "Le login ou le mot de passe est incorrect";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}