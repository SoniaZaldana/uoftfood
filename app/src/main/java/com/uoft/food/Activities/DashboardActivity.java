package com.uoft.food.Activities;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uoft.food.Models.FoodProvider;
import com.uoft.food.R;
import com.uoft.food.Service.FoodClient;
import com.uoft.food.Service.FoodServiceCallBack;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // getting the navigation controller
        navController = Navigation.findNavController(this, R.id.fragment);

        // setting the navigation controller to Bottom nav
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        NavigationUI.setupWithNavController(bottomNav, navController);

        // Setting up the action bar
        NavigationUI.setupActionBarWithNavController(this, navController);

    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }

}
