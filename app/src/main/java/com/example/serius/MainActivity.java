package com.example.serius;
//  Aktivitas memfoto dann menampilkan gambar (Halaman kedua)

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
        Button open;
        Button analisis;
        String GAMBAR = "gambar";
    public static final int CAMERA_REQUEST = 9999;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            imageView = findViewById(R.id.image_view);
            open = findViewById((R.id.bt_open));
            analisis = findViewById(R.id.an_open);

//  kode untukrequest penggunaan kamera
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{
                                Manifest.permission.CAMERA
                        },
                        100);
            }
            //

            open.setOnClickListener(new View.OnClickListener() {//Fungsi dijalankan setelah button dipencet
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // buka kamera

                    startActivityForResult(intent,CAMERA_REQUEST);


                    }





            });
            analisis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    opensecond();
                }
            });


        }

         public void opensecond(){// fungsi untuk pindah halaman
             Intent intent= new Intent(this, genderdanmetode.class);
             startActivity(intent);
            }






        @Override
        protected void onActivityResult ( int requestCode, int resultCode,  Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST  ) {

            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            Log.d("main activity ",captureImage.toString());
            imageView.setImageBitmap(captureImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            captureImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] compressImage = baos.toByteArray();
            String sEncodedImage = Base64.encodeToString(compressImage, Base64.DEFAULT);
            Preferences preferences = new Preferences();
            preferences.setbitmap(this,sEncodedImage);
            Log.d("main",sEncodedImage);
            }



        }


    }








