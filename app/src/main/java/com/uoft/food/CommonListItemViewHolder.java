package com.uoft.food;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class CommonListItemViewHolder<T extends ListItem> extends RecyclerView.ViewHolder {

    public CommonListItemViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(T listItem);
}
