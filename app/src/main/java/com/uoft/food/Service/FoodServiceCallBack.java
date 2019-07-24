package com.uoft.food.Service;

import com.uoft.food.Models.FoodProvider;
import java.util.List;
import retrofit2.Call;

public class FoodServiceCallBack {

    public interface fetchFoodProvidersCallBack {
        void onSuccess(List<FoodProvider> foodProviderList);

        void onFailure();
    }

    public interface fetchSpecificFoodProviderCallBack {
        void onSuccess(FoodProvider foodProvider);

        void onFailure();
    }

    public interface searchFoodProviderCallBack {
        void onSuccess(List<FoodProvider> foodProviderList);

        void onFailure();
    }

    public interface filterFoodProviderCallBack {
        void onSuccess(List<FoodProvider> foodProviderList);

        void onFailure();
    }
}
