package newapp.com.example.dipanshugupta.tosee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dipanshu Gupta on 2/12/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Patent.db";
    public static final String TABLE_NAME = "patent_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "AGE";
    public static final String COL_4 = "UDAI";
    public static final String COL_5 = "SYMPTOMS";
    public static final String COL_6 = "DIAGNOSIS";
    public static final String COL_7 = "MEDICINE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE TEXT,UDAI INTEGER,SYMPTOMS TEXT,DIAGNOSIS TEXT,MEDICINE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String age, String udai, String symptoms, String diagnosis, String medicine) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, age);
        contentValues.put(COL_4, udai);
        contentValues.put(COL_5, symptoms);
        contentValues.put(COL_6, diagnosis);
        contentValues.put(COL_7, medicine);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
    public boolean updateData(String name, String age, String udai, String symptoms, String diagnosis, String medicine){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, age);
        contentValues.put(COL_4, udai);
        contentValues.put(COL_5, symptoms);
        contentValues.put(COL_6, diagnosis);
        contentValues.put(COL_7, medicine);
        db.update(TABLE_NAME, contentValues, "UDAI = ?",new String[] { udai });
        return true;
    }
    public Integer deleteData (String udai) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "UDAI = ?",new String[] { udai });
    }
}