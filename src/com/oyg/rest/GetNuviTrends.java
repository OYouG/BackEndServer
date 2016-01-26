package com.oyg.rest;

import com.oyg.NuviDailySummary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
 * Created by Madeleine K. Surjani on 1/20/2016
 */

public class GetNuviTrends {

    public List<NuviDailySummary> returningNuviTrends(String filePath)
    {
        BufferedReader fileReader;

        List<NuviDailySummary> nuviTrendsData = new ArrayList<>();

        //Delimeter used in CSV files
        final String DELIMETER = "\",\"";
        final String DELIMETER_TOKEN_FIVE = "\",";

        try
        {
            String line;

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(filePath));
            //Read the file line by line
            fileReader.readLine();

            //while( (line = fileReader.readLine()) != null)
            for (int i=0; i<10; i++)
            {
                line = fileReader.readLine();
                if (line != null) {
                    //Get all tokens available in line
                    String[] tokens = line.split(DELIMETER);
                    String[] tokensFive = tokens[5].split(DELIMETER_TOKEN_FIVE);

                    String fromDateToken = tokens[4].substring(0, 20);
                    String toDateToken = tokensFive[0];
                    int totalToken = Integer.parseInt(tokensFive[1]);

                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date fromDate = formatter.parse(fromDateToken);
                    Date toDate = formatter.parse(toDateToken);

                    NuviDailySummary day = new NuviDailySummary(tokens[2], tokens[3], fromDate, toDate, totalToken);
                    nuviTrendsData.add(day);
                }
                else
                {
                    break;
                }
            }
            fileReader.close();
            nuviTrendsData.forEach(System.out::println);
        }
        catch(IOException | ParseException e) {  e.printStackTrace(); }
        return nuviTrendsData;
    }
}

