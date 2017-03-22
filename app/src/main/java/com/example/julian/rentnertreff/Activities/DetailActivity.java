package com.example.julian.rentnertreff.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Beschreibung;
import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Veranstalterinfo;
import com.example.julian.rentnertreff.Fragments.DetailSubfragment_reservieren;
import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Fakten;
import com.example.julian.rentnertreff.R;

public class DetailActivity extends AppCompatActivity {

    public DetailActivity() {
        // Required empty public constructor
    }

    //@Override
    //public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail);

        //hier wird das SubFragment eingefügt
        Fragment fragment = new DetailSubfragment_reservieren();
        getSupportFragmentManager().beginTransaction().add(R.id.detail_subcontainer, fragment).commit();


        //Tabhost
        TabHost host = (TabHost)findViewById(R.id.tabHost);
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
        spec.setIndicator("Beschreibung");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("3");
        spec.setContent(R.id.Tab3);
        spec.setIndicator("Veranstalter");
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
        getSupportFragmentManager().beginTransaction().add(R.id.content_tab1, fragment1).commit();
        Fragment fragment2 = new DetailSubfragment_Beschreibung();
        getSupportFragmentManager().beginTransaction().add(R.id.content_tab2, fragment2).commit();
        Fragment fragment3 = new DetailSubfragment_Veranstalterinfo();
        getSupportFragmentManager().beginTransaction().add(R.id.content_tab3, fragment3).commit();

        //vorichtshalber noch da.
        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {

            }
        });

        //return inflater.inflate(R.layout.fragment_detail, container, false);
    }


}

