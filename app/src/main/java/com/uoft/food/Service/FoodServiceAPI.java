package com.uoft.food.Service;

import com.uoft.food.Models.FoodProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodService {

    @GET("food")
    Call<List<FoodProvider>> fetchFoodProviders();

    @GET("food/:{id}")
    Call<FoodProvider> fetchSpecificFoodProvider(@Path("id") String id);

    @GET("food/{search}")
    Call<List<FoodProvider>> searchFoodProvider(@Path("search") String query);

    @GET("food/{filter}")
    Call<List<FoodProvider>> filterFoodProviders(@Path("filter") String query);

}
