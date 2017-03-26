package com.example.julian.rentnertreff.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

public class DetailSubfragment_bewerten extends Fragment {

    //Variablen
    private View view;
    private RatingBar bar;
    public Event event;


    public DetailSubfragment_bewerten() {
        // Required empty public constructor
    }

    //Eventübergabe
    public void setEvent(Event event){
        this.event = event;
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_subfragment_bewerten, container, false);

        bar = (RatingBar)view.findViewById(R.id.bewertung);
        bar.setNumStars(5);
        bar.setRating(3);
        bar.setStepSize(1);
        bar.setIsIndicator(false);

        return view;
    }

    //hier wird das Rating übergeben
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        int bewertung = (int) rating;
    }

}