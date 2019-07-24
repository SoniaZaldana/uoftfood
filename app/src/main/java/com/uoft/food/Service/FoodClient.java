package com.uoft.food.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uoft.food.BuildConfig;
import com.uoft.food.Models.FoodProvider;
import java.io.IOException;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient {

    static final String BASE_URL = "https://cobalt.qas.im/api/1.0/";
    static final String API_KEY = BuildConfig.ApiKey;
    FoodServiceAPI foodAPI;

    /* Set up for getting foodAPI */
    OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(new Interceptor() {

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder().header("Authorization", API_KEY);
            Request newRequest = builder.build();
            return chain.proceed(newRequest);
        }
    }).build();


    private FoodServiceAPI getFoodAPI() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FoodServiceAPI foodAPI = retrofit.create(FoodServiceAPI.class);
        return foodAPI;

    }

    /* Fetch all food providers API */
    public void fetchFoodProviders(final FoodServiceCallBack.fetchFoodProvidersCallBack callback) {
        foodAPI = getFoodAPI();
        Call<List<FoodProvider>> call = foodAPI.fetchFoodProviders();
        call.enqueue(new Callback<List<FoodProvider>>() {
            @Override
            public void onResponse(Call<List<FoodProvider>> call, Response<List<FoodProvider>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<FoodProvider>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    /* Fetch specific food provider API */
    public void fetchSpecificFoodProvider(String id, final FoodServiceCallBack.fetchSpecificFoodProviderCallBack callBack) {
        foodAPI = getFoodAPI();
        Call<FoodProvider> call = foodAPI.fetchSpecificFoodProvider(id);
        call.enqueue(new Callback<FoodProvider>() {
            @Override
            public void onResponse(Call<FoodProvider> call, Response<FoodProvider> response) {
                if (response.isSuccessful())  {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onFailure();
                }
            }

            @Override
            public void onFailure(Call<FoodProvider> call, Throwable t) {
                callBack.onFailure();
            }
        });
    }

    /* Search for food provider */
    public void searchFoodProvider(String query, final FoodServiceCallBack.searchFoodProviderCallBack callBack) {
        foodAPI = getFoodAPI();
        Call<List<FoodProvider>> call = foodAPI.searchFoodProvider(query);
        call.enqueue(new Callback<List<FoodProvider>>() {
            @Override
            public void onResponse(Call<List<FoodProvider>> call, Response<List<FoodProvider>> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<FoodProvider>> call, Throwable t) {
                callBack.onFailure();
            }
        });
    }

    public void filterFoodProvider(String query, final FoodServiceCallBack.filterFoodProviderCallBack callBack) {
        foodAPI = getFoodAPI();
        Call<List<FoodProvider>> call = foodAPI.filterFoodProviders(query);
        call.enqueue(new Callback<List<FoodProvider>>() {
            @Override
            public void onResponse(Call<List<FoodProvider>> call, Response<List<FoodProvider>> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<FoodProvider>> call, Throwable t) {
                callBack.onFailure();
            }
        });
    }




}
