package com.iesebre.sintesiapp3.sintesiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AndroidDashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        // Dashboard  Consulta Menu button
        Button btn_consulta_menu = (Button) findViewById(R.id.btn_consulta_menu);

        // Dashboard Crea Reserva button
        Button btn_crea_reserva = (Button) findViewById(R.id.btn_crea_reserva);

        // Dashboard Messages button
        Button btn_consulta_reserva = (Button) findViewById(R.id.btn_busca_reserva);

        // Dashboard MAPA button
        Button btn_mapa = (Button) findViewById(R.id.btn_mapa);


        /**
         * Handling all button click events
         * */

        // Listening to Consulta Menu button click
        btn_consulta_menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), ConsultaMenuActivity.class);
                startActivity(i);
            }
        });

        // Listening Crea REserva button click
        btn_crea_reserva.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), CreaReservaActivity.class);
                startActivity(i);
            }
        });

        // Listening ConsultaReserva button click
        btn_consulta_reserva.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), ConsultaReservaActivity.class);
                startActivity(i);
            }
        });

        // Listening to Mapa button click
        btn_mapa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MapaActivity.class);
                startActivity(i);
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.android_dashboard, menu);
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
