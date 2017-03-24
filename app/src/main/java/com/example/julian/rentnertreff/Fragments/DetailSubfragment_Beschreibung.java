package com.example.julian.rentnertreff.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

public class DetailSubfragment_Beschreibung extends Fragment {

    //Variablen
    public Event event;

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
        return inflater.inflate(R.layout.fragment_detail_subfragment__beschreibung, container, false);
    }
}