package com.example.mapping;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MyPrefsActivity extends PreferenceActivity, AppCompatActivity
{
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }


}
