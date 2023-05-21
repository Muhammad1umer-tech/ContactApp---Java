package com.example.activity3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="contact.db";
    public static final int DATABASE_Version=1;
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(queries.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public boolean insert(contact c)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(contactContract.contactEntry.CONTACT_NAME,c.getName());
        values.put(contactContract.contactEntry.CONTACT_PHONE,c.getPh_no());

        long newRowId = sqLiteDatabase.insert(contactContract.contactEntry.TABLE_NAME, null, values);
        if(newRowId>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Cursor getlist()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor data = sqLiteDatabase.rawQuery("SELECT * FROM " + contactContract.contactEntry.TABLE_NAME,null);
return data;
    }

    public int update(contact c)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(contactContract.contactEntry.CONTACT_NAME,c.getName());
        values.put(contactContract.contactEntry.CONTACT_PHONE,c.getPh_no());

        return sqLiteDatabase.update(contactContract.contactEntry.TABLE_NAME,values,contactContract.contactEntry.CONTACT_ID + "=?", new String[]{String.valueOf(c.getId())});
    }

    public void delete(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(contactContract.contactEntry.TABLE_NAME,contactContract.contactEntry.CONTACT_NAME +"=?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();

    }

}
