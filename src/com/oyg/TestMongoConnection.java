package com.oyg;

import com.mongodb.*;
import com.oyg.data.ClientTicketGross;
import com.oyg.rest.GetTicketGrosses;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
    }

    private void insertARecord(DB db) {
        DBCollection coll = db.getCollection("wg");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        coll.insert(doc);
        //mongoClient.close();
    }

//    public static void main(String[] args) {
//      TestMongoConnection testMongoConnection = new TestMongoConnection();
//        testMongoConnection.insertGrossesData(null);
//    }

    public void insertGrossesData(List<TicketGross> grossesFromServer) {
        //$TODO$ replicate insertARecord. insert the grosses from server instead.
        DBCollection coll = db.getCollection("weeklyGrosses");
        grossesFromServer = new GetTicketGrosses().getGrossesFromServer("date");
        for (TicketGross ticketGross : grossesFromServer) {
            BasicDBObject doc = new BasicDBObject("name", ticketGross.getName())
                    .append("gross", ticketGross.getGross())
                    .append("attendance", ticketGross.getAttendance())
                    .append("date",ticketGross.getDate());

            coll.insert(doc);
        }
        //mongoClient.close();
    }

    public void printWeeklyGrosses() {
        // FOR REFERENCE: accessing objects from mongo and printing to console
        /*DBCollection coll = db.getCollection("weeklyGrosses");
        DBCursor cursor = coll.find();
        System.out.println("Weekly Grosses:");
        while (cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
        mongoClient.close();*/

        // creating objects from mongodb objects; to be passed onto front end
        List<DBObject> mongoObjects = new ArrayList<>(); // storing objects queried from mongodb
        List<ClientTicketGross> result = new ArrayList<>(); // creating list of objects to pass to front end
        BasicDBObject fields = new BasicDBObject(); // specifying fields we want to collect
        fields.put("name", 1);
        fields.put("gross", 1);
        fields.put("end date", 1);

        DBCollection coll = db.getCollection("weeklyGrosses");
        DBCursor cursor = coll.find(null,fields);
        // going through weeklyGrosses collection and storing objects into arraylist
        while (cursor.hasNext()) {
            mongoObjects.add(cursor.next());
        }

        // going through arraylist of mongoObjects and creating objects to pass to front end
        for (int i=0; i<mongoObjects.size(); i++)
        {
            ClientTicketGross clientObject = new ClientTicketGross((String)(mongoObjects.get(i).get("name")),
                    (long)(mongoObjects.get(i).get("gross")), (Date) mongoObjects.get(i).get("end date"));
            result.add(clientObject);
        }

        // testing: printing out arraylist result of objects to be passed to front end
        System.out.println("HELLO THESE ARE NOW CLIENT OBJECTS THAT WE WILL PASS ONTO FRONT END!!!");
        for (int i=0; i<result.size(); i++)
        {
            System.out.println("Name: " + result.get(i).getName());
            System.out.println("Gross: " + result.get(i).getGross());
            System.out.println("Date: " + result.get(i).getDate());
            System.out.println("Count: " + i );
        }
        mongoClient.close();
    }
}
