package com.example.serius;
// Aktivitas memilih jenis kelamin dan metode kolorimetri(Halaman ketiga)

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sp3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
         Spinner List = findViewById(R.id.sp);
         Spinner List1= findViewById(R.id.sp2);
        Lanjut= findViewById(R.id.lanjut);
        sp3= getSharedPreferences("gentode", Context.MODE_PRIVATE);
        // inisalisasi array pada spinner
        // spinner : properti android untuk memilih item pada list
        List<String> gender = new ArrayList<>();
        gender.add(0, "Gender");
        gender.add("Laki-Laki");
        gender.add("Perempuan");
        List<String> metode = new ArrayList<>();
        metode.add(0, "Metode");
        metode.add("Sulfuric Acid");
        metode.add("aunp Sliber-Porter");
        metode.add("Prussian Blue");
        metode.add("Blue Tetrazelium");
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
                if (parent.getItemAtPosition(i).equals("Gender"))
                { List.setSelection(0);
                    String item1 = parent.getItemAtPosition(i).toString();

                    SharedPreferences.Editor edit=sp3.edit();
                    edit.putString("gender",item1);
                    edit.apply();
                } else {
                    String item1 = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), "Gender "+item1 + " telah dipilih", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor edit=sp3.edit();
                    edit.putString("gender",item1);
                    edit.apply();

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
                if (parent.getItemAtPosition(i).equals("Metode"))
                { List1.setSelection(0);
                    String item2 = parent.getItemAtPosition(i).toString();
                    SharedPreferences.Editor edit=sp3.edit();
                    edit.putString("metode",item2);
                    edit.apply();

                } else {
                    String item2 = parent.getItemAtPosition(i).toString();
                Toast.makeText(parent.getContext(),"Metode "+ item2+" telah dipilih" , Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor edit=sp3.edit();
                    edit.putString("metode",item2);
                    edit.apply();




            }}


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"Tidak Ada Item Yang Dipilih", Toast.LENGTH_SHORT).show();
            }
        });
        Lanjut.setOnClickListener( v -> {

            SharedPreferences spm= getApplicationContext().getSharedPreferences("gentode", Context.MODE_PRIVATE);
        String spm2 = spm.getString("metode", "");
        String spm1 = spm.getString("gender", "");



            if(spm1.equals("Gender")){
                Toast.makeText(getBaseContext(), " Gender harap untuk diisi", Toast.LENGTH_SHORT).show();

            }
            else if (spm2.equals("Metode")){
                    Toast.makeText(getBaseContext(), " Metode harap untuk diisi", Toast.LENGTH_SHORT).show();
                }




         else{
            Intent intent= new Intent(this,Hasil.class);
            startActivity(intent);

        }

        });
    }

}

