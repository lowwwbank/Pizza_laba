package com.example.pizza_laba;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

class CustomHolder extends RecyclerView.ViewHolder {
    ImageView imageV;
    TextView nameV, weightV, sizeV, priceV;

    public CustomHolder(@NonNull View itemView) {
        super(itemView);
        imageV = itemView.findViewById(R.id.pizza_image);
        nameV = itemView.findViewById(R.id.pizza_name);
        weightV = itemView.findViewById(R.id.pizza_weight);
        sizeV = itemView.findViewById(R.id.pizza_size);
        priceV = itemView.findViewById(R.id.pizza_price);
    }
}

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {
    private final ArrayList<Pizza> items;

    CustomAdapter(ArrayList<Pizza> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int idx) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_item, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int idx) {
        Pizza pizza = items.get(idx);
        holder.imageV.setImageResource(pizza.getImage());
        holder.nameV.setText(pizza.getName());
        holder.weightV.setText(pizza.getWeight());
        holder.sizeV.setText(pizza.getSize());
        holder.priceV.setText(pizza.getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
