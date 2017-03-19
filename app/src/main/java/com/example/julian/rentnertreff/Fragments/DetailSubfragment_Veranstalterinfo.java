package com.example.julian.rentnertreff.Fragments;

import com.example.julian.rentnertreff.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.julian.rentnertreff.R;

public class DetailSubfragment_Veranstalterinfo extends Fragment {

    public DetailSubfragment_Veranstalterinfo() {
        // Required empty public constructor
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_sub_fragment__veranstalterinfo, container, false);
    }
}
