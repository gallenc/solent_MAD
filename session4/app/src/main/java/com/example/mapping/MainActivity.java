package com.example.mapping;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.EditText;
=======
>>>>>>> 1cfe8bf2fb52a1ce27cc902026a8e7223a22b67e

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
<<<<<<< HEAD
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
=======
>>>>>>> 1cfe8bf2fb52a1ce27cc902026a8e7223a22b67e

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    MapView mv;

    /** Called when the activity is first created. */
    @Override
<<<<<<< HEAD
    public void onCreate(Bundle savedInstanceState) {
=======
    public void onCreate(Bundle savedInstanceState)
    {
>>>>>>> 1cfe8bf2fb52a1ce27cc902026a8e7223a22b67e

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        Button b = (Button) findViewById(R.id.btn1);
        b.setOnClickListener(this);

=======
>>>>>>> 1cfe8bf2fb52a1ce27cc902026a8e7223a22b67e

        mv = findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
<<<<<<< HEAD
        mv.getController().setCenter(new GeoPoint(51.05, -0.72));
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
            return true;
            Intent intent = new Intent(this,mapChooseActivity.class);
            startActivity(intent);
        }
        return false;
    }



    public void onClick(View view)
        {
            EditText et1 = (EditText)findViewById(R.id.et1);
            EditText et2 = (EditText)findViewById(R.id.et2);
            double lon = Double.parseDouble(et1.getText().toString());
            double lat = Double.parseDouble(et2.getText().toString());
            mv.getController().setCenter(new GeoPoint(lat, lon));
        }



=======
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));
    }
>>>>>>> 1cfe8bf2fb52a1ce27cc902026a8e7223a22b67e
}
