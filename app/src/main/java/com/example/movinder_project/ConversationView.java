package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.movinder_project.Model.Conversation;
import com.example.movinder_project.Model.ConversationPlaceHolderAPI;
import com.example.movinder_project.Model.Utilisateur;

import java.util.List;

import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConversationView extends AppCompatActivity {
    private int idUser;
    private ConversationPlaceHolderAPI myConversationPlaceHolderAPI;
    private LinearLayout l_layout;
    private Context context;
    private List<Conversation> listConversation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        l_layout = (LinearLayout) findViewById(R.id.linear_layout_conversation);
        l_layout.setOrientation(LinearLayout.VERTICAL);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            this.idUser = extras.getInt("idUser");
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myConversationPlaceHolderAPI = retrofit.create(ConversationPlaceHolderAPI.class);



        getConversation();
    }

    void getConversation()
    {
        context = this;
        Call<List<Conversation>> call = myConversationPlaceHolderAPI.getsConversation(idUser);
        call.enqueue(new Callback<List<Conversation>>() {
            @Override
            public void onResponse(Call<List<Conversation>> call, Response<List<Conversation>> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "Reponse des conversations");
                    listConversation = response.body();

                    for(Conversation c: listConversation)
                    {
                        Button btn1 = new Button(context);
                        btn1.setText("Conversation numéro : " + c.getId_conversation());
                        l_layout.addView(btn1);

                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // put code on click operation
                                Intent i = new Intent(context, Messagerie.class);
                                i.putExtra("idUser", idUser);
                                i.putExtra("idConversation", c.getId_conversation());
                                startActivity(i);
                            }
                        });
                    }
                } else {
                    Log.d("Success", "Casser un truc");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<Conversation>> call, Throwable t) {
                Log.d("Success", "Casser un truc²");
            }
        });
        //getPersonneConversation();
    }

    /*
    void getPersonneConversation()
    {

        for(Conversation c: listConversation)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://themovinder.herokuapp.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myConversationPlaceHolderAPI = retrofit.create(ConversationPlaceHolderAPI.class);

            Call<List<Utilisateur>> call = myConversationPlaceHolderAPI.getsConversationUtilisateur(idUser, c.getId_conversation());

            call.enqueue(new Callback<List<Utilisateur>>() {
                @Override
                public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                    if (response.isSuccessful()) {
                        Log.d("API", "User Conversation Success");
                        List<Utilisateur> listUser = response.body();
                        Utilisateur user = listUser.get(0);
                        Button btn1 = new Button(context);
                        btn1.setText("Afficher la conversation avec " + user.getNom_utilisateur());
                        l_layout.addView(btn1);
                    } else {
                        Log.d("API", "User Conversation Failed");
                    }
                }
                @Override
                public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                    Log.d("API", "The request API as a problem");
                }
            });
        }

    }
    */



}