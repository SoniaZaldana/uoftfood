package com.uoft.food;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uoft.food.FoodProviderList.FoodProviderListFragment;
import com.uoft.food.Models.FoodProvider;
import com.uoft.food.Service.FoodClient;
import com.uoft.food.Service.FoodServiceCallBack;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private Button listButton;
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

        listButton = findViewById(R.id.listButton);
        final FoodClient client = new FoodClient();

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

            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }

}
