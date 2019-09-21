package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button tombol_insert;
    private Button tombol_view;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tombol_insert = (Button) findViewById(R.id.button_tambah);
        tombol_insert.setOnClickListener(this);

        tombol_view = (Button) findViewById(R.id.button_view);
        tombol_view.setOnClickListener(this);
    }

    @Override
    public void onClick(View a){
        switch (a.getId()){
            case R.id.button_tambah :
                Intent i = new Intent(this, CreateData.class);
                startActivity(i);
                break;
            case R.id.button_view :
                Intent j = new Intent(this, viewdata.class);
                startActivity(j);
                break;
        }
    }
}