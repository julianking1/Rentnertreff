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
        db.addEvent(new Event(1, "Schlossbesichtigung", "Natur" , "Das Heidelberger Schloss ist durch zahlreiche Legenden geprägt. Diesen möchten wir auf unserer Wanderung nachgehen. Nach erfolgreicher Wanderung gibt es auch eine Weinprobe." , "2017-04-14" , "2017-04-14", 0, 0, 7.20, "Heidelberg", R.drawable.heidelbergerschloss, 20, 10, 1, 0, 1, "Wanderschuhe", 5));
        db.addEvent(new Event(1, "Bergstraßentour", "Natur" , "Die Bergstraßentour startet in Schriesheim und wandert von dort die Strahlenburg hoch. Von dieser genießt man eine traumhafte Aussicht" , "2017-04-17" , "2017-04-17", 0, 0, 5.20, "Schriesheim", R.drawable.strahlenburg, 20, 10, 0, 0, 1, "Eigene Verpflegung mitbringen", 3));
        db.addEvent(new Event(1, "Jazz-Abend", "Kultur" , "In unserem gemütlichen Jazz-Abend wollen wir die guten alten Zeiten des Swing Jazz wieder auferleben lassen, aber auch die guten Klassiker wie Autumn Leaves werden bei uns nicht zu kurz kommen" , "2017-04-10" , "2017-04-10", 1, 0, 8.00, "Weinheim", R.drawable.jazz, 8, 3, 1, 1, 1, "Bitte eigenes Instrument mitbringen", 3));
        db.addEvent(new Event(1, "Maislabyrinth", "Natur" , "Passend zum Maianfang öffnet wieder das Ladenburger Maislabyrinth. Falls Sie sich auch noch ohne Handy, sondern nur mit Kompass zurecht finden, können Sie hier Ihr Können unter Beweis stellen" , "2017-05-01" , "2017-05-01", 1, 0, 4.00, "Ladenburg", R.drawable.maisplabyrinth, 30, 10, 1, 1, 0, "Taschenlampe und Kompass mitbringen", 2));
        db.addEvent(new Event(1, "Weldefest", "Kultur" , "Am 01.06 startet das jährliche Plankstädter Weldefest. Kommen Sie, wenn Sie den echten Weldegeschmack genießen möchten" , "2017-06-01" , "2017-06-05", 1, 0, 0.00, "Plankstadt", R.drawable.weldefest, 100, 10, 1, 1, 1, "Gute Laune mitbringen", 3));
        db.addEvent(new Event(1, "Moselwanderung", "Natur" , "Der Grüne-Freunde-Verein möchte bei seiner nächsten Wanderung die Mosel erkunden. Zielgruppe dieses mal sind Rentner, um auch im Alter fit zu bleiben." , "2017-04-18" , "2017-04-18", 1, 0, 7.80, "Trier", R.drawable.wandern_event_bild, 20, 10, 1, 0, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(2, "Angeln", "Natur" , "Die begeisterten Angler versuchen nächste Woche im Wörther See ihr Glück" , "2017-04-14" , "2017-04-14", 0, 0, 2.00, "Wörth", R.drawable.angeln_event_bild, 5, 2, 1, 1, 0, "Würmer sind inklusive", 1));
        db.addEvent(new Event(3, "Bowling", "Unterhaltung" , "Heute bieten wir wieder unser berühmtes Spezial-Angebot an. Im Preis sind 2 Stunden Bowling und das Tagesgericht inklusive. Auf Wunsch veranstalten wir außerdem ein kleines Turnier." , "2017-05-01" , "2017-05-01", 1, 0, 18.20, "Karlsruhe, Hauptstr. 3", R.drawable.bowling_event_bild, 20, 10, 1, 1, 1, "Sportschuhe mitbringen", 0));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "Wir zeigen den Film HONIG IM KOPF im Rentner-Spezial. Zur Vorführung erhalten sie eine heiße Milch mit Honig und eine Brezel gratis." , "2017-04-18" , "2017-04-18", 0, 0, 15.00, "Karlsruhe, Schauburg", R.drawable.kino_event_bild, 50, 40, 1, 1, 0, "keine Sitzplatzreservierung", 3));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "Wir zeigen den Film STIRB LANGSAM 4.0 im Rentner-Spezial. Ein Arzt ist vor Ort, sodass sich Herz-Kreislauf-schwache Zuschauer keine Sorgen machen müssen." , "2017-04-09" , "2017-04-09", 0, 0, 15.20, "Karlsruhe, Schauburg", R.drawable.kino_event_bild, 50, 10, 1, 1, 0, "Getränk gratis", 3));
        db.addEvent(new Event(4, "Spieleabend", "Gehirnjogging" , "Wir spielen Kniffel im Cafè Bauer. Gerne dürfen auch andere Gesellschaftsspiele mitgebracht werden. Eine heiße Schokolade ist im Preis mit inbegriffen. " , "2017-04-25" , "2017-04-25", 1, 0, 5.20, "Karlsruhe, Café Bauer", R.drawable.spiele_event_bild, 20, 10, 1, 1, 1, " ein Heißgetränk gratis", 3));
        db.addEvent(new Event(4, "Joggen", "Sport" , "Das Fitness Center möchte eine neue Laufgruppe speziell für Rentner ins Leben rufen. Zum ersten gemeinsamen Laufen treffen wir uns vor dem Eingang. Auch Nicht-Mitglieder sind eingeladen an der Veranstaltung teilzunehmen." , "2017-03-18" , "2017-03-18", 0, 0, 4.20, "Karlsruhe, Kriegsstr. 3", R.drawable.joggen_event_bild, 20, 14, 1, 0, 0, "Sportschuhe", 4));
        db.addEvent(new Event(4, "Museum", "Kultur" , "Das Badische Landesmuseum lädt dazu ein seine umfangreichen Sammlungen von der Antike bis zur Neuzeit zu zeigen" , "2017-04-26" , "2017-04-26", 0, 0, 4.80, "Karlsruhe", R.drawable.museum_event_bild, 20, 10, 1, 1, 0, "Geführte Tour", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Morgenstund hat Gold im Mund - dieses Sprichwort hat sich das Ettlinger Tor zu Herzen genommen und bietet Rentnern, die gerne früh aufstehen begleitetes Shoppen an. Treffpunkt ist 07:00 Uhr am Haupteingang" , "2017-04-29" , "2017-04-29", 0, 0, 0.00, "Karlsruhe", R.drawable.shoppen_event_bild, 15, 5, 1, 1, 1, "Kaffeepausen sind eingeplant", 3));
        db.addEvent(new Event(1, "Plantarium", "Kultur" , "Wie sieht unser Sonnensystem aus? Wie ist die Milchstraße aufgebaut? Träumen Sie genauso vom Universum wie wir? Dann besuchen Sie doch die Rentnerstunde des Mannheimer Planetariums" , "2017-04-21" , "2017-04-21", 0, 0, 3.00, "Mannheim", R.drawable.mannheimplanetarium, 20, 3, 0, 1, 1, "Brille mitbringen", 3));
        db.addEvent(new Event(1, "Wandern", "Natur" , "Wir wandern zwei Stunden durch den Odenwald. Die Strecke ist ohne große Steigung und ist daher gut für Herz-Kreislauf verträglich" , "2017-05-22" , "2017-05-22", 0, 0, 3.40, "Unterabtsteinach", R.drawable.wandern_event_bild, 10, 5, 1, 0, 1, "Wanderschuhe", 2));
        db.addEvent(new Event(1, "Mannheimer Wasserturm", "Natur" , "Mit den wärmeren Temperaturen ist es wieder so weit: Der Mannheimer Wasserturm lädt zum Picknicken ein. Sonntags sind vor allem Rentner hierzu eingeladen. Wir treffen uns um 12:00 Uhr" , "2017-04-30" , "2017-04-30", 1, 0, 2.00, "Karlsruhe", R.drawable.picknick_event_bild, 20, 7, 0, 1, 1, "Für Decken ist gesorgt, Verpflegung bitte selbst mitbringen", 3));
        db.addEvent(new Event(1, "Mathildas Backstube", "Unterhaltung" , "Mathildas Backstube lädt Rentner zum Frühlingsbacken ein, damit es auch mal wieder wie in guten alten Zeiten schmeckt. Selbstverständlich darf jeder sein selbst gebackenes Brot mitnehmen." , "2017-05-25" , "2017-05-25", 0, 0, 10.30, "Karlsruhe", R.drawable.koch, 15, 3, 1, 1, 0, "Zutaten sind vorhanden", 3));
        db.addEvent(new Event(1, "Schlossbeleuchtung", "Natur" , "Die erste Heidelberger Schlossbeleuchtung findet wieder statt. Für dieses Jahr wünschen wir uns, dass vor allem Rentner an diesem tollen Event teilnehmen" , "2017-06-03" , "2017-06-03", 0, 0, 0.00, "Heidelberg", R.drawable.heidelbergerschloss, 200, 17, 1, 1, 1, "Sanitäter sind vorort", 5));
        db.addEvent(new Event(2, "Angeln", "Natur" , "Der Angel-Club bietet einen Schnupperkurs an. Wir werden Fische fangen, grillen und dann essen. Wer außerdem eine Runde schwimmen möchte, sollte ein Handtuch nicht vergessen. Die Ausrüstung stellt der Club. " , "2017-05-18" , "2017-05-18", 0, 0, 20.20, "Karlsruhe, Am Teich 4", R.drawable.angeln_event_bild, 20, 10, 1, 1, 1, "Festes Schuhwerk!", 4));
        db.addEvent(new Event(3, "Bowling", "Unterhaltung" , "Wollen Sie mal wieder richtig die Kugel rollen lassen? Dann besuchen Sie doch mal die Rentnerkegelgruppe der Karlsruher Kegelbahn! " , "2017-04-21" , "2017-04-21", 0, 0, 6.50, "Karlsruhe", R.drawable.bowling_event_bild, 20, 10, 1, 1, 1, "Auch Gruppenbuchungen möglich", 3));
        db.addEvent(new Event(4, "Kino", "Unterhaltung" , "Das ZKM bietet jeden Dienstag Abend um 19:00 Uhr die vergünstigte Rentnervorstellung an. Der Film wird per Zufall, aber dennoch zielgruppen gerichtet ausgewählt" , "2017-04-25" , "2017-04-25", 0, 0, 5.20, "Karlsruhe", R.drawable.kino_event_bild, 20, 10, 1, 1, 1, "Die Veranstaltung findet wöchentlich statt", 3));
        db.addEvent(new Event(4, "Stummfilmvertonung", "Unterhaltung" , "Das ZKM bietet wieder die begehrte Stummfilmvertonung an. Zielgruppe sind hierbei Rentner, da hauptsächlich klassiker der Goldenen Zwanziger gezeigt werden" , "2017-06-01" , "2017-06-01", 0, 0, 10.00, "Karlsruhe", R.drawable.kino_event_bild, 20, 18, 1, 1, 0, "Verpflegung ist mitinbegriffen", 3));
        db.addEvent(new Event(4, "Spieleabend", "Gehirnjogging" , "Mensch ärgere dich nicht und Mühle sind die Spiele die ihre Jugend geprägt haben? Dann kommen Sie doch zu unserem Spieleabend!" , "2017-05-02" , "2017-05-02", 1, 0, 3.20, "Viernheim", R.drawable.spiele_event_bild, 8, 4, 0, 1, 0, "Lieblingsspiele können mitgebracht werden", 3));
        db.addEvent(new Event(4, "Joggen", "Sport" , "Sie wollen ihr Immunsystem wieder in Form bringen, trauen sich aber nicht alleine laufen zu gehen? Unsere Rentnerjoggergruppe bietet einen wöchentlichen Stadtparklauf an, der auf ihr Tempo ausgerichtet ist. Schließen sie sich uns an!" , "2017-04-19" , "2017-04-19", 0, 0, 2.20, "Karlsruhe", R.drawable.joggen_event_bild, 10, 7, 0, 0, 0, "Sportschuhe", 3));
        db.addEvent(new Event(4, "Museum", "Kultur" , "Besuchen Sie doch mal die Frühlingsausstellung der Kunstgalerie. Für Rentner gibt es Gruppenführungen und ermäßigte Eintritte" , "2017-04-08" , "2017-04-08", 0, 0, 2.20, "Karlsruhe", R.drawable.museum_event_bild, 20, 10, 1, 1, 0, "Verpflegung ist gegen Aufpreis möglich", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-08" , "2017-04-08", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));
        db.addEvent(new Event(4, "Schachabend", "Gehirnjogging" , "Jung trifft auf alt, dieses Motto hat sich der Walldorfer Schachverein zu Herzen genommen. Treten Sie gegen unsere Nachwuchsschachkünstler an" , "2017-04-09" , "2017-04-09", 1, 0, 2.00, "Karlsruhe, Oxford",  R.drawable.spiele_event_bild, 10, 4, 0, 1, 0, "Essen kostet extra", 3));
        db.addEvent(new Event(4, "Improvisationsabend", "Kultur" , "Lassen Sie sich von Jazz-Meister Dr. Grünhausen die Grundlagen der Improvisation beibringen " , "2017-04-17" , "2017-04-17", 1, 0, 0.00, "Heddesheim, Karls Keller", R.drawable.jazz, 30, 14, 1, 1, 0, "Instrument mitbringen", 3));
        db.addEvent(new Event(4, "Kochen", "Alltag" , "Jugendliche bieten an, Sie beim Kochen zu unterstützen und freuen Sich von den Kochkünsten der älteren Generation inspirieren zu lassen" , "2017-04-16" , "2017-04-16", 1, 0, 0.00, "Auf Anfrage", R.drawable.kochen, 4, 2, 1, 1, 0, "Sie bestimmen das Rezept", 3));
        db.addEvent(new Event(4, "Shoppen", "Alltag" , "Jugendliche bieten an, die Einkaufstaschen zu tragen. Wir treffen uns am Eingang des Ettlinger Tors. Der Jugendtreff sammelt für den Ausbau des Klubraumes und freut sich über eine kleine Spende. " , "2017-04-15" , "2017-04-15", 1, 0, 0.00, "Karlsruhe, Ettlinger Tor", R.drawable.shoppen_event_bild, 30, 14, 1, 1, 0, "Einkaufsliste mitbringen", 3));


        db.addEvent(new Event(1, "Burgenwandern", "Natur" , "Der Pfälzerwaldverein bietet eine geführte Tour durch die Berge. Wir wandern ca. 3 Stunden über Wiesn und Täler. Besichtigen werden wir unter anderem die Burg Trifeld." , "2017-04-01" , "2017-04-01", 1, 0, 15.00, "Annweiler", R.drawable.burg_event_bild, 30, 12, 1, 0, 1, "Wanderschuhe mitbringen", 3));
        db.addEvent(new Event(1, "Radtour", "Natur" , "Wir fahren gemütlich mit dem Rad durch die Umgebung Karlsruhes. Unser Begleiter Fritz Mann zeigt uns die schönsten Picknickplätze." , "2017-03-30" , "2017-03-30", 1, 0, 20.20, "Karlsruhe", R.drawable.rad_event_bild, 30, 8, 1, 0, 1, "Helm nicht vergessen!", 3));
        db.addEvent(new Event(1, "Moselwanderung", "Natur" , "Der Grüne-Freunde-Verein möchte bei seiner nächsten Wanderung die Mosel erkunden. Zielgruppe dieses mal sind Rentner, um auch im Alter fit zu bleiben." , "2017-03-18" , "2017-03-18", 1, 0, 7.80, "Trier", R.drawable.wandern_event_bild, 20, 10, 1, 0, 1, "Wanderschuhe", 3));
        db.addEvent(new Event(4, "Spieleabend", "Gehirnjogging" , "Mensch ärgere dich nicht und Mühle sind die Spiele die ihre Jugend geprägt haben? Dann kommen Sie doch zu unserem Spieleabend!" , "2017-04-02" , "2017-04-02", 1, 0, 3.20, "Viernheim", R.drawable.spiele_event_bild, 8, 4, 0, 1, 0, "Lieblingsspiele können mitgebracht werden", 3));
        db.addEvent(new Event(4, "Kochen", "Alltag" , "Jugendliche bieten an, Sie beim Kochen zu unterstützen und freuen Sich von den Kochkünsten der älteren Generation inspirieren zu lassen" , "2017-04-01" , "2017-04-01", 1, 0, 0.00, "Auf Anfrage", R.drawable.kochen, 4, 2, 1, 1, 0, "Sie bestimmen das Rezept", 3));



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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("category_fragment").commit();

        } else if (id == R.id.nav_demnaechst) {
            events = db.getComingEvents();
            ListFragment listFragment = new ListFragment();
            listFragment.setList(events);
            listFragment.setCreatedForDemnaechst(true);
            setTitle("Demnächst");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).addToBackStack("next_fragment").commit();

        } else if (id == R.id.nav_bewertung) {
            events = db.getEventsParticipated();
            ListFragment fragment = new ListFragment();
            fragment.setList(events);
            setTitle("Wie war's?");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("feedback_fragment").commit();

        } else if (id == R.id.nav_meinKalender) {
            Fragment fragment = new Calender();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("calender_fragment").commit();

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
