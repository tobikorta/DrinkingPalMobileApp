package com.ts.tk.drinkingpalmobileapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;

public class RecViewBarsAdapter extends RecyclerView.Adapter<RecViewBarsAdapter.MyViewHolder> {

    String barNames[], barDescriptions[];
    Long barIds[];
    Context ct;

    public RecViewBarsAdapter(Context context, String s1[], String s2[], Long img[]) {
        ct = context;
        barNames = s1;
        barDescriptions = s2;
        barIds = img;
    }

    public void setBarNames(String[] barNames) {
        this.barNames = barNames;
    }

    public void setBarDescriptions(String[] barDescriptions) {
        this.barDescriptions = barDescriptions;
    }

    public void setBarIds(Long[] barIds) {
        this.barIds = barIds;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.rec_view_home_screen, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.lblTitle.setText(barNames[position]);
        holder.lblDescription.setText(barDescriptions[position]);
        Picasso.get().load(Constants.BASE_URL + "/bars/image/" + barIds[position]).into(holder.imgBar);
    }

    @Override
    public int getItemCount() {
        return barIds.length;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lblTitle, lblDescription;
        ImageView imgBar;

        public MyViewHolder(@NonNull View barView) {
            super(barView);
            lblTitle = itemView.findViewById(R.id.lblTitle);
            lblDescription = itemView.findViewById(R.id.lblDescription);
            imgBar = itemView.findViewById(R.id.imgBar);
        }
    }
}