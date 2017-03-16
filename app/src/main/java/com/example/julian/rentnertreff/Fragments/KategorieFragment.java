package com.example.julian.rentnertreff.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.julian.rentnertreff.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KategorieFragment extends Fragment implements OnClickListener{


    public KategorieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategorie, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}
