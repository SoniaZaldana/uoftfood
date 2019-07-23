package com.uoft.food;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class ListItemViewHolder<T extends ListItem> extends RecyclerView.ViewHolder {

    public ListItemViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(T listItem);
}
