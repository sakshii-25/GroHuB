package com.example.grohub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grohub.R;

import java.util.List;

public class VegetableItemsAdapter extends RecyclerView.Adapter<VegetableItemsAdapter.ViewHolder> {

    List<Integer> images1;
    LayoutInflater inflater;

    public VegetableItemsAdapter(Context ctx, List<Integer> images) {

        this.images1 = images1;
        this.inflater = LayoutInflater.from(ctx);

    }


    @NonNull
    @Override
    public VegetableItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.vegetable_row_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableItemsAdapter.ViewHolder holder, int position) {

        holder.gridIcon.setImageResource(images1.get(position));
    }

    @Override
    public int getItemCount() {
        return images1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gridIcon = itemView.findViewById(R.id.imageView6);
        }

    }
}
