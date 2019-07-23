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

public class FoodClient implements Callback<List<FoodProvider>> {

    static final String BASE_URL = "https://cobalt.qas.im/api/1.0/";
    static final String API_KEY = BuildConfig.ApiKey;

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder().header("Authorization", API_KEY);

            Request newRequest = builder.build();
            return chain.proceed(newRequest);
        }
    }).build();

    public void init() {
        Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .build();

        FoodService foodAPI = retrofit.create(FoodService.class);

        Call<List<FoodProvider>> call = foodAPI.fetchFoodProviders();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<FoodProvider>> call, Response<List<FoodProvider>> response) {
        if (response.isSuccessful()) {
            List<FoodProvider> foodProviders = response.body();
            for (int x = 0; x < foodProviders.size(); x++) {
                System.out.println("yup");
            }
        } else {
            System.out.print(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<FoodProvider>> call, Throwable t) {
        t.printStackTrace();
    }
}
