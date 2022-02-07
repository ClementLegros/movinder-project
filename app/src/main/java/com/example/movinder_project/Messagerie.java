package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.movinder_project.Model.ConversationPlaceHolderAPI;
import com.example.movinder_project.Model.Film;
import com.example.movinder_project.Model.FilmPlaceHolderAPI;
import com.example.movinder_project.Model.Message;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Messagerie extends AppCompatActivity {

    private int idUser;
    private int idConversation;
    private ConversationPlaceHolderAPI myConversationPlaceHolderAPI;

    private LinearLayout l_layout;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);

        l_layout = (LinearLayout) findViewById(R.id.linear_layout_message);
        l_layout.setOrientation(LinearLayout.VERTICAL);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            this.idUser = extras.getInt("idUser");
            this.idConversation = extras.getInt("getConversation");
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themovinder.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myConversationPlaceHolderAPI = retrofit.create(ConversationPlaceHolderAPI.class);
        //fetchMessage();

        Timer timerObj = new Timer();
        TimerTask timerTaskObj = new TimerTask() {
            public void run() {
                fetchMessage();
            }
        };
        timerObj.schedule(timerTaskObj, 0, 15000);
    }

    void fetchMessage()
    {
        context = this;
        Call<List<Message>> call = myConversationPlaceHolderAPI.getMessage(idConversation);
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful()) {
                    Log.d("API", "Reponse des messages");
                    List<Message> listMessagerie = response.body();
                    Log.d("API", String.valueOf(listMessagerie.size()));

                    for(Message m: listMessagerie)
                    {
                        Log.d("API", m.getMessage());
                        Button btn1 = new Button(context);
                        btn1.setText(m.getMessage());
                        l_layout.addView(btn1);
                    }


                } else {
                    Log.d("API", "Casser un truc");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.d("Success", "Casser un truc²");
            }
        });
    }
}