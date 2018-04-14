package nnk.com.bloodbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by HP-PC on 29-06-2017.
 */

public class DonarDatabase extends SQLiteOpenHelper
{
    Context c;
    public DonarDatabase(Context context)
    {
        super(context,"donar_data",null,1);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table donar_details(name text,password text,sex text,email text,contact long,addres text,bloodgroup text)";
        db.execSQL(qry);
        Toast.makeText(c,"table created",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
