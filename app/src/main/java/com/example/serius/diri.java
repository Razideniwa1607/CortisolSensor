package com.example.serius;
// Aktivitas pengisian nama dan email(halaman pertama)

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class diri extends AppCompatActivity {
Button Lanjut;
EditText nama, email;
SharedPreferences sp;
String namaStr, emailStr;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.diri);
    Lanjut= findViewById(R.id.lanjut1);
    nama= findViewById(R.id.nama);
    email=findViewById(R.id.email);
    sp= getSharedPreferences("preferensi",Context.MODE_PRIVATE);
    Lanjut.setOnClickListener(v -> {
        //menyimpan data nama dan email dalam bentuk string
        namaStr= nama.getText().toString();
        emailStr= email.getText().toString();
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("nama",namaStr);
        edit.putString("email",emailStr);
        edit.apply();
        if (namaStr.equals("") || namaStr.equals("Nama")) {
            Toast.makeText(getBaseContext(), " Nama harap untuk diisi", Toast.LENGTH_SHORT).show();
        }
        else if (emailStr.equals("")|| emailStr.equals("Email")){
            Toast.makeText(getBaseContext(), " Email harap untuk diisi", Toast.LENGTH_SHORT).show();

        }


        else {



            Intent intent = new Intent(diri.this, MainActivity.class);
            startActivity(intent);
        }


    });


}

}
