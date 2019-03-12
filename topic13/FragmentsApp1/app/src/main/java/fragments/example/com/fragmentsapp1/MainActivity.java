package fragments.example.com.fragmentsapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_mainactivity, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.fragmentexx1) {
            // react to the menu item being selected...
            Intent intent = new Intent(this,FragActivity.class);
            startActivityForResult(intent,0);
            // startActivity(intent);
            return true;
        } else  if(item.getItemId() == R.id.fragmentexx2) {
            // react to the menu item being selected...
            //Intent requestIntent = new Intent(this,ChooseLocationActivity.class);
            //Bundle bundle=new Bundle();
            //bundle.putDouble("com.example.cgallen.hellomap.laitude",latitude);
            //bundle.putDouble("com.example.cgallen.hellomap.longitude",longitude);
           // bundle.putInt("com.example.cgallen.hellomap.zoom",zoom);
           // requestIntent.putExtras(bundle);

           // startActivityForResult(requestIntent,1);
            return true;
        }
        return false;
    }







}
