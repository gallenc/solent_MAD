package fragments.example.com.fragmentsapp1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FragActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragactivity);

        PersonDetailsFragment personDetailsFrag = (PersonDetailsFragment)getFragmentManager().findFragmentById(R.id.personDetailsFrag);
        personDetailsFrag.setText("Details on a famous person will appear here!");
    }
}