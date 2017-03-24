package com.example.julian.rentnertreff;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 19.03.2017.
 */

public class EventAdapter extends BaseAdapter{

    List<Event> eventList;
    Context context;
    private static LayoutInflater inflater=null;


    public EventAdapter (Context context, List<Event> eventList) {
        // TODO Auto-generated constructor stub
        this.eventList = eventList;
        this.context = context;
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
        holder.tv2.setText(eventList.get(position).getPlace() + ", " + eventList.get(position).getStartTime());
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


}
