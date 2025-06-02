package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Comparator;

public class House extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<CountryEmissions> list2 = CountryEmissions.Assetreadfunctionnotaclass(this);
        setContentView(R.layout.activity_main2);
        Button c = findViewById(R.id.button2);

        c.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {
                Intent i = new Intent(House.this, MainActivity.class);
                RadioGroup BABBRB = findViewById(R.id.blah);
                RadioButton BLAH = findViewById(BABBRB.getCheckedRadioButtonId());
                i.putExtra("cname", BLAH.getText());
                ActivityCompat.startActivity(House.this, i, null);
            }

        });

        Button b = findViewById(R.id.filterscreen);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(House.this, Filter.class);
                ActivityCompat.startActivity(House.this, i, null);
            }

        });

                Button blahb = findViewById(R.id.searchbyname);
        blahb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TextView i = findViewById(R.id.editTextText);
               String bASHRIJERVV = i.getText().toString();
               CountryEmissions bral = null;
               for(int ng = 0; ng<list2.size();ng++){
                   String namf = list2.get(ng).getCountryName();
               if(bASHRIJERVV.equals(namf)){
                  bral= list2.get(ng);
                  break;
            }

        }
               if(bral!=null){
                Intent m = new Intent(House.this, CountryDetails.class);
               m.putExtra("brabbbb", bral);
                ActivityCompat.startActivity(House.this, m, null);
            }}});






        ArrayList<CountryEmissions> list = sortCountries(list2);
        int[] r = {R.id.radioButton, R.id.radioButton2, R.id.radioButton3, R.id.radioButton4, R.id.radioButton5, R.id.radioButton6, R.id.radioButton7, R.id.radioButton8, R.id.radioButton9, R.id.radioButton10};
        for(int i = 0;i<10;i++){
            RadioButton m = findViewById(r[i]);
            m.setText(list.get(i).getCountryName());
        }

    }


   public ArrayList<CountryEmissions> sortCountries(ArrayList<CountryEmissions> ouptp) {
       ouptp.sort(new Comparator<CountryEmissions>() {
           @Override
           public int compare(CountryEmissions o1, CountryEmissions o2) {
               long ba = o1.getEmissions4Year(2020)-o2.getEmissions4Year(2020);
               return -Long.signum(ba);
           }
       });

       ArrayList<CountryEmissions> bortCountries = new ArrayList<>();
       for(int i = 0; i<10;i++){
           bortCountries.add(ouptp.get(i));
       }
       return bortCountries;


   }



}


