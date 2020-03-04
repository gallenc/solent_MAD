package com.example.progressexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import android.content.Context;
import android.app.AlertDialog;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

// see https://developer.android.com/reference/android/os/AsyncTask

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button c = (Button) findViewById(R.id.btn1);
        c.setOnClickListener(this);
    }

    // Example onClick() which would be linked to a button press
    public void onClick(View view) {
        InnerTestTask task = new InnerTestTask();

        ProgressBar progress =  (ProgressBar) findViewById(R.id.progressBar);
        progress.setProgress(0);

        String filename = "http:\\google.com";
        task.execute(filename);
    }



    class InnerTestTask extends AsyncTask<String, Integer, String> {

        @Override
        public String doInBackground(String... urls) {

            TextView tv1 = (TextView)  findViewById(R.id.tv1);
            tv1.setText("downloading from "+urls[0]);

            // simulate download the file
            String message = "Successfully downloaded!";
            try {
                for (int i=0; i<100; i++){
                    for (int t=0; t<100000; t++) {
                        // delay
                    }
                    publishProgress(i);
                }


            } catch (Exception e) {
                message = e.toString();
            }
            return message;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            ProgressBar progressBar =  (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(progress[0]);
        }

        @Override
        public void onPostExecute(String message) {
            new AlertDialog.Builder(MainActivity.this).setMessage(message).
                    setPositiveButton("OK", null).show();
            ProgressBar progressBar =  (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(0);
            TextView tv1 = (TextView)  findViewById(R.id.tv1);
            tv1.setText("");
        }
    }
}