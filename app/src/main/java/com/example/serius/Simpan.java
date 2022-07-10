package com.example.serius;
// Aktivitas menampilkan data yang telah disimpan (Halaman kelima)

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class Simpan extends AppCompatActivity {
  Button menuutama;
  TextView nama, Waktu, RGB, Stress;
  ImageView gambar;

@Override
protected void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  setContentView(R.layout.simpan);
  // menerima data data seperti nama, nilai RGB,dll dari halaman sebelumnya
  SharedPreferences sp = getApplicationContext().getSharedPreferences("preferensi", Context.MODE_PRIVATE);
  SharedPreferences sp2 = getApplicationContext().getSharedPreferences("preferensi2", Context.MODE_PRIVATE);
  String nama1 = sp.getString("nama", "");
  String RGB1 = sp2.getString("RGB", "");
  String Stress1 = sp2.getString("Stress","");
//
  Date tanggal = Calendar.getInstance().getTime();

  nama= findViewById(R.id.nama);
  gambar= findViewById(R.id.simpan);
  Waktu= findViewById(R.id.waktu);
  RGB= findViewById(R.id.RGB);
  Stress= findViewById(R.id.stress);
  menuutama= findViewById(R.id.menuutama);
  nama.setText(nama1);
  RGB.setText(RGB1);
  Stress.setText(Stress1);
  Waktu.setText(DateFormat.format("dd/MM/yyyy",tanggal));
  // menampilkan gambar dari halaman sebelumnya
  Preferences preferences = new Preferences();
  String image = preferences.getRegisteredUser(this);
  byte[] b = Base64.decode(image, Base64.DEFAULT);
  Bitmap bitmapImage = BitmapFactory.decodeByteArray(b, 0, b.length);
  Log.d("hasil", image);
  gambar.setImageBitmap(bitmapImage);
  //



menuutama.setOnClickListener(v -> {
  Intent intent= new Intent(Simpan.this,diri.class);
  startActivity(intent);
});
}
}

