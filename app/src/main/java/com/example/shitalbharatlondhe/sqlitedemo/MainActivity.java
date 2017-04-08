package com.example.shitalbharatlondhe.sqlitedemo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DataHelper dh;
    EditText sid,sname,sadd,sno;
    ListView li;
    ArrayList<String> Stu_List;
    ArrayAdapter<String> Stu_AA;
    private String[] lv_arr = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sid =(EditText)findViewById(R.id.edt_Stu_Id);
        sname=(EditText)findViewById(R.id.edt_Stu_Name);
        sadd =(EditText)findViewById(R.id.edt_Stu_Address);
        sno=(EditText)findViewById(R.id.edt_Stu_No);

        li = (ListView) findViewById(R.id.list1);

        dh = new DataHelper(this);

    }

    public void clickinsert(View v)
    {

        dh.StuInsert(sid.getText().toString(),sname.getText().toString(),sadd.getText().toString(), sno.getText().toString());
        sid.setText("");
        sname.setText("");
        sadd.setText("");
        sno.setText("");
        //aa.notifyDataSetChanged();
    }


    public void clickdelete(View v)
    {

        dh.StuDelete(sid.getText().toString());
        // aa.notifyDataSetChanged();

    }


    public void clickdisplay(View v)
    {


       /* List<String> names = this.dh.dopop();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        li.setAdapter(aa);*/
       Intent intent = new Intent(MainActivity.this,DisplayList.class);
        startActivity(intent);






    }
    public void clickupdate(View v)
    {
        dh.StuUpdate(sid.getText().toString(),sname.getText().toString(),sadd.getText().toString(), sno.getText().toString());
        //aa.notifyDataSetChanged();

    }

}

