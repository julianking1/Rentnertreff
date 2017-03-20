package com.example.julian.rentnertreff;

import android.os.Parcelable;

/**
 * Created by Julian on 19.03.2017.
 */

public class Event {

    private int id;
    private String title;
    private String category;
    private String description;
    private String startTime;
    private String endTime;
    private boolean participation_planned;
    private boolean participated;
    private double price;

    //empty constructor
    public Event (){}

    //constructor
    public Event (int id, String title, String category, String description, String startTime, String endTime, boolean participation_planned, boolean participated, double price){
        this.id=id;
        this.title=title;
        this.category=category;
        this.description=description;
        this.startTime=startTime;
        this.endTime=endTime;
        this.participation_planned=participation_planned;
        this.participated=participated;
        this.price=price;
    }

    //constructor with 1 und 0 for true and false
    public Event (int id, String title, String category, String description, String startTime, String endTime, int participation_planned, int participated, double price){
        this.id=id;
        this.title=title;
        this.category=category;
        this.description=description;
        this.startTime=startTime;
        this.endTime=endTime;

        if(participation_planned==1) this.participation_planned = true;
        else this.participation_planned = false;

        if(participated==1) this.participated=true;
        else this.participated=false;

        this.price=price;
    }


    //Getter and Setter
    public int getId (){
        return this.id;
    }

    public void setId (int id){
        this.id = id;
    }

    public String getTitle (){
        return this.title;
    }

    public void setTitle (String title){
        this.title=title;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public String getDescription (){
        return this.description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getStartTime (){
        return this.startTime;
    }

    public void setStartTime(String startTime){
        this.startTime=startTime;
    }

    public String getEndTime(){
        return this.endTime;
    }

    public void setEndTime(String endTime){
        this.endTime=endTime;
    }

    public int isParticipation_planned() {
        if (participation_planned) return 1;    // if true, return 1
        else return 0; //if false, return 0
    }

    public void setParticipation_planned(int participation_planned) {
        if (participation_planned == 1) this.participation_planned = true;
        else this.participation_planned=false;
    }

    public int isParticipated() {
        if (participation_planned) return 1;    // if true, return 1
        else return 0; //if false, return 0
    }

    public void setParticipated(int participated) {
        if (participated == 1) this.participated = true;
        else this.participated=false;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
