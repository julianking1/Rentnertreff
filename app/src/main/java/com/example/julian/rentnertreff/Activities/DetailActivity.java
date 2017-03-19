package com.example.julian.rentnertreff.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import com.example.julian.rentnertreff.Fragments.DetailSubfragment_Details;
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
        spec.setIndicator("Details");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("3");
        spec.setContent(R.id.Tab3);
        spec.setIndicator("Irgendwas");
        host.addTab(spec);

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {
                Fragment fragment1 = new DetailSubfragment_Fakten();
                getSupportFragmentManager().beginTransaction().add(R.id.content_tab1, fragment1).commit();


            }
        });

        //return inflater.inflate(R.layout.fragment_detail, container, false);
    }


}

