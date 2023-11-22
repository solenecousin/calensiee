package com.example.calensiee;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EventAdapter extends ArrayAdapter<Event>
{
    public EventAdapter(@NonNull Context context, List<Event> events)
    {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Event event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView eventClubCellTV = convertView.findViewById(R.id.eventClubCellTV);
        TextView eventTimeCellTV = convertView.findViewById(R.id.eventTimeCellTV);
        TextView eventNameCellTV = convertView.findViewById(R.id.eventNameCellTV);

        String eventClub = event.getClub();
        eventClubCellTV.setText(eventClub);
        String eventTime = CalendarUtils.formattedTime(event.getTime());
        eventTimeCellTV.setText(eventTime);
        String eventName = event.getName();
        eventNameCellTV.setText(eventName);
        return convertView;
    }
}