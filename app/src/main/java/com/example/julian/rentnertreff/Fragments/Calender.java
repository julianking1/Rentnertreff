package com.example.julian.rentnertreff.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.EventAdapter;
import com.example.julian.rentnertreff.R;

import java.util.ArrayList;
import java.util.List;


public class Calender extends Fragment {

    private View view;
    private CalendarView calendar;
    DatabaseHandler db;
    List<Event> events;

    public Calender() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calender, container, false);
        calendar = (CalendarView) view.findViewById(R.id.calendarView);
        db = new DatabaseHandler(getContext());

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(CalendarView cv, int y, int m, int d) {
                String date = ""+y+"-"+m+"-"+d;
                TextView tv = (TextView) view.findViewById(R.id.text);
                tv.setText("Hier eine nützliche Info"+date);

                events = db.getEventsParticipationPlanned();
                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);
                getFragmentManager().beginTransaction().replace(R.id.calendar_container, listFragment).commit();
            }
        });



        return view;
    }



}
