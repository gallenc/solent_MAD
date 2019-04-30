package com.example.mapping;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PoiList {

    private static List<POI> poilist = new ArrayList<POI>();

    public static List<POI> getPoilist() {
        return poilist;
    }

    public void loadPoi() {
        poilist.clear();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/POICSV.csv");
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] colomns=line.split(",");
                    POI poi = new POI();
                    poi.setName(colomns[0]);
                    poi.setType(colomns[1]);
                    poi.setDescription(colomns[2]);
                    Double lat = Double.parseDouble(colomns[3]);
                    Double lon = Double.parseDouble(colomns[4]);
                    poi.setLat(lat);
                    poi.setLon(lon);
                    //The Crown,pub,nice pub,-1.4011,50.9319
                    poilist.add(poi);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException("problem loading file", e);
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException ex) {
            }
        }

    }

    private void savepoi() {

        PrintWriter printWriter = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/POICSV.csv");
            printWriter = new PrintWriter(new FileWriter(file));
            for(POI poi :poilist)
            {
                String line = poi.getName()+","+poi.getType()+","+poi.getDescription()+","+poi.getLat()+","+poi.getLon();
                printWriter.println(line);
            }


        } catch (Exception e) {
            throw new RuntimeException("problem loading file", e);
        } finally {
            if (printWriter != null)
                printWriter.close(); // close the file to ensure data is flushed to file
        }
    }



}
