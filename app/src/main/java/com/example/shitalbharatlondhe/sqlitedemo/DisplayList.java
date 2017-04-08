package com.example.shitalbharatlondhe.sqlitedemo;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DisplayList extends ListActivity{

    DataHelper dh;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_list);

        dh = new DataHelper(this);

        //ListView list = (ListView)findViewById(R.id.listview);


         List<String> names = this.dh.dopop();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        setListAdapter(aa);

       /* List<String> list = this.dh.dopop();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,R.layout.activity_display_list,R.id.textView2,list);
        setListAdapter(aa);*/
    }
}
