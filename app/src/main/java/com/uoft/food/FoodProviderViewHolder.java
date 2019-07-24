package com.uoft.food;

import android.view.View;
import android.widget.TextView;

public class FoodProviderViewHolder extends CommonListItemViewHolder<FoodProviderListItem> {

    private TextView nameTextView;
    private TextView campusTextView;
    private TextView buildingTextView;
    private TextView openTextView;

    public FoodProviderViewHolder(View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.name);
        campusTextView = itemView.findViewById(R.id.campus);
        buildingTextView = itemView.findViewById(R.id.building);
        openTextView = itemView.findViewById(R.id.open);
    }

    @Override
    public void onBind(FoodProviderListItem listItem) {
        nameTextView.setText(listItem.getName());
        campusTextView.setText(listItem.getCampus());
        buildingTextView.setText(listItem.getBuilding());
        if (listItem.isOpen()) {
            openTextView.setText("Open");
        } else {
            openTextView.setText("Closed");
        }
    }
}
