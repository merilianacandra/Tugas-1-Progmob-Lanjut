package com.example.user.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateData extends Activity implements View.OnClickListener {

    /** Inisialisasi element-element pada layout **/
    private Button buttonSubmit;
    private EditText txtNama;
    private EditText txtNim;
    private EditText txtJrsn;

    /** Inisialisasi DataKontroller **/
    private DataController dataController;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_data);

        buttonSubmit = (Button) findViewById(R.id.buttom_submit);
        buttonSubmit.setOnClickListener(this);
        txtNama = (EditText) findViewById(R.id.nama_mahasiswa);
        txtNim = (EditText) findViewById(R.id.nim_mhs);
        txtJrsn = (EditText) findViewById(R.id.jrsn_mhs);

        /**Instantiasi Kelas DataController **/
        dataController = new DataController(this);

        /** Membuat sambungan baru ke database **/
        dataController.open();
    }

    /** Tombol Submit Diklik **/
    @Override
    public void onClick(View a){

        /** Iinisialisasi data mahasiswa **/
        String nama = null;
        String nim = null;
        String jrsn = null;
        @SuppressWarnings("unused")

        /** Inisialisasi mahasiswa baru (masih kosong) **/
        Mahasiswa mahasiswa = null;
        if(txtNama.getText()!=null && txtNim.getText()!=null && txtJrsn.getText()!=null){
            nama = txtNama.getText().toString();
            nim = txtNim.getText().toString();
            jrsn = txtJrsn.getText().toString();
        }

        switch (a.getId()){
            case R.id.buttom_submit:
                /** Insert Data Mahasiswa Baru **/
                mahasiswa = dataController.createMahasiswa(nama, nim, jrsn);

                /** Konfirmasi kesuksesan **/
                Toast.makeText(this, "Mahasiswa\n" +
                    "nama" + mahasiswa.getNama_mhs() +
                    "nim" + mahasiswa.getNim() +
                    "jrsn" + mahasiswa.getNim(), Toast.LENGTH_LONG).show();
                break;
        }

    }

}
