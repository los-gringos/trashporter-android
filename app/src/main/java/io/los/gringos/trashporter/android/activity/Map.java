package io.los.gringos.trashporter.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import io.los.gringos.trashporter.R;
import io.los.gringos.trashporter.android.model.DistanceMatrix;
import io.los.gringos.trashporter.android.rest.ApiClient;
import io.los.gringos.trashporter.android.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    public List<Marker> markers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Creates Markers on Map and inserts them to List markers.

        this.addMarkers(googleMap);

        //zooms around the markers field when map opens
        this.zoomOnMarkers(googleMap);

        this.setPolyliners(googleMap);

        // googleMap.moveCamera(CameraUpdateFactory.newLatLng(serres));
    }

    public void addMarkers(GoogleMap googleMap) {
        ApiInterface apiService = ApiClient.getLocationClient().create(ApiInterface.class);

        LatLng serres = new LatLng(41.092083, 23.541016);
        LatLng provatas = new LatLng(41.068238, 23.390686);
        LatLng anwKamila = new LatLng(41.058320, 23.424134);
        LatLng katwKamila = new LatLng(41.020431, 23.483293);
        LatLng mitrousi = new LatLng(41.058680, 23.457547);
        LatLng koumaria = new LatLng(41.016434, 23.434656);
        LatLng skoutari = new LatLng(41.020032, 23.520701);
        LatLng adelfiko = new LatLng(41.014645, 23.457354);
        LatLng agiaEleni = new LatLng(41.003545, 23.559196);
        LatLng peponia = new LatLng(40.988154, 23.516756);


        final Marker serresMarker = googleMap.addMarker(new MarkerOptions().position(serres)
                .title("Serres"));
        final Marker provatasMarker = googleMap.addMarker(new MarkerOptions().position(provatas)
                .title("Provatas"));
        final Marker anwKamilaMarker = googleMap.addMarker(new MarkerOptions().position(anwKamila)
                .title("Anw Kamila"));
        final Marker katwKamilaMarker = googleMap.addMarker(new MarkerOptions().position(katwKamila)
                .title("Katw Kamila"));
        final Marker mitrousiMarker = googleMap.addMarker(new MarkerOptions().position(mitrousi)
                .title("Mitrousi"));
        final Marker koumariaMarker = googleMap.addMarker(new MarkerOptions().position(koumaria)
                .title("Koumaria"));
        final Marker skoutariMarker = googleMap.addMarker(new MarkerOptions().position(skoutari)
                .title("Skoutari"));
        Marker adelfikoMarker = googleMap.addMarker(new MarkerOptions().position(adelfiko)
                .title("Adelfiko"));
        final Marker agiaEleniMarker = googleMap.addMarker(new MarkerOptions().position(agiaEleni)
                .title("Agia Eleni"));
        final Marker peponiaMarker = googleMap.addMarker(new MarkerOptions().position(peponia)
                .title("Peponia"));

        Call<DistanceMatrix> call = apiService.getDistanceBetween("metric",
                serres.latitude + "," + serres.longitude,
                adelfiko.latitude + "," + adelfiko.longitude,
                ApiClient.API_KEY);
        call.enqueue(new Callback<DistanceMatrix>() {
            @Override
            public void onResponse(Call<DistanceMatrix> call, Response<DistanceMatrix> response) {
                serresMarker.setTitle("Serres - Distance from Adelfiko "
                        + response.body().getDistanceText());
            }

            @Override
            public void onFailure(Call<DistanceMatrix> call, Throwable t) {

            }
        });

        markers.add(serresMarker);
        markers.add(provatasMarker);
        markers.add(anwKamilaMarker);
        markers.add(katwKamilaMarker);
        markers.add(mitrousiMarker);
        markers.add(koumariaMarker);
        markers.add(skoutariMarker);
        markers.add(adelfikoMarker);
        markers.add(agiaEleniMarker);
        markers.add(peponiaMarker);
    }

    public void zoomOnMarkers(GoogleMap googleMap) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }

        LatLngBounds bounds = builder.build();

        int padding = 150; // offset from edges of the map in pixels

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

        googleMap.moveCamera(cu);

        googleMap.animateCamera(cu);
    }

    public void setPolyliners(GoogleMap googleMap) {
        LatLng serres = new LatLng(41.092083, 23.541016);
        LatLng provatas = new LatLng(41.068238, 23.390686);
        LatLng anwKamila = new LatLng(41.058320, 23.424134);
        LatLng katwKamila = new LatLng(41.020431, 23.483293);
        LatLng mitrousi = new LatLng(41.058680, 23.457547);
        LatLng koumaria = new LatLng(41.016434, 23.434656);
        LatLng skoutari = new LatLng(41.020032, 23.520701);
        LatLng adelfiko = new LatLng(41.014645, 23.457354);
        LatLng agiaEleni = new LatLng(41.003545, 23.559196);
        LatLng peponia = new LatLng(40.988154, 23.516756);
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, provatas, anwKamila, koumaria, adelfiko));
        Polyline polyline2 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, mitrousi, anwKamila));
        Polyline polyline3 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, mitrousi, katwKamila, koumaria));
        Polyline polyline4 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, skoutari, katwKamila));
        Polyline polyline5 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, skoutari, peponia, adelfiko));
        Polyline polyline6 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, skoutari, agiaEleni, peponia, adelfiko));
        Polyline polyline7 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(serres, mitrousi, koumaria, adelfiko));
    }
}
