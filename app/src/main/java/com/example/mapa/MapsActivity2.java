package com.example.mapa;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapa.databinding.ActivityMaps2Binding;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void changeActivity(View v){
        Intent intent = new Intent(this, storesList.class);
        startActivity(intent);

    }

    public void changeTerminal(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        mMap.setIndoorEnabled(false);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(false);
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng aicm = new LatLng(19.421895343410938, -99.07791714505319);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in AICM"));
        //mMap.setLatLngBoundsForCameraTarget(AICM);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aicm, 16.0f));
    }
}