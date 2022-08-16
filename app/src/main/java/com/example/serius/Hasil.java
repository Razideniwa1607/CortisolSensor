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

import java.util.Objects;


public class Hasil extends AppCompatActivity {
    ImageView imageView2;
    TextView nilaiwarna;
    Bitmap bitmap;
    TextView Stress ;
    Button Simpan;
    SharedPreferences sp;
    String RGBStr, StressStr;


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences spm = getApplicationContext().getSharedPreferences("gentode", Context.MODE_PRIVATE);
        String spm1 = spm.getString("metode", "");
        String spm2 = spm.getString("gender", "");
        setContentView(R.layout.hasil);
        sp= getSharedPreferences("preferensi2", Context.MODE_PRIVATE);
        imageView2 = findViewById(R.id.image_view2);
        imageView2.setDrawingCacheEnabled(true);
        imageView2.buildDrawingCache(true);
        nilaiwarna = findViewById(R.id.displayvalues);
        Stress = findViewById(R.id.stress);
        Simpan= findViewById(R.id.simpan);


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
                while(spm2.equals("Laki-Laki")) {
                    if (Objects.equals(spm1, "Sulfuric Acid")) {
                        if (b1 >= 172) {
                            Stress.setText("Low distress");
                        } else if (b1 < 172 && b1 >= 161) {
                            Stress.setText("Low distress");
                        } else if (b1 < 161 && b1 >= 128) {
                            Stress.setText("Mild distress");
                        } else if (b1 < 128 && b1 >= 104) {
                            Stress.setText("Moderate distress");
                        }
                        else if (b1 < 104) {
                            Stress.setText("Severe distress");
                        }
                        break;
                    }
                    if (Objects.equals(spm1, "aunp Sliber-Porter")) {
                        if (b1 >= 215) {
                            Stress.setText("Low distress ");
                        } else if ( b1 < 215 && b1 >= 208) {
                            Stress.setText("Mild Distress ");
                        } else if (b1 < 208 && b1 >= 163) {
                            Stress.setText("Moderate distress ");
                        } else if (b1 < 163) {
                            Stress.setText("Severe distress ");
                        }
                        break;
                    }
                    if (Objects.equals(spm1, "Prussian Blue")) {
                        if (b1 >= 187) {
                            Stress.setText("Low distress");
                        } else if (b1 < 187 && b1 > 171) {
                            Stress.setText("Low distress");
                        } else if (b1 < 171 && b1 >= 163) {
                            Stress.setText("Mild distress");
                        } else if (b1 < 163 && b1 >= 149) {
                            Stress.setText("Moderate distress");
                        }
                        else if (b1 < 149) {
                            Stress.setText("Severe distress");
                        }
                        break;
                    }
                    if (Objects.equals(spm1, "Blue Tetrazelium")) {
                        if (r >= 200) {
                            Stress.setText("Low distress ");
                        } else if (r < 200 && r >= 188) {
                            Stress.setText("Mild distress ");
                        } else if (r < 188 && r >=153) {
                            Stress.setText("Moderate distress ");
                        } else if (r < 153 ) {
                            Stress.setText("Severe distress ");
                        }

                        break;
                    }
                }
                while(spm2.equals("Perempuan")) {
                    if (Objects.equals(spm1, "Sulfuric Acid")) {
                        if (b1 >= 172) {
                            Stress.setText("Low distress");
                        } else if (b1 < 172 && b1 >= 161) {
                            Stress.setText("Low distress");
                        } else if (b1 < 161 && b1 >= 128) {
                            Stress.setText("Mild distress");
                        } else if (b1 < 128 && b1 >= 104) {
                            Stress.setText("Moderate distress");
                        }
                        else if (b1 < 104) {
                            Stress.setText("Severe distress");
                        }
                        break;
                    }
                    if (Objects.equals(spm1, "aunp Sliber-Porter")) {
                        if (b1 >= 215) {
                            Stress.setText("Low distress ");
                        } else if ( b1 < 215 && b1 >= 208) {
                            Stress.setText("Mild Distress ");
                        } else if (b1 < 208 && b1 >= 163) {
                            Stress.setText("Moderate distress ");
                        } else if (b1 < 163) {
                            Stress.setText("Severe distress ");
                        }
                        break;
                    }
                    if (Objects.equals(spm1, "Prussian Blue")) {
                        if (b1 >= 187) {
                            Stress.setText("Low distress");
                        } else if (b1 < 187 && b1 > 171) {
                            Stress.setText("Low distress");
                        } else if (b1 < 171 && b1 >= 163) {
                            Stress.setText("Mild distress");
                        } else if (b1 < 163 && b1 >= 149) {
                            Stress.setText("Moderate distress");
                        }
                        else if (b1 < 149) {
                            Stress.setText("Severe distress");
                        }
                        break;
                    }
                    if (Objects.equals(spm1, "Blue Tetrazelium")) {
                        if (r >= 200) {
                            Stress.setText("Low distress ");
                        } else if (r < 200 && r >= 188) {
                            Stress.setText("Mild distress ");
                        } else if (r < 188 && r >=153) {
                            Stress.setText("Moderate distress ");
                        } else if (r < 153 ) {
                            Stress.setText("Severe distress ");
                        }

                        break;
                    }
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

           // SharedPreferences.Editor editor = ();  ;
           // editor.clear().commit();
            Intent intent = new Intent(Hasil.this,Simpan.class);
            startActivity(intent);




        });

    }











        }



