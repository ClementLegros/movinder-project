package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movinder_project.Model.Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database db = new Database();
        db.connect();
    }

    public void goToRegister(View view) {
        Intent i = new Intent(this , Register.class);
        startActivity(i);
    }
}