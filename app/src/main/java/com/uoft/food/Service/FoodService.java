package com.uoft.food.Service;

import com.uoft.food.Models.FoodProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FoodService {

    @GET("food")
    Call<List<FoodProvider>> fetchFoodProviders();

}
