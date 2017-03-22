package com.example.julian.rentnertreff.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Beschreibung;
import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Veranstalterinfo;
import com.example.julian.rentnertreff.Fragments.DetailSubfragment_reservieren;
import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Fakten;
import com.example.julian.rentnertreff.R;

public class Jana_Test extends Fragment {

    private View view;
    private TabHost host;

    public Jana_Test() {
        // Required empty public constructor
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);

        Fragment fragment = new DetailSubfragment_reservieren();
        getFragmentManager().beginTransaction().add(R.id.detail_subcontainer, fragment).commit();

        host = (TabHost)view.findViewById(R.id.tabHost);
        host.setup();
        host.getTabWidget().setVisibility(View.VISIBLE);

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("1");
        spec.setContent(R.id.Tab1);
        spec.setIndicator("Fakten");
        host.addTab(spec);

        //Tab 2

        spec = host.newTabSpec("2");
        spec.setContent(R.id.Tab2);
        spec.setIndicator("Details");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("3");
        spec.setContent(R.id.Tab3);
        spec.setIndicator("Kontakt");
        host.addTab(spec);

        final TabWidget tw = (TabWidget)host.findViewById(android.R.id.tabs);
        for (int i = 0; i < tw.getChildCount(); ++i)
        {
            final View tabView = tw.getChildTabViewAt(i);
            final TextView tv = (TextView)tabView.findViewById(android.R.id.title);
            tv.setTextSize(13);
            tv.setPadding(1,1,1,1);
        }


        Fragment fragment1 = new DetailSubfragment_Fakten();
        getFragmentManager().beginTransaction().add(R.id.content_tab1, fragment1).commit();
        Fragment fragment2 = new DetailSubfragment_Beschreibung();
        getFragmentManager().beginTransaction().add(R.id.content_tab2, fragment2).commit();
        Fragment fragment3 = new DetailSubfragment_Veranstalterinfo();
        getFragmentManager().beginTransaction().add(R.id.content_tab3, fragment3).commit();

        //vorichtshalber noch da.
        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {

            }

        });

        return view;
    }



}


