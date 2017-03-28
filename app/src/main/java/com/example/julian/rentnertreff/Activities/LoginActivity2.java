package com.example.julian.rentnertreff.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julian.rentnertreff.R;

import java.util.regex.Pattern;

public class LoginActivity2 extends AppCompatActivity {

    EditText email;
    EditText password;
    TextView fehlermeldung;

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

    public void login (View view){
        email = (EditText) findViewById(R.id.edit_login_mail);
        password = (EditText) findViewById(R.id.edit_login_password);
        if (proofMail(email.getText().toString()) && proofPassword(password.getText().toString())){
            Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
            startActivity(intent);
        }
    }


    public boolean proofMail(String email) {
        fehlermeldung = (TextView) findViewById(R.id.textView_login_fehlermeldung);
        if (email.contains("@")){
            return true;
        }else {
            fehlermeldung.setText("e-Mail Adresse muss ein @ enthalten");
            return false;
        }
    }


    public boolean proofPassword (String password){
        fehlermeldung = (TextView) findViewById(R.id.textView_login_fehlermeldung);

        if (password.length() > 6 ){
            return true;
        }else {
            fehlermeldung.setText("Passwort muss mindestens 6 Zeichen lang sein!");
            return false;
        }

    }
}
