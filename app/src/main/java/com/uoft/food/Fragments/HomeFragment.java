package com.uoft.food.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.uoft.food.FoodProviderListAdapter;
import com.uoft.food.FoodProviderListItem;
import com.uoft.food.Models.FoodProvider;
import com.uoft.food.R;
import com.uoft.food.Service.FoodClient;
import com.uoft.food.Service.FoodServiceCallBack;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getView().findViewById(R.id.recyclerView);
        final FoodClient client = new FoodClient();
        client.fetchFoodProviders(new FoodServiceCallBack.fetchFoodProvidersCallBack() {
            @Override
            public void onSuccess(List<FoodProvider> foodProviderList) {
                Toast toast = Toast.makeText(getContext(), "Size is " + foodProviderList.size(), Toast.LENGTH_SHORT);
                toast.show();
                List<FoodProviderListItem> listItems = new ArrayList<>();
                listItems = createListItems(foodProviderList);

                FoodProviderListAdapter adapter = new FoodProviderListAdapter(listItems);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure() {
                Toast toast = Toast.makeText(getContext(), "Service call failed, boo!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private List<FoodProviderListItem> createListItems(List<FoodProvider> foodProviderList) {
        List<FoodProviderListItem> listItems = new ArrayList<>();

        for (FoodProvider foodProvider : foodProviderList) {
            FoodProviderListItem.Builder builder = new FoodProviderListItem.Builder();
            if (!TextUtils.isEmpty(foodProvider.getName())) {
                builder.setName(foodProvider.getName());
            }
            if (!TextUtils.isEmpty(foodProvider.getBuildingId())) {
                builder.setBuilding(foodProvider.getBuildingId());
            }

            if (!TextUtils.isEmpty(foodProvider.getCampus())) {
                builder.setCampus(foodProvider.getCampus());
            }

            builder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToDetailsFragment();
                }
            });

            listItems.add(builder.build());
        }

        return listItems;
    }

    private void navigateToDetailsFragment() {
        ProviderDetailsFragment newDetailsFragment = new ProviderDetailsFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, newDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
