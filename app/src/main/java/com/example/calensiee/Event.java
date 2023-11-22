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
            if(event.getDate().equals(date))
                events.add(event);
        }
        return events;
    }


    private String name;
    private LocalDate date;
    private LocalTime time;
    private String place, description, club;
    private int  duration;

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public String getPlace()
    {
        return place;
    }
    public void setPlace(String place)
    {
        this.place = place;
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