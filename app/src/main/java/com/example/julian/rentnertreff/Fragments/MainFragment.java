package com.example.julian.rentnertreff.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.julian.rentnertreff.Activities.DetailActivity;
import com.example.julian.rentnertreff.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View view;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        view  = inflater.inflate(R.layout.fragment_main, container, false);

        LinearLayout kategorie = (LinearLayout) view.findViewById(R.id.kategorieLayout);

        //die folgenden 3 habe ich ergänzt (Jana)
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
                //nur zum testen, eigentlich kommt hier ja die Listview (Jana)
                //Intent intent = new Intent(getActivity(), DetailActivity.class);
                //startActivity(intent);
                Fragment fragment = new Jana_Test();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("main_fragment").commit();
            }
        });

        bewertung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nur zum testen, eigentlich kommt hier ja die Listview (Jana)
                Fragment fragment = new ListFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("main_fragment").commit();
            }
        });



        //Platz für weitere Listener

        return view;
    }


}
