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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.Calendar.MONDAY;


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
        getActivity().setTitle("Mein Kalender");

        calendar = (CalendarView) view.findViewById(R.id.calendarView);
        calendar.setFirstDayOfWeek(MONDAY);

        db = new DatabaseHandler(getContext());

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(CalendarView cv, int y, int m, int d) {

                Date date = java.sql.Date.valueOf(""+y+"-"+(m+1)+"-"+d);
                events = db.getCertainEvents(date);

                ListFragment listFragment = new ListFragment();
                listFragment.setList(events);

                if(events.isEmpty()){
                    TextView tv = (TextView) view.findViewById(R.id.text);
                    tv.setText("Keine Events für diesen Tag");
                    view.findViewById(R.id.calendar_container).setVisibility(View.INVISIBLE);
                }else {
                    view.findViewById(R.id.calendar_container).setVisibility(View.VISIBLE);
                    getFragmentManager().beginTransaction().replace(R.id.calendar_container, listFragment).commit();
                }

            }
        });



        return view;
    }



}
