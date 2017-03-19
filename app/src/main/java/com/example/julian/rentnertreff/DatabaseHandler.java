package com.example.julian.rentnertreff;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 19.03.2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Rentnertreff";

    // events table name
    private static final String TABLE_EVENTS = "Events";

    // Events Table Columns names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_title = "name";
    private static final String COLUMN_category = "category";
    private static final String COLUMN_description = "description";
    private static final String COLUMN_startTime = "startTime";
    private static final String COLUMN_endTime = "endTime";
    private static final String COLUMN_participated ="participated";
    private static final String COLUMN_participationPlanned ="participationPlanned";
    private static final String COLUMN_price = "price";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_EVENTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_title + " TEXT,"
                + COLUMN_category + " TEXT," + COLUMN_description  + " TEXT," + COLUMN_startTime
                + " TEXT,"+ COLUMN_endTime + " TEXT," + COLUMN_participated + " INTEGER,"
                + COLUMN_participationPlanned + " INTEGER," + COLUMN_price + "REAL)";
        db.execSQL(CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        // Create table again
        onCreate(db);
    }

    // Adding new event
    void addEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_title, event.getTitle());
        values.put(COLUMN_category, event.getCategory());
        values.put(COLUMN_description, event.getDescription());
        values.put(COLUMN_startTime, event.getStartTime());
        values.put(COLUMN_endTime, event.getEndTime());
        values.put(COLUMN_participated, event.isParticipated());
        values.put(COLUMN_participationPlanned, event.isParticipation_planned());
        values.put(COLUMN_price, event.getPrice());

        // Inserting Row
        db.insert(TABLE_EVENTS, null, values);
        db.close(); // Closing database connection
    }


    //getting single event

    public Event getEvent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EVENTS, new String[] { COLUMN_ID,
                        COLUMN_title, COLUMN_category, COLUMN_description, COLUMN_startTime, COLUMN_endTime, COLUMN_participated, COLUMN_participationPlanned, COLUMN_price }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Event event = new Event(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Double.parseDouble(cursor.getString(8)));

        // return event
        return event;
    }


    //getting all events from one category

    public List<Event> getAllEventsFromCategory(String category) {
        List<Event> eventList = new ArrayList<Event>();
        // Select Query
        String selectQuery = "SELECT  * FROM " + TABLE_EVENTS + " WHERE CATEGORY = " + category;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setId(Integer.parseInt(cursor.getString(0)));
                event.setTitle(cursor.getString(1));
                event.setCategory(cursor.getString(2));
                event.setDescription(cursor.getString(3));
                event.setStartTime(cursor.getString(4));
                event.setEndTime(cursor.getString(5));
                event.setParticipated(Integer.parseInt(cursor.getString(6)));
                event.setParticipation_planned(Integer.parseInt(cursor.getString(7)));
                event.setPrice(Double.parseDouble(cursor.getString(8)));

                // Adding event to list
                eventList.add(event);
            } while (cursor.moveToNext());
        }

        // return contact list
        return eventList;
    }
}
