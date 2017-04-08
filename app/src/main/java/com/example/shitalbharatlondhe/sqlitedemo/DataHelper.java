package com.example.shitalbharatlondhe.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shital Bharat Londhe on 28-Nov-16.
 */

public class DataHelper {

        SQLiteDatabase db;
        Context context;
        ArrayList<String> item_InFo = new ArrayList<String>();

        public DataHelper(Context con) {
            this.context = con;

            SQLiteOpenHelper myHelper = new MyOpenHelper(this.context);
            this.db = myHelper.getWritableDatabase();
        }

        public void StuInsert(String SId, String SNm, String SAdd, String SNo) {
            ContentValues conV = new ContentValues();
            conV.put("Stu_Id", Integer.parseInt(SId));
            conV.put("Stu_Name", SNm);
            conV.put("Stu_Address", SAdd);
            conV.put("Stu_No", Integer.parseInt(SNo));

            long newrow = db.insert(MyOpenHelper.TABLE_NAME, null, conV);
            if (newrow >= 0) {
                mToast("insertion successful");
            } else {
                mToast("insertion fail");
            }
        }


        public void StuDelete(String SId) {
            String where = "Stu_Id = " + SId;
            int newrow = db.delete(MyOpenHelper.TABLE_NAME, where, null);
            System.out.println(newrow);

            if (newrow == 0) {
                mToast("Data is not Deleted");

            } else {
                mToast("Data is Deleted");
            }


            dopop();

        }


        public void StuUpdate(String SId, String SNm, String SAdd, String SNo) {
            ContentValues conV = new ContentValues();
            conV.put("Stu_Id", Integer.parseInt(SId));
            conV.put("Stu_Name", SNm);
            conV.put("Stu_Address", SAdd);
            conV.put("Stu_No", Integer.parseInt(SNo));

            String where = "Stu_Id = " + SId;
            int newrow = db.update(MyOpenHelper.TABLE_NAME, conV, where, null);
            if (newrow == 0) {
                mToast("Data is not updated");

            } else {
                mToast("Data is updated");
            }


            dopop();


        }

        public List<String> dopop() {
            item_InFo.clear();
            Cursor c = db.rawQuery("SELECT * FROM Student", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String sid = c.getString(c.getColumnIndex("Stu_Id"));
                        String sname = c.getString(c.getColumnIndex("Stu_Name"));
                        String saddress = c.getString(c.getColumnIndex("Stu_Address"));
                        String sno = c.getString(c.getColumnIndex("Stu_No"));
                        item_InFo.add(sid + "--" + sname + "--" + saddress + "--" + sno);
                    }
                    while (c.moveToNext());
                }
            } else {
                mToast("Table as No contain");
            }
            c.close();
            //	dbClose(db);
            return item_InFo;
        }


        private void mToast(String text) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

        }

        public void dbClose(SQLiteDatabase db) {
            db.close();
        }


        public Boolean logintabelcheck(String UNm, String Pass) {
            Boolean result = false;
            Cursor c = db.rawQuery("SELECT * FROM LoginStudent", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String uid = c.getString(c.getColumnIndex("UserName"));
                        String upass = c.getString(c.getColumnIndex("PassWord"));

                        if (uid.equals(UNm) && upass.equals(Pass)) {
                            System.out.println("In condition");
                            result = true;
                            break;
                        }
                    }
                    while (c.moveToNext());
                }
            } else {
                result = false;
            }
            c.close();

            return result;

        }
    }
