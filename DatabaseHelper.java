package com.example.kevin.nextgen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * fordatabase activities
 */

 class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION ='1';
    private static final String COLUMN_ID ="id";
    private static final String DATABASE_NAME ="Contact.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_NAME= "name";
    private static final String COLUMN_EMAIL= "email";
    private static final String COLUMN_UNAME= "uname";
    private static final String COLUMN_PASS = "pass";
    //SQLiteDatabase db;

    /**private static final  String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" (" +
            COLUMN_ID+" PRIMARY KEY NOT NULL, "+
            COLUMN_NAME+" TEXT NOT NULL, "+
            COLUMN_EMAIL+" TEXT NOT NULL, "+
            COLUMN_UNAME+" TEXT NOT NULL, "+
            COLUMN_PASS+" TEXT NOT NULL);";**/
    private static final  String TABLE_CREATE ="create table contacts (id integer primary key not null, "+
            "name text not null,email text not null,uname text not null,pass text not null);";
    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
       // this.db =db;
    }
//    for sign up
     void insertContact(Contact c){
       SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID, count);
        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());
        db.insert(TABLE_NAME, null, values);
        db.close();
        /** ContentValues values = new ContentValues();
         values.put(COLUMN_NAME, c.getName());
         values.put(COLUMN_EMAIL, c.getEmail());
         values.put(COLUMN_UNAME, c.getUname());
         values.put(COLUMN_PASS, c.getpass());
         db.insert(TABLE_NAME, null, values);
         db.close();**/
    }
   public String searchPass(String uname){
      //problem
         /**  db = this.getReadableDatabase();
           String query = "select uname, pass from " + TABLE_NAME;
           Cursor cursor = db.rawQuery(query, null);
           String usn, psw;
           psw = "not found";
           if (cursor.moveToFirst()) {
               do {
                   usn = cursor.getString(0);
                   if (usn.equals(usrname)) {
                       psw = cursor.getString(1);
                       // cursor.close();
                       break;
                   }
               } while (cursor.moveToNext());
           }
        return psw;**/
       SQLiteDatabase db;
       db =getReadableDatabase();
       String query = "SELECT uname,pass FROM "+TABLE_NAME;
       Cursor cursor = db.rawQuery(query, null);
       String a,b;
       b="not found";
       cursor.moveToFirst();
       if(cursor.moveToFirst()){
           do{
            a=cursor.getString(0);
               if(a.equals(uname)){
                   b=cursor.getString(1);
                   break;
               }
           }while(cursor.moveToNext());
       }
       return b;

   }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
         //db.execSQL(query);
        //this.onCreate(db);

    }
}
