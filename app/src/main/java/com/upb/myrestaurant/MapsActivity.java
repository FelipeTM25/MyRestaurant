package com.upb.myrestaurant;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.upb.myrestaurant.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng upbMedellin = new LatLng(6.224275, -75.576347);
        LatLng laureles = new LatLng(6.245740, -75.592915);
        LatLng centro = new LatLng(6.246704, -75.569956);
        LatLng poblado = new LatLng(6.196526, -75.565571);
        LatLng belen = new LatLng(6.231881, -75.604805);

        mMap.addMarker(new MarkerOptions()
                .position(laureles)
                .title("Sede Laureles")
                .snippet("Calle 70 # 52-72, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logres)));

        mMap.addMarker(new MarkerOptions()
                .position(poblado)
                .title("Sede Poblado")
                .snippet("Carrera 43A # 7-50, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logres)));

        mMap.addMarker(new MarkerOptions()
                .position(centro)
                .title("Sede Centro")
                .snippet("Calle 52 # 51-11, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logres)));

        mMap.addMarker(new MarkerOptions()
                .position(belen)
                .title("Sede Belen")
                .snippet("Carrera 76 # 33A-44, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logres)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upbMedellin, 13));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Set the custom info window adapter
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
    }
}
