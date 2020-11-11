package com.example.mapmo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db").build();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(35.177184, 126.912472); // 전대 스타벅스 좌표
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("스타벅스");
        markerOptions.snippet("개발 장소");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera((CameraUpdateFactory.newLatLngZoom(location, 16)));
    }
}
