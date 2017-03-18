package com.example.julian.rentnertreff.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.julian.rentnertreff.R;


public class DetailSubfragment_Fakten extends Fragment {

    public DetailSubfragment_Fakten() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_subfragment__fakten, container, false);
    }
}
