package com.example.julian.rentnertreff;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julian.rentnertreff.Activities.MainActivity;
import com.example.julian.rentnertreff.Fragments.*;
import com.example.julian.rentnertreff.Fragments.ListFragment;

import org.w3c.dom.Text;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Julian on 19.03.2017.
 */

public class EventAdapter extends BaseAdapter{

    List<Event> eventList;
    Context context;
    private static LayoutInflater inflater=null;
    boolean createdForDemnaechst = false;


    public EventAdapter (Context context, List<Event> eventList, boolean createdForDemnaechst) {
        // TODO Auto-generated constructor stub
        this.eventList = eventList;
        this.context = context;
        this.createdForDemnaechst = createdForDemnaechst;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv1;
        TextView tv2;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.event_item, null);
        holder.tv1=(TextView) rowView.findViewById(R.id.textView1);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView2);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv1.setText(eventList.get(position).getTitle());

        if (createdForDemnaechst){
            Date currentDate = new Date ();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String eventDateString = eventList.get(position).getStartTime().toString();
            Date eventDate = null;
            Log.i("Uhr", eventDateString);
            try {
                eventDate = sdf.parse(eventDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long diff = eventDate.getTime() - currentDate.getTime();
            long seconds = diff/1000;
            int minutes = (int) seconds/60;
            int hours = minutes/60;
            int days = hours/24;
            int daysPlus1 = days + 1;

            if (daysPlus1==1){
                holder.tv2.setText("Noch " + daysPlus1 + " Tag");

            } else {
                holder.tv2.setText("Noch " + daysPlus1 + " Tage");
            }
        }
        else{
            holder.tv2.setText(eventList.get(position).getPlace() + ", " + eventList.get(position).getDateFormatted());
        }
        holder.img.setImageResource(eventList.get(position).getImgID());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Event event = eventList.get(position);
                Jana_Test fragment = new Jana_Test();
                fragment.setEvent(event);
                FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack("list_fragment").commit();

                //Toast.makeText(context, "You Clicked "+eventList.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

    public int getDifferenceDays(Date d1, Date d2) {
        int daysdiff=0;
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000)+1;
        daysdiff = (int) diffDays;
        return daysdiff;
    }


}
