package com.oyg.worker;

import com.oyg.TestMongoConnection;
import com.oyg.TicketGross;
import com.oyg.TicketMaster;
import com.oyg.rest.GetTicketGrosses;
import com.oyg.rest.GetTicketMasterData;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by msllavore on 11/20/15.
 */
public class TicketGrossesProcessor {

    public TicketGrossesProcessor() {
        //List<TicketGross> grossesFromServer = new GetTicketGrosses().getGrossesFromServer(new Date(System.currentTimeMillis()), null);
        /*List<TicketGross> grossesFromServer = new GetTicketGrosses().getGrossesFromServer(null);
        TestMongoConnection conn = new TestMongoConnection();
        conn.insertGrossesData(grossesFromServer);
        conn.printWeeklyGrosses();*/


    }

    public static void main(String[] args) {
        new TicketGrossesProcessor();

        //List<TicketMaster> newTicketMasterData = new GetTicketMasterData().readTicketMasterFile();

    }
}
