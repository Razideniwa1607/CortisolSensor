package com.example.serius;
// Aktivitas memilih jenis kelamin dan metode kolorimetri(Halaman ketiga)

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class genderdanmetode extends AppCompatActivity{





    Button Lanjut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
         Spinner List = findViewById(R.id.sp);
         Spinner List1= findViewById(R.id.sp2);
        Lanjut= findViewById(R.id.lanjut);
        // inisalisasi array pada spinner
        // spinner : properti android untuk memilih item pada list
        List<String> gender = new ArrayList<>();
        gender.add(0, "Pilih");
        gender.add("Laki-Laki");
        gender.add("Perempuan");
        List<String> metode = new ArrayList<>();
        metode.add(0, "Pilih");
        metode.add("Acid");
        metode.add("Porter");
        metode.add("Prusian");
        metode.add("Blue");
        //




        ArrayAdapter<String> gender1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,gender);
         ArrayAdapter<String> metode1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,metode);
         gender1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metode1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


       List.setAdapter(gender1);
        List1.setAdapter(metode1);




        List.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // fungsi untuk memunculkan pop up setelah item dipilih
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if (parent.getItemAtPosition(i).equals("Pilih")) { List.setSelection(0);
                } else {
                    String item = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), item + "telah dipilih", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"Tidak Ada Item Yang Dipilih", Toast.LENGTH_LONG).show();
            }
        });
        List1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // fungsi untuk memunculkan pop up setelah item dipilih
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if (parent.getItemAtPosition(i).equals("Pilih")) { List1.setSelection(0);
                } else {
                    String item = parent.getItemAtPosition(i).toString();
                Toast.makeText(parent.getContext(),item+"telah dipilih", Toast.LENGTH_SHORT).show();
            }}

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"Tidak Ada Item Yang Dipilih", Toast.LENGTH_SHORT).show();
            }
        });
        Lanjut.setOnClickListener(view -> openthird());
    }
    public void openthird(){// Fungsi untuk pindah halaman
       Intent intent= new Intent(this,Hasil.class);
       startActivity(intent);
    }
}