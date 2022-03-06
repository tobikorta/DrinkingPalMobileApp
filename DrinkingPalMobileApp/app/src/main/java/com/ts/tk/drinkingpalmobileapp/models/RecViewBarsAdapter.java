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
import com.ts.tk.drinkingpalmobileapp.dtos.Bar;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.RestUtil;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecViewBarsAdapter extends RecyclerView.Adapter<RecViewBarsAdapter.MyViewHolder> {

    private List<Bar> bars = new ArrayList<>();
    private final Context context;

    public RecViewBarsAdapter(Context context) {
        this.context = context;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rec_view_home_screen, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.lblTitle.setText(bars.get(position).getName());
        holder.lblDescription.setText(bars.get(position).getDescription());
        Picasso.get().load(Constants.BASE_URL + "/bars/image/" + bars.get(position).getId()).into(holder.imgBar);
        holder.itemView.setOnClickListener(v -> {
            Map<String, Bar> extras = new HashMap<>();
            extras.put("bar", bars.get(position));
            ((SupportExtensions)context).openActivity(BarsDetails.class, extras);
        });

    }

    @Override
    public int getItemCount() {
        return bars.size();
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