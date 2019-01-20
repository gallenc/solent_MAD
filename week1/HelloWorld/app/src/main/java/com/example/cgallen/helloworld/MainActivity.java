package com.example.cgallen.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;  // imported

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // exercise 1
        //setContentView(R.layout.activity_main); // commented out
        //TextView tv=new TextView(this);
        //tv.setText("Hello World!");
        //setContentView(tv);

        // exercise 2
        setContentView(R.layout.activity_main);
    }
}
