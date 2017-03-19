package com.example.julian.rentnertreff.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;

import com.example.julian.rentnertreff.Fragments.*;
import com.example.julian.rentnertreff.R;

public class TestJana extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_jana);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Tabhost
        TabHost host = (TabHost)findViewById(R.id.tabHost3);
        host.setup();

        host.getTabWidget().setVisibility(View.VISIBLE);

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Fakten1");
        spec.setContent(R.id.Fakten2);
        spec.setIndicator("Fakten");
        host.addTab(spec);

        //Tab 2

        spec = host.newTabSpec("Fakten2");
        spec.setContent(R.id.Fakten2);
        spec.setIndicator("Details");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Fakten3");
        spec.setContent(R.id.Fakten3);
        spec.setIndicator("Irgendwas");
        host.addTab(spec);

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {

                if(arg0.equals("Fakten2")){
                    Fragment fragment = new DetailSubfragment_Fakten();
                    getSupportFragmentManager().beginTransaction().replace(R.id.jana, fragment).commit();
                }


                }
        });

    }

}
