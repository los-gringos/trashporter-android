package io.los.gringos.trashporter.android.rest;

import io.los.gringos.trashporter.android.model.DistanceMatrix;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("distancematrix/json")
    Call<DistanceMatrix> getDistanceBetween(@Query("units") String unit,
                                            @Query("origins") String originLatLng,
                                            @Query("destinations") String destLatLng,
                                            @Query("key") String apiKey);
}
