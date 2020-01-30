package com.example.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists user");

    }

    //DATABASE INSERTION

    public boolean insert(String email,String password){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //check if email exist

   public Boolean chkemail(String email){

        SQLiteDatabase db=this.getReadableDatabase();
       Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
       if(cursor.getCount()>0) return false;
       else return true;

   }

   //check the email and password

    public Boolean emailpassword(String email,String password){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if (cursor.getCount()>0) return true;
        else return false;

    }
}
