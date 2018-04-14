package nnk.com.bloodbank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * Created by HP-PC on 30-06-2017.
 */

public class MyAdapter extends BaseAdapter {
    Context c;
    String name[];
    String email[];
    long cno[];
    String bdg[];
    String adrs[];
    int layout,i;
    Button  b1;

    public MyAdapter(Context c,String name[],String email[],long cno[],String bdg[],String adrs[],int i,int view_style)
    {
        this.c=c;
        this.name=name;
        this.email=email;
        this.cno=cno;
        this.bdg=bdg;
        this.adrs=adrs;
        this.i=i;
        layout=view_style;
    }


    @Override
    public int getCount() {
        return i;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater li=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v1 = li.inflate(layout,parent,false);

        TextView tv=(TextView)v1.findViewById(R.id.tv1);
        tv.setText(name[position]);

        b1=(Button)v1.findViewById(R.id.view);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 {
                     Intent i=new Intent(c,DonarDetails.class);
                     i.putExtra("k2",name[position]);
                     i.putExtra("k3",bdg[position]);
                     i.putExtra("k4",adrs[position]);
                     i.putExtra("k5",cno[position]);
                     c.startActivity(i);

                }

            }
        });
        return v1;
    }
}
