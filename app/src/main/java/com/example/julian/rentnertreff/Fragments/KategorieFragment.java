package com.example.julian.rentnertreff.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.julian.rentnertreff.Activities.DetailActivity;
import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KategorieFragment extends Fragment{

    View view;
    DatabaseHandler db;
    List<Event> events;


    public KategorieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_kategorie, container, false);

        LinearLayout kultur = (LinearLayout) view.findViewById(R.id.kulturLayout);
        LinearLayout  natur = (LinearLayout) view.findViewById(R.id.naturLayout);
        LinearLayout  sport = (LinearLayout) view.findViewById(R.id.sportLayout);
        LinearLayout  unterhaltung= (LinearLayout) view.findViewById(R.id.unterhaltungLayout);
        LinearLayout  alltag= (LinearLayout) view.findViewById(R.id.alltagLayout);
        LinearLayout  gehirnjogging= (LinearLayout) view.findViewById(R.id.gehirnjoggingLayout);

        getActivity().setTitle("Kategorien");



        db = new DatabaseHandler(getContext());

        unterhaltung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getAllEventsFromCategory("Unterhaltung");
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Unterhaltung");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });

        natur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getAllEventsFromCategory("Natur");
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Natur");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getAllEventsFromCategory("Sport");
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Sport");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });

        gehirnjogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getAllEventsFromCategory("Gehirnjogging");
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Gehirnjogging");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });

        alltag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getAllEventsFromCategory("Alltag");
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Alltag");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });

        kultur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events = db.getAllEventsFromCategory("Kultur");
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getActivity().setTitle("Kultur");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();
            }
        });


        return view;
    }



}
