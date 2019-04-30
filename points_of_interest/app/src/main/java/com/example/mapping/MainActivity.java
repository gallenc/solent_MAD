package com.example.mapping;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.Location;

import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LocationListener
{

    MapView mv;
    boolean isRecording;
    public static double latitude;
    public static double longitude;
    ItemizedIconOverlay<OverlayItem> items;
    /** Called when the activity is first created. */
    @Override

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.btn1);
        b.setOnClickListener(this);

        mv = findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        LocationManager mgr=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);


        mv.getController().setCenter(new GeoPoint(52, 0.72));

        if (savedInstanceState != null)
        {
            isRecording = savedInstanceState.getBoolean ("isRecording");
        }
        items = new ItemizedIconOverlay<OverlayItem>(this, new ArrayList<OverlayItem>(), null);



    }
    private void addPoiToMap()
    {
        for (POI poi :PoiList.getPoilist())
        {
            OverlayItem poiOverlay = new OverlayItem(poi.getName(), poi.getType() + poi.getDescription(), new GeoPoint(poi.getLat(), poi.getLon()));
            items.addItem(poiOverlay);
        }

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            // react to the menu item being selected...
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;

        }
        if(item.getItemId() == R.id.preferences)
        {
            Intent intent = new Intent(this, MyPrefsActivity.class);
            startActivityForResult(intent, 1);
            return true;
        }
        if(item.getItemId() == R.id.createPOI)
        {
            System.out.println("debug message, create PoiActivity pressed");
            Intent intent = new Intent(this, PoiActivity.class);
            startActivityForResult(intent, 2);
            return true;
        }
        return false;
    }

    private void startActivityForResults(Intent intent, int i) {
    }

    public void onLocationChanged(Location newLoc) {
        Double lat = (newLoc.getLatitude());
        Double lng = (newLoc.getLongitude());

        mv.getController().setCenter(new GeoPoint(lat, lng));
        latitude = lat;
        longitude = lng;
    }

    /*public void onLocationChanged(Location newLoc)
    {

        Toast.makeText
                (this, "Location=" +
                        newLoc.getLatitude()+ " " +
                        newLoc.getLongitude() , Toast.LENGTH_LONG).show();
    }

    */public void onProviderDisabled(String provider)
    {
        Toast.makeText(this, "Provider " + provider +
                " disabled", Toast.LENGTH_LONG).show();
    }

    public void onProviderEnabled(String provider)
    {
        Toast.makeText(this, "Provider " + provider +
                " enabled", Toast.LENGTH_LONG).show();

    }

    public void onStatusChanged(String provider,int status,Bundle extras)
    {

        Toast.makeText(this, "Status changed: " + status,
                Toast.LENGTH_LONG).show();
    }

    /*protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebikemap = extras.getBoolean("com.example.hikebikemap");
                if(hikebikemap==true)
                {
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }

            }
        }
    }*/
    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==2)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                String nameIn=extras.getString("name_key");
                String typeIn=extras.getString("type_key");
                String descIn=extras.getString("desc_key");
                OverlayItem poiOverlay = new OverlayItem(nameIn, typeIn + descIn, new GeoPoint(latitude, longitude));

                items.addItem(poiOverlay);
                mv.getOverlays().add(items);

            }
        }
    }


    public void onClick(View view)
        {
            EditText et1 = (EditText)findViewById(R.id.et1);
            EditText et2 = (EditText)findViewById(R.id.et2);
            double lon = Double.parseDouble(et1.getText().toString());
            double lat = Double.parseDouble(et2.getText().toString());
            mv.getController().setCenter(new GeoPoint(lat, lon));
        }


    public void onResume()
    {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // do something with the preference data...
    }
    public void onDestroy()
    {
        super.onDestroy();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean ("isRecording", isRecording);
        editor.commit();
    }
   /* public void onSaveInstanceState (Bundle savedInstanceState)
    {
        savedInstanceState.putBoolean("isRecording", isRecording);
    }
*/


}

