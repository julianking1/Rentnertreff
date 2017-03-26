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
    private String place;
    private int imgID;
    private int maxMembers;
    private int members;
    private boolean food;
    private boolean disabled;
    private boolean dogs;
    private String info;
    //private int rating;


    //empty constructor
    public Event (){}

    //constructor
    public Event (int id, String title, String category, String description, String startTime, String endTime, boolean participation_planned, boolean participated, double price, String place, int imgID, int maxMembers, int members, boolean food, boolean disabled, boolean dogs, String info){
        this.id=id;
        this.title=title;
        this.category=category;
        this.description=description;
        this.startTime=startTime;
        this.endTime=endTime;
        this.participation_planned=participation_planned;
        this.participated=participated;
        this.price=price;
        this.place=place;
        this.imgID=imgID;
        this.maxMembers=maxMembers;
        this.members=members;
        this.food=food;
        this.disabled=disabled;
        this.dogs=dogs;
        this.info=info;
    }

    //constructor with 1 und 0 for true and false
    public Event (int id, String title, String category, String description, String startTime, String endTime, int participation_planned, int participated, double price, String place, int imgID, int maxMembers, int members, int food, int disabled, int dogs, String info){
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

        this.place=place;
        this.imgID=imgID;
        this.maxMembers=maxMembers;
        this.members=members;

        if(food==1) this.food = true;
        else this.food = false;

        if(disabled==1) this.disabled=true;
        else this.disabled=false;

        if(dogs==1) this.dogs = true;
        else this.dogs = false;

        this.info = info;
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
        if (participated) return 1;    // if true, return 1
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int isFood() {
        if (food) return 1;    // if true, return 1
        else return 0; //if false, return 0
    }

    public void setFood(int food) {
        if (food == 1) this.food = true;
        else this.food=false;
    }

    public int isDisabled() {
        if (disabled) return 1;    // if true, return 1
        else return 0; //if false, return 0
    }

    public void setDisabled(int disabled) {
        if (disabled == 1) this.disabled = true;
        else this.disabled=false;
    }

    public int isDogs() {
        if (dogs) return 1;    // if true, return 1
        else return 0; //if false, return 0
    }

    public void setDogs(int dogs) {
        if (dogs == 1) this.dogs = true;
        else this.dogs=false;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
