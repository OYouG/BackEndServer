package com.oyg.rest;

import com.oyg.IBDBWeeklyGrosses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GessicaTan-Torres on 1/20/16.
 */

public class GetIBDBData{

    public List<IBDBWeeklyGrosses> returningIBDBData()
    {
        //Input file which needs to be parsed
        String fileToParse = "/Users/msllavore/Desktop/Inf191/ibdb/ibdb_AAIP.csv";

        BufferedReader fileReader = null;

        //Delimiter used in CSV files
        final String DELIMETER = "\",";
        final String DELIMETER_TWO = ",\"";
        final String DELIMETER_THREE = "%,";
        List<IBDBWeeklyGrosses> ibdbData = new ArrayList<>();

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
                String[] firstToken = tokens[0].split(DELIMETER_TWO);
                String[] secondToken = tokens[1].split(DELIMETER_TWO);
                String[] thirdToken = tokens[2].split(DELIMETER_THREE);


                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
                Date date = formatter.parse(firstToken[0]);

                String grossToken = firstToken[1].substring(1);
                int grossPotentialToken = Integer.parseInt(secondToken[0].substring(0,2));
                String attendanceToken = secondToken[1];
                int capacityToken = Integer.parseInt(thirdToken[0]);


                IBDBWeeklyGrosses day = new IBDBWeeklyGrosses(
                        date, grossToken, grossPotentialToken, attendanceToken, capacityToken);
                ibdbData.add(day);
            }
			/*for(IBDBWeeklyGrosses oneDaySummary: ibdbData)
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
        return ibdbData;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GetIBDBData get = new GetIBDBData();
        System.out.println(get.returningIBDBData());
    }
}

/*public class GetIBDBData {
    public static void main(String[] args)
    {
        //Input file which needs to be parsed
        String fileToParse = "ibdb_AAIP.csv";
        BufferedReader fileReader = null;

        //Delimiter used in CSV file
        final String DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));

            //Read the file line by line
            List<IBDBWeekly> ibdbData = new ArrayList<IBDBWeekly>();
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER, -1);

                IBDBWeekly weekData = new IBDBWeekly(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                System.out.println(weekData);
                ibdbData.add(weekData);

            }
            for (IBDBWeekly thing: ibdbData)
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
}*/

