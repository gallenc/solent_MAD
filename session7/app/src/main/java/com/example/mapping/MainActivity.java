package com.example.mapping;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;



import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    MapView mv;
    boolean isRecording;

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

        mv.getController().setCenter(new GeoPoint(51.05, -0.72));

        if (savedInstanceState != null)
        {
            isRecording = savedInstanceState.getBoolean ("isRecording");
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
        return false;
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
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
        double lat = Double.parseDouble ( prefs.getString("lat", "50.9") );
        double lon = Double.parseDouble ( prefs.getString("lon", "-1.4") );
        boolean autodownload = prefs.getBoolean("autodownload", true);
        mv.getController().setCenter(new GeoPoint(lat, lon));


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
    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        savedInstanceState.putBoolean("isRecording", isRecording);
    }



}

