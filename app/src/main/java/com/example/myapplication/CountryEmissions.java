package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class CountryEmissions implements Serializable {
    private String countryName;
    private String density;
    private String percentageOfWorld;

    private long area;
    private int year;

    private HashMap<Integer, Long> co2Emissions;
    private long population;

    public CountryEmissions(int year, long population, String countryName, String density, String percentageOfWorld, long area){
        this.year = year;
        this.population = population;
        this.countryName = countryName;
        this.density = density;
        this.percentageOfWorld = percentageOfWorld;
        this.area = area;
        co2Emissions = new HashMap<Integer, Long>();
    }
public int getYear(){
        return year;
    }
    public long getPopulation(){
        return population;
    }

    public long getArea(){return area;}

    public String getPercentageOfWorld(){
        return percentageOfWorld;
    }

    public String getDensity(){
        return density;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public void setArea(long area){this.area=area;}
    public void setDensity(String density){
        this.density = density;
    }
    public void setPopulation(long population){
        this.population = population;
    }
    public void setPercentageOfWorld(String percentageOfWorld) {
        this.percentageOfWorld = percentageOfWorld;
    }

    public void setYear(int year){
        this.year = year;
    }
    public long getEmissions4Year(int year){

        return co2Emissions.getOrDefault(year, 0l);
    }

public void setEmissions4Year(int year, long co2emission){
        co2Emissions.put(year, co2emission);
}
public long totalEmissions4Country(){
        long help = 0;
        for(int i = 0;i<271;i++){

            help += co2Emissions.getOrDefault(1750+i, 0l);
        }
        return help;
}

public long averageEmissions4Country(){
        long helpme = 0;
        int hcnemmmm = 0;

    for(int i = 0;i<271;i++){
if(co2Emissions.containsKey(1750+i)){
    hcnemmmm++;
}
        helpme += co2Emissions.getOrDefault(1750+i, 0l);

    }
    helpme/=hcnemmmm;
    helpme/=population;
    return helpme;


}
public int highestEmissions4Country() {
        Long j = 0l;
        int b =0;
    for(int i = 0;i<271;i++){
        long x = 0l;
            x = co2Emissions.getOrDefault(1750+i, 0l);

            if(j<x){
                j = x;
                b = 1750+i;
            }


        }
    return b;
    }





public static ArrayList<CountryEmissions> Assetreadfunctionnotaclass(Context brahg){

        AssetManager assets = brahg.getAssets();
        try {

            InputStream inputStream = assets.open("this file this this one.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            ArrayList<CountryEmissions> counemio = new ArrayList<>();
            CountryEmissions thing = null;
            String yabayabadoo = null;

            Log.println(Log.ASSERT, "534", bufferedReader.readLine());
            int xru = 0;

            while ((line = bufferedReader.readLine()) != null) {
                int b = 0;
                int c = 0;
                int x = 0;

                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) == '"' && x == 0) {
                        b = i;
                        x++;
                    }
                    if (line.charAt(i) == '"' && x > 0) {
                        c = i;
                    }

                }
                String righgfhbbbb = line.substring(0, b);
                String righgfhbbbbb = line.substring(c);
                line = righgfhbbbb + righgfhbbbbb;
                String[] csvArr = line.split(",");


                String countryName = "x";
                if (csvArr.length <= 0) {
                    countryName = "0";
                } else {
                    countryName = csvArr[0];
                }
                String yar = "x";
                if (csvArr.length <= 3) {
                    yar = "0";
                } else {
                    yar = csvArr[3];
                }
                String cogem = "x";
                if (csvArr.length <= 4) {
                    cogem = "0";
                } else {
                    cogem = csvArr[4];
                }
                String pop = "x";
                if (csvArr.length <= 5) {
                    pop = "0";
                } else {
                    pop = csvArr[5];
                }
                String are = "x";
                if (csvArr.length <= 6) {
                    are = "0";
                } else {
                    are = csvArr[6];
                }
                String percentage = "x";
                if (csvArr.length <= 7) {
                    percentage = "0";
                } else {
                    percentage = csvArr[7];
                }


                String density = "x";
                if (csvArr.length <= 8) {
                    density = "0";
                } else {
                    density = csvArr[8];
                }
                int year = Integer.parseInt(yar);
                long co2emissions = 0;
                if (!cogem.equals("")) {
                    co2emissions = Double.valueOf(cogem).longValue();
                }
                long population = 0;
                if (!pop.equals("")) {
                    population = Double.valueOf(pop).longValue();
                }
                long area = 0;
                if (!are.equals("")) {
                    area = Double.valueOf(are).longValue();
                }


                if (yabayabadoo == null || !yabayabadoo.equals(countryName)) {
                    thing = new CountryEmissions(year, population, countryName, density, percentage, area);
                    counemio.add(thing);
                    xru++;

                }
                thing.setEmissions4Year(year, co2emissions);
                thing.setDensity(density);
                thing.setPopulation(population);
                thing.setPercentageOfWorld(percentage);
                yabayabadoo = countryName;


            }
            Log.println(Log.ASSERT, "f534",""+ counemio.size());
          inputStream.close();
            return counemio;


        }
        catch (IOException e) {
            e.printStackTrace();
            Log.println(Log.ASSERT, "f534", "hi hi hihihih");
            return null;
        }
    }}

