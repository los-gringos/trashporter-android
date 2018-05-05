package io.los.gringos.trashporter.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import io.los.gringos.trashporter.R;
import io.los.gringos.trashporter.android.utils.LocationUtil;

public class Map extends AppCompatActivity implements OnMapReadyCallback {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
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


        

        int i = 5;

        googleMap.addMarker(new MarkerOptions().position(serres)
                .title("Marker in Serres"));
        googleMap.addMarker(new MarkerOptions().position(provatas)
                .title("Marker in provatas"));
        googleMap.addMarker(new MarkerOptions().position(anwKamila)
                .title("Marker in Anw Kamila"));
        googleMap.addMarker(new MarkerOptions().position(katwKamila)
                .title("Marker in Katw Kamila"));
        googleMap.addMarker(new MarkerOptions().position(mitrousi)
                .title("Marker in Mitrousi"));
        googleMap.addMarker(new MarkerOptions().position(koumaria)
                .title("Marker in Koumaria"));
        googleMap.addMarker(new MarkerOptions().position(skoutari)
                .title("Marker in Skoutari"));
        googleMap.addMarker(new MarkerOptions().position(adelfiko)
                .title("Marker in Adelfiko"));
        googleMap.addMarker(new MarkerOptions().position(agiaEleni)
                .title("Marker in Agia Eleni"));
        googleMap.addMarker(new MarkerOptions().position(peponia)
                .title("Marker in Peponia"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(serres));
    }
}
