package com.example.anandra.gallery;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.Toast;

import java.io.File;



public class MainActivity extends AppCompatActivity {

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            readFiles();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Access Denied",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int status= ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if(status== PackageManager.PERMISSION_GRANTED)
        {
            readFiles();
        }
        else
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},123);
        }

    }


    public void readFiles() {

        String path="/storage/emulated/0/WhatsApp/Media/WhatsApp Video/";
        File f=new File(path);
        String[]files=f.list();
        Gallery gal=(Gallery)findViewById(R.id.gal1);
        gal.setAdapter(new MyAdapter(MainActivity.this,path,files));


    }


}