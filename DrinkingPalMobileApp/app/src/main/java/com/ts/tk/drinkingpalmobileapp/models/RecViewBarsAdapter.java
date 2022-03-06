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
import com.ts.tk.drinkingpalmobileapp.activities.BarsDetails;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

public class RecViewBarsAdapter extends RecyclerView.Adapter<RecViewBarsAdapter.MyViewHolder> {

    private String[] barNames, barDescriptions;
    private Long[] barIds;
    private final Context context;

    public RecViewBarsAdapter(Context context, String[] barNames, String[] barDescriptions, Long[] barIds) {
        this.context = context;
        this.barNames = barNames;
        this.barDescriptions = barDescriptions;
        this.barIds = barIds;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rec_view_home_screen, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.lblTitle.setText(barNames[position]);
        holder.lblDescription.setText(barDescriptions[position]);
        Picasso.get().load(Constants.BASE_URL + "/bars/image/" + barIds[position]).into(holder.imgBar);
        final int index = position;
        holder.itemView.setOnClickListener(v -> {
            ((SupportExtensions)context).openActivity(BarsDetails.class);
        });

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