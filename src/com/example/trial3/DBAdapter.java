package com.example.trial3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_ROWID1 = "_idc";
    static final String KEY_NAME = "name";
    static final String KEY_NAME1 = "namec";
    
    static final String KEY_PHONE = "phone";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "Login_Cred";
    static final String DATABASE_TABLE1 = "Cities";
    static final String DATABASE_TABLE2="food";
    
    static final int DATABASE_VERSION = 2;

    static final String DATABASE_CREATE =
        "create table Login_Cred (_id integer primary key autoincrement, "
        + "name text not null, phone text not null);";
    static final String DATABASE_CREATE1 =
            "create table Cities (_idc integer primary key autoincrement, "
            + "namec text not null);";
    static final String DATABASE_CREATE3 =
            "create table food (_idf integer primary key autoincrement, "
            + "starter text,soup text,salad text,main_course text,bread text,rice text,dessert text);";
    static final String DATABASE_DELETE = "DROP TABLE IF EXISTS Login_Cred";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    
   

   



	private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
               db.execSQL(DATABASE_CREATE1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
  

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS Login_Cred");
            onCreate(db);
        }
    }
	


    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() 
    {
        DBHelper.close();
    }

    //---insert a contact into the database---
    public long insertContact(String name, String phone) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_PHONE, phone);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public long insertCity(String namec) 
    {
   	ContentValues initialValues1 = new ContentValues();
        initialValues1.put(KEY_NAME1, namec);
        
        return db.insert(DATABASE_TABLE1,null,initialValues1);
    } 
    public long insertFood(String starter,String soup,String salad,String main_course,String bread,String rice,String dessert){
    	ContentValues initialValues2= new ContentValues();
    	   initialValues2.put(starter, starter);
           initialValues2.put(soup, soup);
           initialValues2.put(main_course,main_course);
           initialValues2.put(bread,bread);
           initialValues2.put(rice, rice);
           initialValues2.put(dessert, dessert);
           return db.update(DATABASE_TABLE2, initialValues2,null,null);
    	
    }
    public Cursor getfood(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE2, new String[] {"starter",
                "soup",",main_course","bread","rice","dessert"}, "_idf" + "=" + rowId, null,
                null, null, null, null);
    //    if (mCursor != null) {
         //   mCursor.moveToFirst();
      //  }
        return mCursor;
    }
    //---deletes a particular food---
    public boolean deletefood(long rowId) 
    {
        return db.delete(DATABASE_TABLE2, "_idf" + "=" + rowId, null) > 0;
    }
    
    
    //---deletes a particular contact---
    public boolean deleteContact(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    
    public boolean deleteContact1(long rowId) 
    {
        return db.delete(DATABASE_TABLE1, KEY_ROWID1 + "=" + rowId, null) > 0;
    }
    
   

    //---retrieves all the contacts---
    public Cursor getAllContacts()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,
                KEY_PHONE}, null, null, null, null, null);
    }
    public Cursor getAllCities()
    {
        return db.query(DATABASE_TABLE1, new String[] {KEY_ROWID1, KEY_NAME1
              }, null, null, null, null, null);
    }
    //---retrieves a particular contact---
    public Cursor getContact(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_NAME, KEY_PHONE}, KEY_ROWID + "=" + rowId, null,
                null, null, null, null);
    //    if (mCursor != null) {
         //   mCursor.moveToFirst();
      //  }
        return mCursor;
    }
  
    
    public Cursor getCity(long rowId1) throws SQLException 
    {
        Cursor mCursor1 =
                db.query(true, DATABASE_TABLE1, new String[] {KEY_ROWID1,
                KEY_NAME1}, KEY_ROWID1 + "=" + rowId1, null,
                null, null, null, null);
        if (mCursor1 != null) {
            mCursor1.moveToFirst();
        }
        return mCursor1;
    }

    //---updates a contact---
    public boolean updateContact(long rowId, String name, String email) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_PHONE, email);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }

	

	
	

}
