package com.example.julian.rentnertreff.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.EventAdapter;
import com.example.julian.rentnertreff.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment{

    View view;
    List<Event> event_list;
    ArrayList<String> title_list;
    EventAdapter eventAdapter;


    public ListFragment() {
        // Required empty public constructor
    }

    public void setList(List<Event> list){
        this.event_list = list;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);

        title_list = new ArrayList<String>();

        //add each title to arraylist
        /*for (Event e : event_list) {
            title_list.add(e.getTitle());
        }*/


        ListView lv = (ListView) view.findViewById(R.id.listView_events);

        eventAdapter = new EventAdapter(getActivity(), event_list);
        lv.setAdapter(eventAdapter);





        //ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, title_list);
        //lv.setAdapter(arrayAdapter);




        return view;
    }


}
