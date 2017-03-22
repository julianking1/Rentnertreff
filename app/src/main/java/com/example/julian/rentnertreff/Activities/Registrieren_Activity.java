package com.example.julian.rentnertreff.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.julian.rentnertreff.R;

public class Registrieren_Activity extends AppCompatActivity {

    private SeekBar umkreisControl;
    private TextView umkreisView;

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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                umkreisView.setText(progressChanged + " km");
            }
        });
    }
}
