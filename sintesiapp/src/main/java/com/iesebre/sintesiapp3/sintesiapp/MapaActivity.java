package com.iesebre.sintesiapp3.sintesiapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapaActivity extends Activity {

    GoogleMap map;
    private static final LatLng EL_TEU_RESTAURANT = new LatLng(40.81471, 0.515187);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        try {
            if (map == null){
                map=((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            }
            Marker rest = map.addMarker(new MarkerOptions().position(EL_TEU_RESTAURANT).title("El teu restaurant"));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(EL_TEU_RESTAURANT).zoom(16).build();
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mapa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
