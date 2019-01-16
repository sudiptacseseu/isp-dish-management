package com.example.sudip.sctnbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DISH.db";
    private static final String TABLE_NAME = "DISH_details";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String CONTACT = "Contact";
    private static final String ADDRESS = "Address";
    private static final String TAKA = "Taka";
    private static final String STATUS = "Status";
    private static final String DATE = "Date";


    private static final int VERSION_NUMBER = 2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY , "+NAME+" VARCHAR(255), "+CONTACT+" VARCHAR(20),"+ADDRESS+" VARCHAR(255),"+TAKA+" INTEGER(20), "+STATUS+" VARCHAR(50),"+DATE+" VARCHAR(50)) ";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM "+TABLE_NAME;
    private static final String DUE_ALL = "SELECT * FROM "+TABLE_NAME+" WHERE "+STATUS+" ='Due'";
    private static final String DUE_SUM = "SELECT COUNT("+STATUS+")FROM "+TABLE_NAME+" WHERE "+STATUS+" ='Due'";

    private Context context;

    public MyDatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            Toast.makeText(context, " onCreate is called",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{

            Toast.makeText(context, " onUpgrade is called",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();

        }
    }
    public long insertData(String id, String name, String contact, String address, String taka, String status, String date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(CONTACT,contact);
        contentValues.put(ADDRESS,address);
        contentValues.put(TAKA,taka);
        contentValues.put(STATUS,status);
        contentValues.put(DATE,date);
        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
    public Cursor displayallData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }
    public boolean updateContact(String id, String contact){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(CONTACT,contact);
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+ "= ?", new String[]{id});
        return true;
    }

    public boolean updatePayment(String id, String status, String date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(STATUS,status);
        contentValues.put(DATE,date);
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+ "= ?", new String[]{id});
        return true;
    }
    public boolean updateData(String id, String name, String contact, String address, String taka, String status, String date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(CONTACT,contact);
        contentValues.put(ADDRESS,address);
        contentValues.put(TAKA,taka);
        contentValues.put(STATUS,status);
        contentValues.put(DATE,date);

        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+ "= ?", new String[]{id});
        return true;
    }
    public Cursor displaydueData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(DUE_ALL,null);
        return cursor;
    }
    public Cursor displaytotalDue(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(DUE_SUM,null);
        return cursor;
    }
    public  Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return  sqLiteDatabase.delete(TABLE_NAME,ID+"= ?", new String[]{id});

    }

}
