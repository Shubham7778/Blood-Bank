package nnk.com.bloodbank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DonarListView extends AppCompatActivity {
    ListView lv;
    String name[]=new String[100];
    String email[]=new String[100];
    long cno[]=new long[100];
    String bdg[]=new String[100];
    String adrs[]=new String[100];
    String bg;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_list_view);

        lv=(ListView)findViewById(R.id.lv1);

        Intent i1=getIntent();
        Bundle b=i1.getExtras();
        bg=b.getString("k1");

        DonarDatabase ddb=new DonarDatabase(this);
        SQLiteDatabase db=ddb.getWritableDatabase();
        String qry="select * from donar_details where bloodGroup='"+bg+"'";

        Cursor c = db.rawQuery(qry,null);
        if(c.moveToFirst()) {
            do {
                name[i] = c.getString(0);
                email[i] = c.getString(3);
                cno[i] = c.getLong(4);
                adrs[i] = c.getString(5);
                bdg[i] = c.getString(6);
                i++;
            } while (c.moveToNext());

            MyAdapter my = new MyAdapter(this, name, email, cno, bdg, adrs, i, R.layout.view_style);
            lv.setAdapter(my);
        }
        else
        {
            Toast.makeText(this,"no data available",Toast.LENGTH_SHORT).show();
        }
    }
}
