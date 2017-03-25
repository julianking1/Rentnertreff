package com.example.julian.rentnertreff.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;


public class DetailSubfragment_Fakten extends Fragment {

    //Variablen
    public Event event;
    public View view;
    public TextView essen;
    public TextView rollstuhlgerecht;
    public TextView haustiere;
    public TextView sonstiges;
    String strEssen;
    String strRollstuhlgerecht;
    String strHaustiere;

    public DetailSubfragment_Fakten() {
        // Required empty public constructor
    }

    //Eventübergabe
    public void setEvent(Event event){
        this.event = event;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_subfragment__fakten, container, false);

        //Views holen
        essen = (TextView) view.findViewById(R.id.essen);
        rollstuhlgerecht = (TextView) view.findViewById(R.id.rollstuhlgerecht);
        haustiere = (TextView) view.findViewById(R.id.haustiere);
        sonstiges = (TextView) view.findViewById(R.id.sonstiges);

        //Stringwerte berechnen
        if(event.isFood()==1){
            strEssen = "Verpflegung mitbringen";
        } else{
            strEssen = "Verpflegung inklusive";
        }
        if(event.isDisabled()==1){
            strRollstuhlgerecht = "Rollstuhlgerecht Veranstaltung";
        } else{
            strRollstuhlgerecht = "Die Veranstaltung ist nicht rollstuhlgerecht.";
        }
        if(event.isDogs()==1){
            strHaustiere = "Hunde dürfen mitgebracht werden.";
        } else{
            strHaustiere= "Es sind keine Hunde erlaubt";
        }


        //Strings einfügen
        essen.setText(strEssen);
        rollstuhlgerecht.setText(strRollstuhlgerecht);
        haustiere.setText(strHaustiere);
        sonstiges.setText(event.getInfo());

        return view;
    }
}
