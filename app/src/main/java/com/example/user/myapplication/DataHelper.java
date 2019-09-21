package com.example.user.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    /** deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     nama-nama kolom, nama database, dan versi dari database **/

    public static final String TABLE_NAME = "data_mhs";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "nama_mhs";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_JURUSAN = "jurusan";
    private static final String db_name = "datamahasiswa.db";
    private static final int db_version = 1;

    /** Perintah SQL untuk membuat tabel database baru **/
    private static final String db_create = "create table "
            + TABLE_NAME + "("+ COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME + "varchar not null, "
            + COLUMN_NIM + "varchar  not null, "
            + COLUMN_JURUSAN + "varchar  not null);";

    public DataHelper(Context context){
        super(context, db_name, null, db_version);
    }

    /** Mengeksekusi perintah SQL di atas untuk membuat tabel database baru **/
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(db_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DataHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
