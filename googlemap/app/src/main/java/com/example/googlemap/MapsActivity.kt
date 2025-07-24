package com.example.googlemap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {  // Must extend AppCompatActivity

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_maps_activity)  // Uses your fragment XML

        // Obtain the SupportMapFragment and get notified when the map is ready
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Map is ready, add your markers/customizations here
        val location = LatLng(-0.06366103474422066, 28.568626292731455)
        mMap.addMarker(
            MarkerOptions()
                .position(location)
                .title("My Location")
        )

        // Move camera to the location with zoom level
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))

        // Optional: Enable zoom controls
        mMap.uiSettings.isZoomControlsEnabled = true
    }
    }