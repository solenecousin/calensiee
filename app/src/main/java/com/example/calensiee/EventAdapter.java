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
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<Event> events;
    //private Event event;
    private OnItemListener onItemListener ;
    private boolean showDate;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventNameTextView;
        TextView eventTimeTextView;
        TextView eventClubTextView;

        public ViewHolder(View view) {
            super(view);
            eventTimeTextView = view.findViewById(R.id.eventTimeCellTV);
            eventClubTextView = view.findViewById(R.id.eventClubCellTV);
            eventNameTextView = view.findViewById(R.id.eventNameCellTV);
        }
    }

    public EventAdapter(List<Event> events, EventAdapter.OnItemListener onItemListener, boolean showDate) {
        this.events = events;
        this.onItemListener = onItemListener;
        this.showDate = showDate;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
        TextView eventClubCellTV = parent.findViewById(R.id.eventClubCellTV);
        TextView eventTimeCellTV = parent.findViewById(R.id.eventTimeCellTV);
        TextView eventNameCellTV = parent.findViewById(R.id.eventNameCellTV);

        String eventClub = event.getClub();
        eventClubCellTV.setText(eventClub);
        String eventTime = CalendarUtils.formattedTime(event.getTime());
        eventTimeCellTV.setText(eventTime);
        String eventName = event.getName();
        eventNameCellTV.setText(eventName);
        */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event eventToView = events.get(position);
        holder.eventNameTextView.setText(eventToView.getName());
        holder.eventClubTextView.setText(eventToView.getClub());
        if(showDate){
            holder.eventTimeTextView.setText(CalendarUtils.formattedDate(eventToView.getDate())+"  "+eventToView.getTime().toString());
        }else{
            holder.eventTimeTextView.setText(eventToView.getTime().toString());
        }

    }
    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public interface  OnItemListener
    {
        void onItemClick(int position, Event event);

        void onItemClick(int position, LocalDate date);
    }
}