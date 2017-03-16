package com.example.julian.rentnertreff.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

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
        kategorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new KategorieFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        //Platz für weitere Listener

        return view;
    }


}
