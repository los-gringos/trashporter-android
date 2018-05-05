package io.los.gringos.trashporter.android.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String DISTANCE_MATRIX_BASE_URL = "https://maps.googleapis.com/maps/api/";
    public static final String API_KEY = "AIzaSyCQwoFObrTrPoL2cC88Jm0uKdKe91Heuys";
    private static Retrofit retrofit = null;

    public static Retrofit getLocationClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(DISTANCE_MATRIX_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
