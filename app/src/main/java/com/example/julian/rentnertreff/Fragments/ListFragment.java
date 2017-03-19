package com.example.julian.rentnertreff.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    View view;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);

        DatabaseHandler db = new DatabaseHandler(getContext());

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addEvent(new Event(1, "Titel", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2));
        db.addEvent(new Event(2, "Titel2", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2));
        db.addEvent(new Event(3, "Titel3", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2));
        db.addEvent(new Event(4, "Titel4", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2));


        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Event> events = db.getAllEventsFromCategory("Natur");

        ArrayList<String> titel = new ArrayList<>();

        for (Event e : events) {
            titel.add(e.getTitle());
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, titel);
        ListView lv = (ListView) view.findViewById(R.id.listView_events);

        lv.setAdapter(arrayAdapter);

        return view;
    }

}
