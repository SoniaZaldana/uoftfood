package com.uoft.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.uoft.food.FoodProviderList.FoodProviderListFragment;
import com.uoft.food.Models.FoodProvider;
import com.uoft.food.Service.FoodClient;
import com.uoft.food.Service.FoodServiceCallBack;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    Button listButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        listButton = findViewById(R.id.listButton);
        FoodClient client = new FoodClient();

        listButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                client.fetchFoodProviders(new FoodServiceCallBack.fetchFoodProvidersCallBack() {
                    @Override
                    public void onSuccess(List<FoodProvider> foodProviderList) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Service call worked!", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    @Override
                    public void onFailure() {
                        Toast toast = Toast.makeText(getApplicationContext(), "Service call failed, boo!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                FoodProviderListFragment fragment = new FoodProviderListFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }




}
