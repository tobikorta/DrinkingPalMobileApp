package com.ts.tk.drinkingpalmobileapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.Event;

import java.util.ArrayList;
import java.util.List;

public class RecViewEventsAdapter extends RecyclerView.Adapter<RecViewEventsAdapter.MyViewHolder> {

    private List<Event> events = new ArrayList<>();
    private final Context context;

    public RecViewEventsAdapter(Context context){this.context = context;}

    public void setEvents(List<Event> events){this.events = events;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rec_view_event_screen, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lblTitle, lblDescription;
        ImageView imgBar;

        public MyViewHolder(@NonNull View eventView) {
            super(eventView);
            lblTitle = itemView.findViewById(R.id.lblTitle);
            lblDescription = itemView.findViewById(R.id.lblDescription);
            imgBar = itemView.findViewById(R.id.imgBar);
        }
    }
}

