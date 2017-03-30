package com.example.julian.rentnertreff.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julian.rentnertreff.R;

public class Registrieren_Activity extends AppCompatActivity {

    private SeekBar umkreisControl;
    private TextView umkreisView;
    private Button button;
    private TextView fehlermeldung;

    private EditText email;
    private EditText password;
    private EditText wohnort;
    private EditText name;
    private int progressChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);


        umkreisView = (TextView) findViewById(R.id.textView_umkreis);



        umkreisControl = (SeekBar) findViewById(R.id.seekBar_umkreis);
        umkreisControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                umkreisView.setText(progressChanged + " km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button = (Button) findViewById(R.id.button_register_registrieren);
        name = (EditText) findViewById(R.id.edit_register_name);
        wohnort =  (EditText) findViewById(R.id.edit_register_wohnort) ;
        email = (EditText) findViewById(R.id.edit_register_mail) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (proofName(name.getText().toString()) && proofMail(email.getText().toString()) && proofPassword(password.getText().toString()) && proofLocation(wohnort.getText().toString())  && proofSurrounding(progressChanged)){
                    Intent intent = new Intent(Registrieren_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    public boolean proofMail(String email) {
        fehlermeldung = (TextView) findViewById(R.id.register_fehlermeldung);
        if (email.contains("@")){
            return true;
        }else {
            fehlermeldung.setText("e-Mail Adresse muss ein @ enthalten");
            return false;
        }
    }


    public boolean proofPassword (String password){
        fehlermeldung = (TextView) findViewById(R.id.register_fehlermeldung);

        if (password.length() > 6 ){
            return true;
        }else {
            fehlermeldung.setText("Passwort muss mindestens 6 Zeichen lang sein!");
            return false;
        }
    }

    public boolean proofName (String name){
        fehlermeldung = (TextView) findViewById(R.id.register_fehlermeldung);

        if (name.length() > 0 ){
            return true;
        }else {
            fehlermeldung.setText("Name darf nicht leer sein!");
            return false;
        }
    }

    public boolean proofLocation (String location){
        fehlermeldung = (TextView) findViewById(R.id.register_fehlermeldung);

        if (location.length() > 0 ){
            return true;
        }else {
            fehlermeldung.setText("Name darf nicht leer sein!");
            return false;
        }
    }

    public boolean proofSurrounding (int surronding){
        fehlermeldung = (TextView) findViewById(R.id.register_fehlermeldung);

        if (surronding > 0 ){
            return true;
        }else {
            fehlermeldung.setText("Ein Umkreis von unter 1 km ist nicht empfehlenswert!");
            return false;
        }
    }






}
