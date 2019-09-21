package com.example.user.myapplication;

import android.app.ListActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class viewdata extends ListActivity {

    /** Inisialisasi Kontroller **/
    private DataController dataController;

    /** Inisialisasi Arraylist **/
    private ArrayList<Mahasiswa> values;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdata);

        dataController = new DataController(this);

        /** Buka Controller **/
        dataController.open();

        /** Mengambil semua data mahasiswa **/
        values = dataController.getAllMahasiswa();

        /** Memasukkan data mahasiswa ke array adapter **/
        ArrayAdapter<Mahasiswa> adapter = new ArrayAdapter<Mahasiswa>(this,
                android.R.layout.simple_list_item_1, values);

        /** Set Adapter pada list **/
        setListAdapter(adapter);
    }
}
