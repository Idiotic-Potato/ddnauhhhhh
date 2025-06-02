package com.example.myapplication;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent c = getIntent();
        String r = c.getStringExtra("cname");
        Log.println(Log.ASSERT, "f534","" + r);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        ArrayList<CountryEmissions> output= CountryEmissions.Assetreadfunctionnotaclass(this);
        if(r==null) {
            Intent i = new Intent(MainActivity.this, House.class);
            ActivityCompat.startActivity(MainActivity.this, i, null);
        }else{
            ArrayList<CountryEmissions> outpu= (output);
            TextView view = findViewById(R.id.stathold);
            CountryEmissions ourCountry = null;
            Iterator<CountryEmissions> iterat = outpu.iterator();
            while(iterat.hasNext()){
                ourCountry=iterat.next();
                if(ourCountry.getCountryName().equals(r)){
                break;
            }}
            String formtext = String.format("Total Co2: %d\nAverage Emissions: %d\nYear with Highest Emissions: %d", ourCountry.totalEmissions4Country(), ourCountry.averageEmissions4Country(), ourCountry.highestEmissions4Country());
            Log.println(Log.ASSERT, "f534", formtext);
            view.setText(formtext);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, House.class);
                    ActivityCompat.startActivity(MainActivity.this, i, null);


                }

            });
        }



        }


}







//Afghanistan,AF,93,1750,0,41128771,652230,0.40%,63/km≤