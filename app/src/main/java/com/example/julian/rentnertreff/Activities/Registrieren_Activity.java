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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        button = (Button) findViewById(R.id.button_register_registrieren);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrieren_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

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
    }



}
