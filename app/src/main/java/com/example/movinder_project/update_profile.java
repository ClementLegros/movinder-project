package com.example.movinder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        viewInitializations();
    }
    EditText etName, etLogin, etEmail, etNumero, etPasswod;
    final int MIN_PASSWORD_LENGTH = 6;


    void viewInitializations() {
        etName = findViewById(R.id.nom);
        etLogin = findViewById(R.id.et_login);
        etEmail = findViewById(R.id.et_email);
        etNumero = findViewById(R.id.et_numero);
        etPasswod = findViewById(R.id.etPasswod);

        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Checking if the input in form is valid
    boolean validateInput() {
        if (etName.getText().toString().equals("")) {
            etName.setError("Saisissez votre nom");
            return false;
        }
        if (etLogin.getText().toString().equals("")) {
            etLogin.setError("Saisissez votre login");
            return false;
        }
        if (etEmail.getText().toString().equals("")) {
            etEmail.setError("Saisissez votre mail");
            return false;
        }
        if (etNumero.getText().toString().equals("")) {
            etNumero.setError("Saisissez votre numéro de téléphone");
            return false;
        }
        if (etPasswod.getText().toString().equals("")) {
            etPasswod.setError("Saisissez votre mot de passe ");
            return false;
        }

        // checking the proper email format
        if (!isEmailValid(etEmail.getText().toString())) {
            etEmail.setError("Saisissez votre email valide");
            return false;
        }

        return true;
    }

    boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Hook Click Event

    public void performEditProfile (View v) {
        if (validateInput()) {

            // Input is valid, here send data to your server

            String firstName = etName.getText().toString();
            String lastName = etLogin.getText().toString();
            String email = etEmail.getText().toString();
            String contactNo = etNumero.getText().toString();
            String Designation = etPasswod.getText().toString();

            Toast.makeText(this,"Profil enregistré avec succès",Toast.LENGTH_SHORT).show();
            // Here you can call you API

        }
    }

}
