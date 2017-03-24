package com.example.julian.rentnertreff.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.Fragments.KategorieFragment;
import com.example.julian.rentnertreff.Fragments.MainFragment;
import com.example.julian.rentnertreff.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment startFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, startFragment).commit();



        //create DBHandler and create mock-data

        DatabaseHandler db = new DatabaseHandler(this);


        //delete all items in the database TODO
        db.deleteAll();

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(2, "Angeln", "Natur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 0, 5.2, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(3, "Bowling", "Unterhaltung" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.bowling_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.kino_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.kino_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(4, "Spieleabend", "Gehirnjogging" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.spiele_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(4, "Joggen", "Sport" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.joggen_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(4, "Museum", "Kultur" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.museum_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "BEschreibung" , "2017-03-18" , "2017-03-18", 1, 1, 5.2, "Karlsruhe", R.drawable.shoppen_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe"));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //auf mainFRagment initialisiert, falls keines ausgeählt werden kann
        Fragment fragment = new MainFragment();

        if (id == R.id.nav_kategorie) {
            fragment = new KategorieFragment();
        } else if (id == R.id.nav_demnaechst) {

        } else if (id == R.id.nav_bewertung) {

        } else if (id == R.id.nav_meinKalender) {

        } else {
            fragment = new MainFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
