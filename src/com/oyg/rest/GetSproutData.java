package com.oyg.rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.oyg.SproutDailySummary;
import java.util.ArrayList;
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

                SproutDailySummary day = new SproutDailySummary(tokens[0], (tokens[1]), tokens[2], tokens[3], tokens[5], tokens[9], tokens[10], tokens[4], tokens[11], tokens[27], tokens[28], tokens[15], tokens[16], tokens[18]);
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
