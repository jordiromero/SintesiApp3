package com.iesebre.sintesiapp3.sintesiapp;

import java.util.Locale;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ConsultaMenuActivity extends FragmentActivity implements ActionBar.TabListener {
    private static final String STATE_SELECTED_ITEM = "selected_item";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_menu_activity);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Tota la carta").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Entrants").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Amanides").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Sopes").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Arrosos").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Pasta").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Carns").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Peixos").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Carta de postres").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Carta de vins").setTabListener(this));





    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_ITEM)) {
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_ITEM, getActionBar().getSelectedNavigationIndex());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.consulta_menu, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int index = tab.getPosition();
        switch (index){
            case 0:
                setContentView(R.layout.fragment_consulta_menu_activity);
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case 1:
                setContentView(R.layout.entrants_layout);
                break;
            case 2:
                setContentView(R.layout.amanida_layout);
                break;
            case 3:
                setContentView(R.layout.sopes_layout);
                break;
            case 4:
                setContentView(R.layout.arrosos_layout);
                break;
            case 5:
                setContentView(R.layout.pasta_layout);
                break;
            case 6:
                setContentView(R.layout.carns_layout);
                break;
            case 7:
                setContentView(R.layout.peixos_layout);
                break;
            case 8:
                setContentView(R.layout.postres_layout);
                break;
            case 9:
                setContentView(R.layout.vins_layout);
                break;
            default:
                Toast.makeText(this, "Selecciona una pestanya.", Toast.LENGTH_LONG).show();
                break;

        }





    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    



}
