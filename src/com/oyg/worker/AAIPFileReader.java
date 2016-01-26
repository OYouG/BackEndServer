package com.oyg.worker;

import com.oyg.*;
import com.oyg.rest.GetIBDBData;
import com.oyg.rest.GetNuviTrends;
import com.oyg.rest.GetSproutData;
import com.oyg.rest.GetTicketMasterData;

import java.util.List;
import java.util.Scanner;

/**
 * Created by msllavore on 1/25/16.
 */
public class AAIPFileReader {
    public AAIPFileReader(String filePath) {
        System.out.println("What kind of file would you like to process? (enter number)\n" +
                "1. TicketMaster Event Sales \n" +
                "2. TicketMaster Event Web Traffic \n" +
                "3. TicketMaster Price/Seating Breakdowns \n" +
                "4. Nuvi Trending Terms \n" +
                "5. Sprout Analytics \n" +
                "6. IBDB Weekly Grosses \n");

        Scanner user_input = new Scanner( System.in );
        String fileType = user_input.next( );


        switch(fileType)
        {
            case "1":
                if (filePath.toLowerCase().endsWith(".xls") || filePath.toLowerCase().endsWith(".xlsx"))
                {
                    List<TicketMasterEvents> events = new GetTicketMasterData().readTicketMasterEventsSummary(filePath);
                    System.out.println("Total data collected: " + events.size());
                }
                else
                { System.out.println("TicketMaster file must be an .xls/xlsx file"); }
                break;
            case "2":
                if (filePath.toLowerCase().endsWith(".xls") || filePath.toLowerCase().endsWith(".xlsx"))
                {
                    List<TicketMasterTraffic> edpTraffic = new GetTicketMasterData().readTicketMasterWebTraffic(filePath);
                    System.out.println("Total data collected: " + edpTraffic.size());
                }
                else
                { System.out.println("TicketMaster file must be an .xls/xlsx file"); }
                break;
            case "3":
                if (filePath.toLowerCase().endsWith(".xls") || filePath.toLowerCase().endsWith(".xlsx"))
                {
                    List<TicketMasterPriceLevels> priceLevels = new GetTicketMasterData().readTicketMasterPriceLevels(filePath);
                    System.out.println("Total data collected: " + priceLevels.size());
                }
                else
                { System.out.println("TicketMaster file must be an .xls/xlsx file"); }
                break;
            case "4":
                if (filePath.toLowerCase().endsWith(".csv"))
                {
                    List<NuviDailySummary> nuviKeywords = new GetNuviTrends().returningNuviTrends(filePath);
                    System.out.println("Total data collected: " + nuviKeywords.size());
                }
                else
                { System.out.println("Nuvi file must be a .csv file"); }
                break;
            case "5":
                if (filePath.toLowerCase().endsWith(".csv"))
                {
                    List<SproutDailySummary> sproutData = new GetSproutData().readSproutData(filePath);
                    System.out.println("Total data collected: " + sproutData.size());
                }
                else
                { System.out.println("SocialSprout file must be a .csv file"); }
                break;
            case "6":
                if (filePath.toLowerCase().endsWith(".csv"))
                {
                    List<IBDBWeeklyGrosses> ibdbAAIP = new GetIBDBData().returningIBDBData(filePath);
                    System.out.println("Total data collected: " + ibdbAAIP.size());
                }
                else
                { System.out.println("IBDB file must be a .csv file"); }
                break;
        }
    }

    public static void main(String[] args) {
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan20.xls");
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/ticketMaster/tmOne/edp/traffic-trends2.xlsx");
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/ticketMaster/tmOne/plevels/event-audit2.xlsx"));
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/nuvi/nuvi-export-trends_Keywords.csv");
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/nuvi/nuvi-export-trends_Hashtags.csv");
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/nuvi/nuvi-export-trends_PositiveTerms.csv");
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/nuvi/nuvi-export-trends_NegativeTerms.csv");
        new AAIPFileReader("/Users/msllavore/Desktop/Inf191/sprout/groupCSV-01-05-2016---01-19-2016.csv");
        //new AAIPFileReader("/Users/msllavore/Desktop/Inf191/ibdb/ibdb_AAIP.csv");



    }

}
