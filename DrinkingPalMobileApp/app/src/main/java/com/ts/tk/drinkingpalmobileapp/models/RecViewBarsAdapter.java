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

public class RecViewBarsAdapter extends RecyclerView.Adapter<RecViewBarsAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context ct;

    public RecViewBarsAdapter(Context context, String s1[], String s2[], int img[]) {
        ct = context;
        data1 = s1;
        data2 = s2;
        images = img;
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

        holder.lblTitle.setText(data1[position]);
        holder.lblDescription.setText(data2[position]);
        holder.imgBar.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
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



