package io.los.gringos.trashporter.android.utils;

import com.google.android.gms.maps.model.LatLng;

import io.los.gringos.trashporter.android.model.DistanceMatrix;
import io.los.gringos.trashporter.android.rest.ApiClient;
import io.los.gringos.trashporter.android.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationUtil {

    public void distanceInKmBetween(LatLng latLng1,LatLng latLng2) {
        ApiInterface apiService = ApiClient.getLocationClient().create(ApiInterface.class);
        Call<DistanceMatrix> call = apiService.getDistanceBetween(
                "metric",
                latLng1.latitude+","+latLng1.longitude,
                latLng2.latitude+","+latLng2.longitude,
                ApiClient.API_KEY);
        call.enqueue(new Callback<DistanceMatrix>() {
            @Override
            public void onResponse(Call<DistanceMatrix> call, Response<DistanceMatrix> response) {
                System.out.println(response.body().getDistanceText());
            }

            @Override
            public void onFailure(Call<DistanceMatrix> call, Throwable t) {

            }
        });
    }
}
