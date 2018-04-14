package nnk.com.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class WelcomeDonar extends AppCompatActivity {

    Toolbar toolbar;
    public  Intent i1, i2;
    public Intent chooser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_donar);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void searchDonar(View v)
    {
        Intent i=new Intent(this,SearchBlood.class);
        startActivity(i);
    }
    public void bloodBank(View v)
    {
        i1 = new Intent(Intent.ACTION_VIEW);
        chooser = Intent.createChooser(i1, "choose a map app");
        i1.setData(Uri.parse("geo:0,0?q=blood bank"));
        this.startActivity(i1);

        /*Uri ref=Uri.parse("geo:0,0?q=hospital");
        Intent i=new Intent(Intent.ACTION_VIEW,ref);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);*/
    }

    public void myDetails(View v)
    {
        /*i2 = new Intent(this, bloostock.class);
        startActivity(i2);*/
        i2 = new Intent(Intent.ACTION_VIEW);
        i2.setData(Uri.parse("http://www.eraktkosh.in/BLDAHIMS/bloodbank/stockAvailability.cnt"));
        startActivity(i2);

    }
}

