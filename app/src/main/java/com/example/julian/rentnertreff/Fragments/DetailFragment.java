package com.example.julian.rentnertreff.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost.*;

import com.example.julian.rentnertreff.R;

public class DetailFragment extends Fragment implements View.OnClickListener {

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        //hier wird das SubFragment eingefügt
        Fragment fragment1 = new DetailSubFragment_reservieren();
        getChildFragmentManager().beginTransaction().add(R.id.detail_subcontainer, fragment1).commit();

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onClick(View v) {
    }

}

