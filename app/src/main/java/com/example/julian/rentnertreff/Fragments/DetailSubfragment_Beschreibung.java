package com.example.julian.rentnertreff.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

public class DetailSubfragment_Beschreibung extends Fragment {

    //Variablen
    public View view;
    public Event event;
    public TextView beschreibung;

    public DetailSubfragment_Beschreibung() {
        // Required empty public constructor
    }

    //Eventübergabe
    public void setEvent(Event event){
        this.event = event;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_detail_subfragment__beschreibung, container, false);
        TextView beschreibung = (TextView) view.findViewById(R.id.beschreibung);
        beschreibung.setText(event.getDescription());

        return view;
    }
}