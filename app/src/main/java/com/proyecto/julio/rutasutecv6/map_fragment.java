package com.proyecto.julio.rutasutecv6;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.model.people.Person;

/**
 * Created by julio on 04-23-17.
 */

public class map_fragment extends Fragment /*implements OnMapReadyCallback*/{
   /* MapView mapView;
    GoogleMap map;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.map_fragment,container,false);

        /*
        //obtengo el mapa del xml
        mapView = (MapView)view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        //obtengo el mapa de mapview
        mapView.getMapAsync(this);
        */
        return view;
    }
    /*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(13.6462418,-89.10387830000002);
        float zoom = 13;
        map=googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        map.addMarker(new MarkerOptions().position(latLng));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));
    }
    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onPause(){
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mapView.onLowMemory();
    }
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
