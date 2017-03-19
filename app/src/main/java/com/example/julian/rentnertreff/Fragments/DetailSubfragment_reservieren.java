package com.example.julian.rentnertreff.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.julian.rentnertreff.R;

public class DetailSubfragment_reservieren extends Fragment {

    public DetailSubfragment_reservieren() {
        // Required empty public constructor
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_reservieren, container, false);
    }
}
