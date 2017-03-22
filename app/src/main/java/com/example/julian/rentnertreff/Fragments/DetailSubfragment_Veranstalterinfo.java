package com.example.julian.rentnertreff.Fragments;

import com.example.julian.rentnertreff.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.julian.rentnertreff.R;

import static com.example.julian.rentnertreff.R.id.ratingBar;

public class DetailSubfragment_Veranstalterinfo extends Fragment implements RatingBar.OnRatingBarChangeListener{

    private View view;
    private RatingBar bar;

    public DetailSubfragment_Veranstalterinfo() {
        // Required empty public constructor
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_sub_fragment__veranstalterinfo, container, false);
        bar = (RatingBar)view.findViewById(R.id.ratingBar);
        bar.setNumStars(5);
        bar.setRating(1);
        bar.setStepSize(1);
        bar.setIsIndicator(true);

        return view;
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        //hier wird das Rating übergeben
    }
}
