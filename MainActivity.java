package nnk.com.bloodbank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
  //  Toolbar toolbar;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // toolbar = (Toolbar)findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        et1 = (EditText) findViewById(R.id.uname);
        et2 = (EditText) findViewById(R.id.pass);
    }

    public void register(View v) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void login(View v) {
        String uname = et1.getText().toString().trim();
        String pass = et2.getText().toString().trim();

       /* if (uname.isEmpty()) {
            et1.requestFocus();
            et1.setError("empty");
        }
        else
        {
            if (pass.isEmpty())
            {
                et2.requestFocus();
                et2.setError("empty");
            }
            else
            {*/
                DonarDatabase ddb=new DonarDatabase(this);
                SQLiteDatabase db=ddb.getWritableDatabase();
                String qry="select * from donar_details";
                Cursor c=db.rawQuery(qry,null);

                if(c.moveToFirst())
                {
                    String username = c.getString(0);
                    String password = c.getString(1);

                    if(username.equals(uname) && password.equals(pass))
                    {
                        Intent i=new Intent(this,WelcomeDonar.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(this,"invalid user",Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(this,"not register",Toast.LENGTH_SHORT).show();
                }
           // }
        //}
    }
}
