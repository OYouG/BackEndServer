package com.oyg;

import com.mongodb.*;
import com.oyg.rest.GetTicketGrosses;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by msllavore on 11/20/15.
 */
public class TestMongoConnection
{

    private final DB db;
    private final MongoClient mongoClient;

    public TestMongoConnection() {

//        MongoClient mongoClient = new MongoClient();
// or
//        MongoClient mongoClient = new MongoClient( "localhost" );
// or
        mongoClient = new MongoClient( "localhost" , 27017 );
// or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
//        MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
//                new ServerAddress("localhost", 27018),
//                new ServerAddress("localhost", 27019)));

        db = mongoClient.getDB( "mydb" );
        //insertARecord(db);
    }

    private void insertARecord(DB db) {
        DBCollection coll = db.getCollection("wg");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        coll.insert(doc);
    }

//    public static void main(String[] args) {
//      TestMongoConnection testMongoConnection = new TestMongoConnection();
//        testMongoConnection.insertGrossesData(null);
//    }

    public void insertGrossesData(List<TicketGross> grossesFromServer) {
        //$TODO$ replicate insertARecord. insert the grosses from server instead.
        DBCollection coll = db.getCollection("weeklyGrosses");
        grossesFromServer = new GetTicketGrosses().getGrossesFromServer("start", "end");
        for (TicketGross ticketGross : grossesFromServer) {
            BasicDBObject doc = new BasicDBObject("name", ticketGross.getName())
                    .append("gross", ticketGross.getGross())
                    .append("attendance", ticketGross.getAttendance())
                    .append("start date",ticketGross.getStartDate())
                    .append("end date", ticketGross.getEndDate());

            coll.insert(doc);

        }
        mongoClient.close();
    }
}
