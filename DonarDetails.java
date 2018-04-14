package nnk.com.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DonarDetails extends AppCompatActivity {
    TextView tv2,tv3,tv4,tv5;
    long cno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_details);

        tv2=(TextView)findViewById(R.id.nm);
        tv3=(TextView)findViewById(R.id.bdg);
        tv4=(TextView)findViewById(R.id.city);
        tv5=(TextView)findViewById(R.id.cno);

        Intent i1=getIntent();
        Bundle b=i1.getExtras();
        String name=b.getString("k2");
        String bdg=b.getString("k3");
        String city=b.getString("k4");
        cno=b.getLong("k5");

        tv2.setText("name: "+name);
        tv3.setText("bloodgroup:"+bdg);
        tv4.setText("city: "+city);
        tv5.setText("contact no: "+cno);
    }
    public void call(View v)
    {
       Intent callIntent=new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+cno));
        startActivity(callIntent);
    }
}
