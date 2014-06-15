package com.iesebre.sintesiapp3.sintesiapp;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ListActivity {
    private ProgressDialog pDialog;

    //url json
    private static String url = "http://192.168.1.39/sintesi/index.php/main/jsonGet";
    //json node names.
    private static final String TAG_MENU = "menu";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_NAME = "name";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_TYPE = "m_type";
    private static final String TAG_PRICE = "price";
    //jsonArray
    JSONArray menu = null;
    //hasmap LISTVIEW.
    ArrayList<HashMap<String, String>> menuList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_consulta_menu_activity);

        menuList = new ArrayList<HashMap<String, String>>();
        ListView lv = getListView();

        new GetMenu().execute();
    }

    private class GetMenu extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Espera un moment... ");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0){
            //create service handler
            ServiceHandler sh = new ServiceHandler();
            String jsonStr = sh.makeServiceCall(url,ServiceHandler.POST);
            if(jsonStr !=null){
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    menu=jsonObj.getJSONArray(TAG_MENU);
                    for (int i = 0; i<menu.length();i++){
                        JSONObject m = menu.getJSONObject(i);
                        String image = m.getString(TAG_IMAGE);
                        String name = m.getString(TAG_NAME);
                        String description = m.getString(TAG_DESCRIPTION);
                        String m_type = m.getString(TAG_TYPE);
                        String price = m.getString(TAG_PRICE);
                        HashMap<String,String> menu = new HashMap<String, String>();
                        menu.put(TAG_IMAGE, image);
                        menu.put(TAG_NAME, name);
                        menu.put(TAG_DESCRIPTION, description);
                        menu.put(TAG_TYPE, m_type);
                        menu.put(TAG_PRICE, price);
                        menuList.add(menu);
                    }


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }else{
                Log.e("ServiceHandler", "No ha pogut conseguir dades de la url");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);

            if(pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, menuList,
                    R.layout.list_item_menu_tot, new String[] { TAG_IMAGE, TAG_NAME,
            TAG_DESCRIPTION, TAG_TYPE,TAG_PRICE}, new int[]{R.id.imageView,R.id.nom_tot,R.id.description_tot,R.id.tipus_tot,R.id.preu_tot}
            );
            setListAdapter(adapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
