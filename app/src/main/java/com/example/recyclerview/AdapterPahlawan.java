package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.ViewHolder> {
    private ArrayList<modelpahlawan> modelPahlawans;
    private Context context;

    public AdapterPahlawan(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPahlawan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pahlawan, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPahlawan.ViewHolder holder, final int position) {
        Glide.with(context).load(getModelPahlawans().get(position).getHeroImages()).into(holder.imagePahlawan);
        holder.tvNama.setText(getModelPahlawans().get(position).getHeroNames());
        holder.tvDetail.setText(getModelPahlawans().get(position).getHeroDetails());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DetailActivity.class);
                i.putExtra("nama",getModelPahlawans().get(position).getHeroNames());
                i.putExtra("detail",getModelPahlawans().get(position).getHeroDetails());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getModelPahlawans().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagePahlawan;
        private TextView tvNama, tvDetail;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePahlawan = itemView.findViewById(R.id.ivPahlawan);
            tvNama = itemView.findViewById(R.id.tvJudul);
            tvDetail = itemView.findViewById(R.id.tvDeskrip);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }
    }

    public ArrayList<modelpahlawan> getModelPahlawans() {
        return modelPahlawans;
    }

    public void setModelPahlawans(ArrayList<modelpahlawan> modelPahlawans) {
        this.modelPahlawans = modelPahlawans;
    }
}
