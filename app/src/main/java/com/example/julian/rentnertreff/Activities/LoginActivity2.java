package com.example.julian.rentnertreff.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.julian.rentnertreff.R;

public class LoginActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        setTitle("Willkommen");
    }

    public void register (View view){
        Intent intent = new Intent(LoginActivity2.this, Registrieren_Activity.class);
        startActivity(intent);
    }
}
