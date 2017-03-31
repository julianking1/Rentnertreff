package com.example.julian.rentnertreff.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.julian.rentnertreff.DatabaseHandler;
import com.example.julian.rentnertreff.Event;
import com.example.julian.rentnertreff.Fragments.Calender;
import com.example.julian.rentnertreff.Fragments.KategorieFragment;
import com.example.julian.rentnertreff.Fragments.ListFragment;
import com.example.julian.rentnertreff.Fragments.MainFragment;
import com.example.julian.rentnertreff.R;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    List<Event> events;
    DatabaseHandler db;
    public ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /*
        toggle.setDrawerIndicatorEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);*/


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment startFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, startFragment).commit();


        //create DBHandler and create mock-data

        db = new DatabaseHandler(this);


        //delete all items in the database TODO
        db.deleteAll();

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addEvent(new Event(1, "Burgenwandern", "Natur" , "Der Pfälzerwaldverein bietet eine geführte Tour durch die Berge. Wir wandern ca. 3 Stunden über Wiesn und Täler. Besichtigen werden wir unter anderem die Burg Trifeld." , "2017-04-18" , "2017-04-18", 0, 0, 15.00, "Annweiler", R.drawable.burg_event_bild, 30, 12, 1, 0, 1, "Wanderschuhe mitbringen", 0));
        db.addEvent(new Event(1, "Radtour", "Natur" , "Wir fahren gemütlich mit dem Rad durch die Umgebung Karlsruhes. Unser Begleiter Fritz Mann zeigt uns die schönsten Picknickplätze." , "2017-04-19" , "2017-04-19", 1, 0, 20.20, "Karlsruhe", R.drawable.rad_event_bild, 30, 8, 1, 0, 1, "Helm nicht vergessen!", 0));
        db.addEvent(new Event(1, "Picknick", "Natur" , "Wir treffen uns im Park und veranstalten ein internationales Frühstück. Gesponsort wird das Essen von der Sprachschule Heiner. Gerne können Sie Fragen zum aktuellen Kursangebot stellen." , "2017-04-11" , "2017-04-11", 1, 0, 5.00, "Karlsruhe Stadtpark", R.drawable.picknick_event_bild, 50, 39, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-07" , "2017-04-07", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-07" , "2017-04-07", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-07" , "2017-04-07", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-03" , "2017-04-03", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-02" , "2017-04-02", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-07" , "2017-04-07", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(2, "Angeln", "Natur" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(3, "Bowling", "Unterhaltung" , "Heute bieten wir wieder unser berühmtes Spezial-Angebot an. Im Preis sind 2 Stunden Bowling und das Tagesgericht inklusive. Auf Wunsch veranstalten wir außerdem ein kleines Turnier." , "2017-05-01" , "2017-05-01", 1, 0, 18.20, "Karlsruhe, Hauptstr. 3", R.drawable.bowling_event_bild, 20, 10, 1, 1, 1, "Sportschuhe mitbringen", 0));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "Wir zeigen den Film HONIG IM KOPF im Rentner-Spezial. Zur Vorführung erhalten sie eine heiße Milch mit Honig und eine Brezel gratis." , "2017-03-18" , "2017-03-18", 0, 1, 15.00, "Karlsruhe, Schauburg", R.drawable.kino_event_bild, 50, 40, 1, 1, 0, "keine Sitzplatzreservierung", 3));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "Wir zeigen den Film STIRB LANGSAM 4.0 im Rentner-Spezial. Ein Arzt ist vor Ort, sodass sich Herz-Kreislauf-schwache Zuschauer keine Sorgen machen müssen." , "2017-04-09" , "2017-04-09", 0, 0, 15.20, "Karlsruhe, Schauburg", R.drawable.kino_event_bild, 50, 10, 1, 1, 0, "Getränk gratis", 3));
        db.addEvent(new Event(4, "Spieleabend", "Gehirnjogging" , "Wir spielen Kniffel im Cafè Bauer. Gerne dürfen auch andere Gesellschaftsspiele mitgebracht werden. Eine heiße Schokolade ist im Preis mit inbegriffen. " , "2017-03-25" , "2017-03-25", 1, 0, 5.2, "Karlsruhe, Café Bauer", R.drawable.spiele_event_bild, 20, 10, 1, 1, 1, " ein Heißgetränk gratis", 3));
        db.addEvent(new Event(4, "Joggen", "Sport" , "Das Fitness Center möchte eine neue Laufgruppe speziell für Rentner ins Leben rufen. Zum ersten gemeinsamen Laufen treffen wir uns vor dem Eingang. Auch Nicht-Mitglieder sind eingeladen an der Veranstaltung teilzunehmen." , "2017-03-18" , "2017-03-18", 0, 1, 4.20, "Karlsruhe, Kriegsstr. 3", R.drawable.joggen_event_bild, 20, 14, 1, 0, 0, "Sportschuhe", 4));
        db.addEvent(new Event(4, "Museum", "Kultur" , "BEschreibung" , "2017-04-01" , "2017-04-01", 1, 0, 5.20, "Karlsruhe", R.drawable.museum_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 1, 5.20, "Karlsruhe", R.drawable.shoppen_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-03" , "2017-04-03", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-08" , "2017-04-08", 0, 1, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-08" , "2017-04-08", 0, 1, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-08" , "2017-04-08", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.wandern_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(2, "Angeln", "Natur" , "Der Angel-Club bietet einen Schnupperkurs an. Wir werden Fische fangen, grillen und dann essen. Wer außerdem eine Runde schwimmen möchte, sollte ein Handtuch nicht vergessen. Die Ausrüstung stellt der Club. " , "2017-02-18" , "2017-02-18", 0, 1, 20.20, "Karlsruhe, Am Teich 4", R.drawable.angeln_event_bild, 20, 10, 1, 1, 1, "Festes Schuhwerk!", 4));
        db.addEvent(new Event(3, "Bowling", "Unterhaltung" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.bowling_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.kino_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.kino_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Spieleabend", "Gehirnjogging" , "BEschreibung" , "2017-04-01" , "2017-04-01", 1, 0, 5.2, "Karlsruhe", R.drawable.spiele_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Joggen", "Sport" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.joggen_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Museum", "Kultur" , "BEschreibung" , "2017-04-01" , "2017-04-01", 0, 0, 5.20, "Karlsruhe", R.drawable.museum_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-08" , "2017-04-08", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-09" , "2017-04-09", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-07" , "2017-04-07", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-06" , "2017-04-06", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-05" , "2017-04-05", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));
        db.addEvent(new Event(4, "Test", "Sport" , "BEschreibung" , "2017-03-01" , "2017-04-01", 0, 1, 5.20, "Karlsruhe", R.drawable.joggen_event_bild, 20, 10, 1, 1, 1, "Wanderschuhe", 3));



        db.setEventsToPArticipated();
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
            Toast.makeText(this, "TELEFONISCHE HILFE: Diese Funktion ist in der App noch nicht implementiert!", Toast.LENGTH_SHORT).show();
            return true;
        }

        /*
        if(id == android.R.id.home){
            Toast.makeText(this, "huhu", Toast.LENGTH_SHORT).show();
            onBackPressed();
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //auf mainFRagment initialisiert, falls keines ausgeählt werden kann

        if (id == R.id.nav_kategorie) {
            Fragment fragment = new KategorieFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        } else if (id == R.id.nav_demnaechst) {
            events = db.getComingEvents();
            ListFragment listFragment = new ListFragment();
            listFragment.setList(events);
            listFragment.setCreatedForDemnaechst(true);
            setTitle("Demnächst");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("category_fragment").commit();

        } else if (id == R.id.nav_bewertung) {
            events = db.getEventsParticipated();
            ListFragment fragment = new ListFragment();
            fragment.setList(events);
            setTitle("Wie war's?");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        } else if (id == R.id.nav_meinKalender) {
            Fragment fragment = new Calender();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("main_fragment").commit();

        } else if (id == R.id.nav_einstellungen) {
            Toast.makeText(this, "EINSTELLUNGEN: Diese Funktion ist in der App noch nicht implementiert!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_Hilfe) {
            Toast.makeText(this, "HILFE: Diese Funktion ist in der App noch nicht implementiert!", Toast.LENGTH_SHORT).show();
        }
        else {
            Fragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
