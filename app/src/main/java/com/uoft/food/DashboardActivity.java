package com.uoft.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.uoft.food.FoodProviderList.FoodProviderListFragment;
import com.uoft.food.Service.FoodClient;

public class DashboardActivity extends AppCompatActivity {

    Button listButton;
    FoodClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        listButton = findViewById(R.id.listButton);
        client = new FoodClient();

        listButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                client.fetchFoodProviders();

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
