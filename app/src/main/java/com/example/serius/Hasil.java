package com.example.serius;
// Aktivitas menampilkan hasil nilai RGB dan tingkat stress(Halaman keempat)

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Hasil extends AppCompatActivity {
    ImageView imageView2;
    TextView nilaiwarna;
    Bitmap bitmap;
    TextView Stress;
    Button Simpan;
    SharedPreferences sp;
    String RGBStr, StressStr;


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);
        sp= getSharedPreferences("preferensi2", Context.MODE_PRIVATE);
        imageView2 = findViewById(R.id.image_view2);
        imageView2.setDrawingCacheEnabled(true);
        imageView2.buildDrawingCache(true);
        nilaiwarna = findViewById(R.id.displayvalues);
        Stress = findViewById(R.id.stress);
        Simpan= findViewById(R.id.simpan);
        MainActivity gambar = new MainActivity();
        // menampilkan gambar dari hasil foto di halaman sebelumnya
        Preferences preferences = new Preferences();
        String image = preferences.getRegisteredUser(this);
        byte[] b = Base64.decode(image, Base64.DEFAULT);
        Bitmap bitmapImage = BitmapFactory.decodeByteArray(b, 0, b.length);
        Log.d("hasil", image);
        imageView2.setImageBitmap(bitmapImage);
        //


        imageView2.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // mendapat nilai RGB saat gambar dipencet
                bitmap = imageView2.getDrawingCache();
                int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b1 = Color.blue(pixel);

                nilaiwarna.setText("RGB=" + r + "," + g + "," + b1 + " ");
                if(r>100){
                 Stress.setText("Stress Tinggi");

                }
                else{
                 Stress.setText("Stress Rendah")   ;
                }
            }

            return true;
        });
        //
        Simpan.setOnClickListener(v -> {
            // menyimpan nilai RGB dan tingkat stress ke dalam bentuk string
            RGBStr= nilaiwarna.getText().toString();
            StressStr= Stress.getText().toString();
            SharedPreferences.Editor edit=sp.edit();
            edit.putString("RGB",RGBStr);
            edit.putString("Stress",StressStr);
            edit.apply();
            //
            Intent intent = new Intent(Hasil.this,Simpan.class);
            startActivity(intent);


        });

    }











        }



