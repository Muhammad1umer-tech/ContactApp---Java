package com.example.activity3;

import android.provider.BaseColumns;

public final class contactContract {
    private contactContract(){}
    public static class contactEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "entry";
        public static final String CONTACT_ID = "ID";
        public static final String CONTACT_NAME = "name";
        public static final String CONTACT_PHONE = "Ph_no";
    }
}
