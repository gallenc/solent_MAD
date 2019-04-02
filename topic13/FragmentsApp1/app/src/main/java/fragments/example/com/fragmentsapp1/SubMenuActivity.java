package fragments.example.com.fragmentsapp1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SubMenuActivity  extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenuactivity);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_submenuactivity, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // get the text view
        TextView tv2 = (TextView) findViewById(R.id.tv2);

        // react to the menu item being selected...
        if (item.getItemId() == R.id.submenu1) {
            tv2.setText("submenu 1 selected");
            return true;
        } else if (item.getItemId() == R.id.submenu2) {
            tv2.setText("submenu 2 selected");
            return true;
        }
        return false;
    }

}
