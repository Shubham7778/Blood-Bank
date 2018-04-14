package nnk.com.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchBlood extends AppCompatActivity {
    Spinner sp;
    String items[]={"Bloodgroup","A+","A-","B+","B-","O+","O-","AB+","AB-"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);

        sp=(Spinner)findViewById(R.id.sp2);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,items);
        sp.setAdapter(aa);
    }
    public void searchBloodGroup(View v)
    {
        String bloodgrp=sp.getSelectedItem().toString().trim();
        Intent i=new Intent(this,DonarListView.class);
        i.putExtra("k1",bloodgrp);
        startActivity(i);
    }
}
