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

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> events;

    private Event event;
    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView eventNameTextView;
        private TextView eventTimeTextView;
        private TextView eventClubTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.eventTimeTextView = (TextView) view.findViewById(R.id.eventTimeCellTV);
            this.eventClubTextView = (TextView) view.findViewById(R.id.eventClubCellTV);
            this.eventNameTextView = (TextView) view.findViewById(R.id.eventNameCellTV);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView eventClubCellTV = parent.findViewById(R.id.eventClubCellTV);
        TextView eventTimeCellTV = parent.findViewById(R.id.eventTimeCellTV);
        TextView eventNameCellTV = parent.findViewById(R.id.eventNameCellTV);

        String eventClub = event.getClub();
        eventClubCellTV.setText(eventClub);
        String eventTime = CalendarUtils.formattedTime(event.getTime());
        eventTimeCellTV.setText(eventTime);
        String eventName = event.getName();
        eventNameCellTV.setText(eventName);
       return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.eventClubTextView.setText((CharSequence) events.get(position));
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }


}


