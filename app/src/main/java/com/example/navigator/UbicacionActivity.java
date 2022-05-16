package com.example.navigator;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.navigator.databinding.ActivityUbicacionBinding;

public class UbicacionActivity extends FragmentActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityUbicacionBinding binding;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUbicacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        /*

        */
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Double latitude = -12.053977;
        Double longitude = -77.043122;

        ImageView imgRegresarMaps;
        imgRegresarMaps = findViewById(R.id.imgRegresarMaps);
        imgRegresarMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        mMap = googleMap;
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            latitude = bundle.getDouble("key_latitude");
            longitude = bundle.getDouble("key_longitude");
        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Ubicación Tienda"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));
    }
}