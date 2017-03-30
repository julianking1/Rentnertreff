package com.example.julian.rentnertreff.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.julian.rentnertreff.Activities.DetailActivity;
import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

import java.util.List;

import static android.R.id.toggle;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View view;
    List<Event> events;
    DatabaseHandler db;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view  = inflater.inflate(R.layout.fragment_main, container, false);
        db = new DatabaseHandler(getContext());

        getActivity().setTitle("Rentnertreff");


        LinearLayout kategorie = (LinearLayout) view.findViewById(R.id.kategorieLayout);
        LinearLayout demnaechst = (LinearLayout) view.findViewById(R.id. DemnaechstLayout);
        LinearLayout meinKalender = (LinearLayout) view.findViewById(R.id. MeinKalender_Layout);
        LinearLayout bewertung = (LinearLayout) view.findViewById(R.id. Bewertung_Layout);


        kategorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new KategorieFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("main_fragment").commit();
            }
        });

        demnaechst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getComingEvents();
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                listFragment.setCreatedForDemnaechst(true);
                getActivity().setTitle("Demnächst");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();            }
        });

        bewertung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getEventsParticipated();
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Wie war's?");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });

        meinKalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                events = db.getEventsParticipationPlanned();
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Mein Kalender");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
                */
                Fragment fragment = new Calender();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("main_fragment").commit();
            }
        });





        //Platz für weitere Listener

        return view;
    }


}
