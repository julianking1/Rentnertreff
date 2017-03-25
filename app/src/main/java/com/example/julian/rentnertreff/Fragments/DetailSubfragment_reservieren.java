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
        freie = (TextView) view.findViewById(R.id.anzahlPlätze);
        teilnehmer = (TextView) view.findViewById(R.id.anzahlTeilnehmer);

        //Strings einfügen
        preis.setText("Preis: " + (int) event.getPrice()+ " €");
        int members = event.getMembers();
        int max = event.getMaxMembers();
        freie.setText(""+ (max - members));
        teilnehmer.setText(""+  members);

        button= (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(event.isParticipation_planned()==0) {
                    //prüfen ob maxTeilnehmerzahl erreicht wurde
                    event.setParticipation_planned(1);
                    freie.setText(""+(event.getMembers()-1));
                    teilnehmer.setText(""+(event.getMembers()+1));
                    //in DB
                    button.setText("Abmelden");
                }else{
                    event.setParticipation_planned(0);
                    freie.setText(""+(event.getMembers()));
                    teilnehmer.setText(""+(event.getMembers()));
                    //in DB
                    button.setText("Reservieren");
                }

            }
        });



        return view;

    }

}
