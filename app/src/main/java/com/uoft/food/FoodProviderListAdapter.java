package com.uoft.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uoft.food.Models.FoodProvider;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderListAdapter extends RecyclerView.Adapter<FoodProviderViewHolder> {

    private List<FoodProviderListItem> foodProviders = new ArrayList<>();

    public FoodProviderListAdapter(List<FoodProviderListItem> foodProviders) {
        this.foodProviders = foodProviders;
    }

    @NonNull
    @Override
    public FoodProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View foodProviderView = inflater.inflate(R.layout.food_provider_list_item, parent, false);

        FoodProviderViewHolder viewHolder = new FoodProviderViewHolder(foodProviderView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodProviderViewHolder holder, int position) {
        // Get the data model based on position
        FoodProviderListItem foodProvider = foodProviders.get(position);

        // set values
        holder.onBind(foodProvider);

    }

    @Override
    public int getItemCount() {
        return foodProviders.size();
    }
}
