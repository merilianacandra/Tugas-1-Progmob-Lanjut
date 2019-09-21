package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DataController {

    /** Inisialisasi SQLite Database **/
    private SQLiteDatabase database;

    /** Inisialisasi kelas DataHelper **/
    private DataHelper dataHelper;

    /** Mengambil semua kolom **/
    private String[] allColumns = {DataHelper.COLUMN_ID, DataHelper.COLUMN_NAME,
            DataHelper.COLUMN_NIM, DataHelper.COLUMN_JURUSAN};

    /** DataHelper diinstantiasi pada constructor **/
    public DataController(Context context){
        dataHelper = new DataHelper(context);
    }

    /** Membuka/membuat sambungan baru ke database **/
    public void open() throws SQLException{
        database = dataHelper.getWritableDatabase();
    }

    /** Menutup sambungan ke database **/
    public void close(){
        dataHelper.close();
    }

    /** Method untuk create/insert barang ke databse **/
    public Mahasiswa createMahasiswa(String nama, String nim, String jrsn){
        /** ContentValue yang berfungsi untuk memasangkan data dengan nama-nama kolom pada database **/
        ContentValues values = new ContentValues();
        values.put(DataHelper.COLUMN_NAME, nama);
        values.put(DataHelper.COLUMN_NIM, nim);
        values.put(DataHelper.COLUMN_JURUSAN, jrsn);

        /** Mengeksekusi perintah SQL insert data yg akan mengembalikan sebuah insert ID **/
        long inserId = database.insert(DataHelper.TABLE_NAME, null, values);

        /** Memanggil perintah SQL Select menggunakan cursor untuk melihat apakah data tadi sudah
         * masuk dengan menyesuaikan ID = insertID */
        Cursor cursor = database.query(DataHelper.TABLE_NAME, allColumns, DataHelper.COLUMN_ID +
                " = " + inserId, null, null, null, null);

        /** Pindah ke data paling pertama **/
        cursor.moveToFirst();

        /** Mengubah objek pada kursor pertama tadi ke dalam objek mahasiswa **/
        Mahasiswa newMahasiswa = cursorToMahasiswa(cursor);

        /** Close Cursor **/
        cursor.close();

        /** Mengambil data Mahasiswa baru **/
        return newMahasiswa;
    }

    private Mahasiswa cursorToMahasiswa(Cursor cursor){

        /** Membuat objek Mahasiswa baru **/
        Mahasiswa mahasiswa = new Mahasiswa();

        /** debug LOGCAT **/
        Log.v("info", "The getLong "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        /** Set atribut pada objek barang dng data cursor yang diambil dari database **/
        mahasiswa.setId(cursor.getLong(0));
        mahasiswa.setNama_mhs(cursor.getString(1));
        mahasiswa.setNim(cursor.getString(2));
        mahasiswa.setJurusan(cursor.getString(3));

        /** Kembalikan sebagai objek barang **/
        return mahasiswa;
    }

    /** Mengambil semua data barang **/
    public ArrayList<Mahasiswa> getAllMahasiswa(){
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();

        /** Select all SQL query **/
        Cursor cursor = database.query(DataHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        /** Pindah ke data paling pertama **/
        cursor.moveToFirst();

        /** Jika masih ada data, masukkan data mahasiswa ke daftar mahasiswa **/
        while (!cursor.isAfterLast()){
            Mahasiswa mahasiswa = cursorToMahasiswa(cursor);
            daftarMahasiswa.add(mahasiswa);
            cursor.moveToNext();
        }

        /** Close Cursor **/
        cursor.close();
        return daftarMahasiswa;
    }
}
