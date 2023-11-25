package com.example.calensiee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();
        for(Event event : eventsList)
        {
            if(LocalDate.of(event.getYear(),event.getMonth(),event.getDay()).equals(date))
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



    /**
    public Event(String name, LocalDate date, LocalTime time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Event(String name, LocalDate date, LocalTime time,String place, String description, int duration, String club)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.place = place;
        this.description = description;
        this.duration = duration;
        this.club = club;
    }
    public Event(String name, LocalDate date, LocalTime time,String place, String description, String club)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.place = place;
        this.description = description;
        this.club = club;
    }
 */

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDateOfEvent()
    {
        return LocalDate.of(this.mYear,this.mMonth,this.mDay);
    }
    public LocalTime getTimeOfEvent()
    {
        return LocalTime.of(this.mHour,this.mDay);
    }
/**


    public void setDate(LocalDate date)
    {
        this.date = date;
    }



    public void setTime(LocalTime time)
    {
        this.time = time;
    }
*/
    public String getPlace()
    {
        return place;
    }
    public void setPlace(String place)
    {
        this.place = place;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int mYear) {
        this.mYear = mYear;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int mDay) {
        this.mDay = mDay;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int mHour) {
        this.mHour = mHour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int mMinute) {
        this.mMinute = mMinute;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getClub(){ return club; }
    public void setClub(String club){this.club = club;}
    public int getDuration() {return duration;}
}