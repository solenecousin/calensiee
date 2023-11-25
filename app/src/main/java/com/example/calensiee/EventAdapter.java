package com.example.calensiee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<Event> events;
    private final OnItemListener onItemListener ;
    private boolean showDate;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        List<Event> events;
        TextView eventNameTextView;
        TextView eventTimeTextView;
        TextView eventClubTextView;
        EventAdapter.OnItemListener onItemListenerBis;

        public ViewHolder(View view, EventAdapter.OnItemListener onItemListener,List<Event> events) {
            super(view);
            eventTimeTextView = view.findViewById(R.id.eventTimeCellTV);
            eventClubTextView = view.findViewById(R.id.eventClubCellTV);
            eventNameTextView = view.findViewById(R.id.eventNameCellTV);
            this.onItemListenerBis = onItemListener;
            view.setOnClickListener(this);
            this.events = events;
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition(),events.get(getAdapterPosition()));
        }
    }

    public EventAdapter(List<Event> events, OnItemListener onItemListener, boolean showDate) {
        this.events = events;
        this.onItemListener = onItemListener;
        this.showDate = showDate;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cell, parent, false);
        return new ViewHolder(view,onItemListener,events);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event eventToView = events.get(position);
        holder.eventNameTextView.setText(eventToView.getName());
        holder.eventClubTextView.setText(eventToView.getClub());
        if(showDate){
            LocalDate date = LocalDate.of(eventToView.getmYear(),eventToView.getmMonth(),eventToView.getmDay());
            LocalTime time = LocalTime.of(eventToView.getmHour(),eventToView.getmMinute());
            holder.eventTimeTextView.setText(CalendarUtils.formattedDate(date)+"  "+time.toString());
        }else{
            LocalTime time = LocalTime.of(eventToView.getmHour(),eventToView.getmMinute());
            holder.eventTimeTextView.setText(time.toString());
        }

    }
    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public interface  OnItemListener
    {
        void onItemClick(int position, Event event);

    }
}