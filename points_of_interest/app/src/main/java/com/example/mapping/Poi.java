package com.example.mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Poi extends AppCompatActivity implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi);
        EditText name_in= findViewById(R.id.et1);
        EditText type_in= findViewById(R.id.et2);
        EditText desc_in= findViewById(R.id.et3);
        Button btn1 = (Button) findViewById(R.id.btnAddPoi);
        btn1.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        EditText name_in= findViewById(R.id.et1);
        EditText type_in= findViewById(R.id.et2);
        EditText desc_in= findViewById(R.id.et3);
        String name_out= name_in.getText().toString();
        String type_out= type_in.getText().toString();
        String desc_out= desc_in.getText().toString();
        bundle.putString("name_key", name_out);
        bundle.putString("type_key", type_out);
        bundle.putString("desc_key", desc_out);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
