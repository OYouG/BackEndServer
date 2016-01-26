package com.oyg.rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.oyg.SproutDailySummary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by msllavore on 1/15/16.
 */
public class GetSproutData {
    public List<SproutDailySummary> readSproutData(String filePath) {
        BufferedReader fileReader;
        List<SproutDailySummary> sproutData = new ArrayList<>();

        final String DELIMITER = ","; //Delimiter used in CSV file

        try
        {
            String line;

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(filePath));

            //Read the file line by line
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);

                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = formatter.parse(tokens[0]);

                SproutDailySummary day = new SproutDailySummary(date, Integer.valueOf(tokens[1]),
                        Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), Integer.valueOf(tokens[5]),
                        Integer.valueOf(tokens[9]), Integer.valueOf(tokens[10]), Integer.valueOf(tokens[4]),
                        Integer.valueOf(tokens[11]), Integer.valueOf(tokens[27]), Integer.valueOf(tokens[28]),
                        Integer.valueOf(tokens[15]), Integer.valueOf(tokens[16]), Integer.valueOf(tokens[18]));
                sproutData.add(day);
            }
            sproutData.forEach(System.out::println);
            fileReader.close();
        }
        catch (IOException | ParseException e) { e.printStackTrace(); }
        return sproutData;
    }
}
