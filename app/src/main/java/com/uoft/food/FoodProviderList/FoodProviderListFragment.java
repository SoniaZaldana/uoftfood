package com.uoft.food.FoodProviderList;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.uoft.food.BaseFragment;
import com.uoft.food.Models.FoodProvider;
import java.util.List;

public class FoodProviderListFragment extends BaseFragment {

    RecyclerView recyclerView;

    List<FoodProvider> listItems;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
