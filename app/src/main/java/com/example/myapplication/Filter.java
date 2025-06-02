package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Filter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Button b = findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Filter.this, House.class);
                ActivityCompat.startActivity(Filter.this, i, null);


            }

        });
        TextView view = findViewById(R.id.textView29);
        ArrayList<CountryEmissions> list2 = CountryEmissions.Assetreadfunctionnotaclass(this);
        Button blahb = findViewById(R.id.button4);
        blahb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView i = findViewById(R.id.editTextNumber);
                String bASHRIJERVV = i.getText().toString();
                int z = Integer.parseInt(bASHRIJERVV);
                CountryEmissions bral = null;
                Long j = 0l;
                CountryEmissions b = null;
                if (z < 1750 || z > 2020) {
                    String formtext = String.format("no");
                    view.setText(formtext);
                    return;

                }
                for (int ng = 0; ng < list2.size(); ng++) {
                    long x = 0l;
                    x = list2.get(ng).getEmissions4Year(z);

                    if (j < x) {
                        j = x;
                        b = list2.get(ng);
                    }


                }
                String formtext = String.format("Country Name: %s\n" +
                        "Total Co2 Emissions for year: %d",
                         b.getCountryName(), b.getEmissions4Year(z));
                view.setText(formtext);

            }
        });
    }
            }