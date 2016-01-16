package com.oyg.rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.oyg.SproutDailySummary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by msllavore on 1/15/16.
 */
public class GetSproutData {
    public static void main(String[] args)
    {
        //Input file which needs to be parsed
        String fileToParse = "groupCSV-12-28-2015---01-11-2016.csv";
        BufferedReader fileReader = null;

        //Delimiter used in CSV file
        final String DELIMITER = ",";
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));

            //Read the file line by line
            List<SproutDailySummary> sproutData = new ArrayList<SproutDailySummary>();
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formatter.parse(tokens[0]);
                //System.out.println(date);
                //System.out.println(formatter.format(date));

                SproutDailySummary day = new SproutDailySummary(date, Integer.valueOf(tokens[1]),
                        Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), Integer.valueOf(tokens[5]),
                        Integer.valueOf(tokens[9]), Integer.valueOf(tokens[10]), Integer.valueOf(tokens[4]),
                        Integer.valueOf(tokens[11]), Integer.valueOf(tokens[27]), Integer.valueOf(tokens[28]),
                        Integer.valueOf(tokens[15]), Integer.valueOf(tokens[16]), Integer.valueOf(tokens[18]));
                sproutData.add(day);
            }
            for (SproutDailySummary thing: sproutData)
            {
                System.out.println(thing);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
