package com.example.activity3;

public class queries {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + contactContract.contactEntry.TABLE_NAME + " (" +
                    contactContract.contactEntry._ID + " INTEGER PRIMARY KEY," +
                    contactContract.contactEntry.CONTACT_NAME + " TEXT," +
                    contactContract.contactEntry.CONTACT_PHONE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + contactContract.contactEntry.TABLE_NAME;


    public static final String SELECT_ALL =
            "SELECT * FROM "+ contactContract.contactEntry.TABLE_NAME;



}
