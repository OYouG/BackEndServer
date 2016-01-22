package com.oyg.rest;

import com.oyg.NuviDailySummary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
 * Created by Madeleine K. Surjani on 1/20/2016
 */

public class GetNuviTrendsHashtags {

    public List<NuviDailySummary> returningNuviTrendHashtag()
    {
        // TODO Auto-generated method stub

        //Input file which needs to be parsed
        String fileToParse = "nuvi-export-trends_Hashtags.csv";
		/*  Reads text from a character-input stream,
		 *  buffering characters so as to provide for the efficient reading
		 *  of characters, arrays, and lines.
		 *  The buffer size may be specified, or the default size may be used.
		 *  The default is large enough for most purposes.
		 */
        BufferedReader fileReader = null;

        List<NuviDailySummary> nuviTrendsHashtagData = new ArrayList<NuviDailySummary>();


        //Delimeter used in CSV files

        final String DELIMETER = "\",\"";

        final String DELIMETER_TOKEN_FIVE = "\",";
        try
        {
            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));

            //Read the file line by line
            fileReader.readLine();

            while( (line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line

                String[] tokens = line.split(DELIMETER);
                String[] tokensFive = tokens[5].split(DELIMETER_TOKEN_FIVE);


                String sourceIDToken = tokens[0].substring(1);
                String fromDateToken = tokens[4].substring(0,20);
                String toDateToken = tokensFive[0];
                int totalToken = Integer.parseInt(tokensFive[1]);

                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date fromDate = formatter.parse(fromDateToken);
                Date toDate = formatter.parse(toDateToken);

                NuviDailySummary day = new NuviDailySummary(sourceIDToken, tokens[1], tokens[2],
                        tokens[3], fromDate, toDate, totalToken );
                nuviTrendsHashtagData.add(day);
            }
			/*for(NuviDailySummary oneDaySummary: nuviTrendsHashtagData)
			{
				System.out.println(oneDaySummary);
			}*/
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fileReader.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return nuviTrendsHashtagData;
    }
}

