package nnk.com.bloodbank;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText et3,et4,et5,et6,et7;
    RadioGroup rg;
    RadioButton rb;
    int id;
    ArrayAdapter aa;
    Spinner sp;
    String items[]={"Bloodgroup","A+","A-","B+","B-","O+","O-","AB+","AB-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et3=(EditText)findViewById(R.id.name);
        et4=(EditText)findViewById(R.id.email);
        et5=(EditText)findViewById(R.id.phn);
        et6=(EditText)findViewById(R.id.addres);
        et7=(EditText)findViewById(R.id.pass);

        rg=(RadioGroup)findViewById(R.id.rg1);
        id=rg.getCheckedRadioButtonId();
        rb=(RadioButton)findViewById(id);
        sp=(Spinner)findViewById(R.id.sp1);

        aa=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,items);
        sp.setAdapter(aa);

    }
    public void register2(View v)
    {
        String name=et3.getText().toString().trim();
        String email=et4.getText().toString().trim();
        String cno=et5.getText().toString().trim();
        String adrs=et6.getText().toString().trim();
        String pass=et7.getText().toString().trim();
        String bdg=sp.getSelectedItem().toString().trim();

        id=rg.getCheckedRadioButtonId();
        rb=(RadioButton)findViewById(id);
        String sex=rb.getText().toString().trim();

        long cn=Long.parseLong(cno);

        DonarDatabase ddb=new DonarDatabase(this);
        SQLiteDatabase db=ddb.getWritableDatabase();
        String qry="insert into donar_details values('"+name+"','"+pass+"','"+sex+"','"+email+"',"+cn+",'"+adrs+"','"+bdg+"')";
        db.execSQL(qry);

        Toast.makeText(this,"details saved",Toast.LENGTH_LONG).show();
        finish();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

    }
}


