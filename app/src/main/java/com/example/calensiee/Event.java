package com.example.calensiee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{

    private ArrayList<Event> eventsList = new ArrayList<>();

    public ArrayList<Event> eventsForDate(LocalDate date)
    {

        ArrayList<Event> events = new ArrayList<>();
        for(Event event : this.eventsList)
        {
            if(LocalDate.of(event.getmYear(),event.getmMonth(),event.getmDay()).equals(date))
                events.add(event);
        }
        return events;
    }


    private String name;

    //private LocalDate date;
    //private LocalTime time;
    private int mYear,mMonth,mDay,mHour,mMinute;
    private String place, description, club;
    private int  duration;


    public Event(String name, int mYear, int mMonth, int mDay, int mHour, int mMinute, String place, String description, String club, int duration) {
        this.name = name;
        this.mYear = mYear;
        this.mMonth = mMonth;
        this.mDay = mDay;
        this.mHour = mHour;
        this.mMinute = mMinute;
        this.place = place;
        this.description = description;
        this.club = club;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public int getmMonth() {
        return mMonth;
    }

    public void setmMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public int getmHour() {
        return mHour;
    }

    public void setmHour(int mHour) {
        this.mHour = mHour;
    }

    public int getmMinute() {
        return mMinute;
    }

    public void setmMinute(int mMinute) {
        this.mMinute = mMinute;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}