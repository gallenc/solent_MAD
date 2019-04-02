package fragments.example.com.fragmentsapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MapExx1Activity  extends AppCompatActivity {


    //London: latitude 51.51, longitude -0.1
    public static final Double LONDON_LAT = 51.51;
    public static final Double LONDON_LON = -0.1;
    //Paris: latitude 48.85, longitude 2.34
    public static final Double PARIS_LAT = 48.85;
    public static final Double PARIS_LON = 2.34;
    //New York: latitude 40.75, longitude -74
    public static final Double NEWYORK_LAT = 40.75;
    public static final Double NEWYORK_LON = -74.0;





    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapexx1activity);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mapexx1activity, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        // get the map fragment
        MapExx1Fragment mapExx1Fragment = (MapExx1Fragment)getFragmentManager().findFragmentById(R.id.mapexx1frag);

        // react to the menu item being selected...
        if (item.getItemId() == R.id.map1London) {
            mapExx1Fragment.setLocation(LONDON_LAT,LONDON_LON);
            return true;
        } else if (item.getItemId() == R.id.map1Paris) {
            mapExx1Fragment.setLocation(PARIS_LAT,PARIS_LON);
            return true;
        }
        if (item.getItemId() == R.id.map1NewYork) {
            mapExx1Fragment.setLocation(NEWYORK_LAT,NEWYORK_LON);
            return true;
        }
        return false;
    }


}