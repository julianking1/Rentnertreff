package com.example.julian.rentnertreff.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

public class DetailSubfragment_reservieren extends Fragment {

    //Variablen
    private View view;
    private Button button;
    public Event event;
    private TextView preis;
    private TextView  teilnehmer;
    private TextView freie;

    public DetailSubfragment_reservieren() {
        // Required empty public constructor
    }

    //Eventübergabe
    public void setEvent(Event event){
        this.event = event;
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_reservieren, container, false);

        //Layouts holen
        preis = (TextView) view.findViewById(R.id.preis);
        teilnehmer = (TextView) view.findViewById(R.id.anzahlTeilnehmer);
        freie = (TextView) view.findViewById(R.id.freiePlaetze);

        //Strings einfügen
        preis.setText("Preis: " + event.getPrice()+ "0 €");
        int members = event.getMembers();
        int max = event.getMaxMembers();
        freie.setText("Freie Plätze: " + (members));
        teilnehmer.setText("Teilnehmer: "+ max);

        button= (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Läuft");
                //event.setParticipation_planned(0);
                //event.setMembers(event.getMembers()+1);
                freie.setText("aha");
            }
        });



        return view;

    }

}
