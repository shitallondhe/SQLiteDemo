package com.example.shitalbharatlondhe.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Shital Bharat Londhe on 28-Nov-16.
 */

public class MyOpenHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "StudentDataBase";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Student";
    public static final String L_TABLE_NAME = "LoginStudent";
    Context mycontext;

    public MyOpenHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mycontext= context;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE Student(Stu_Id Integer,Stu_Name TEXT,Stu_Address TEXT,Stu_No Integer)");
        db.execSQL("Create Table LoginStudent(UserName Text,PassWord Text)");

        ContentValues ltable = new ContentValues();
        /*ltable.put("UserName", "shital");
        ltable.put("PassWord", "shital");
*/
        long newrow= db.insert(L_TABLE_NAME, null, ltable);
        if(newrow >= 0)
        {
            mToast("insertion successful");
        }
        else
        {
            mToast("insertion fail");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    private void mToast(String string)
    {
        // TODO Auto-generated method stub
        Toast.makeText(mycontext,string,Toast.LENGTH_SHORT).show();

        //Here pass in toast class mycontext bcz it gives form memory.means it holds activity memory
    }

}
