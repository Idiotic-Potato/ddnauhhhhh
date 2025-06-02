package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class CountryDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        Button b = findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CountryDetails.this, House.class);
                ActivityCompat.startActivity(CountryDetails.this, i, null);


            }

        });
        TextView view = findViewById(R.id.textView11);
        CountryEmissions brJ = (CountryEmissions)getIntent().getSerializableExtra("brabbbb");
        String formtext = String.format("Country Name: %s\n"+
                                        "Country Population: %d\n"+
                                        "Country Area: %s\n"+
                                        "Country Density: %s\n"+
                                        "Percent of World Landmass: %s\n"+
                                        "Total Emissions: %d\n"+
                                        "Average Emissions per Capita: %d\n"+
                                        "Year with highest emissions: %d\n",
                brJ.getCountryName(),
                brJ.getPopulation(),
                brJ.getArea(),
                brJ.getDensity(),
                brJ.getPercentageOfWorld(),
                brJ.totalEmissions4Country(),
                brJ.averageEmissions4Country(),
                brJ.highestEmissions4Country());
        view.setText(formtext);


        }

    }
