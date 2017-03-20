package com.example.julian.rentnertreff;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julian.rentnertreff.Activities.MainActivity;

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
        context = context;
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
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.event_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(eventList.get(position).getTitle());
        //holder.img.setImageResource(eventList.get(position).getImgID());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+eventList.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }


}
