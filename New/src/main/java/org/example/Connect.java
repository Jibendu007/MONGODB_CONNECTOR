package org.example;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connect {

    public static void main(String[] args){

        MongoClient mongoClient = new MongoClient("localhost",27017);
        System.out.println("Created Mongo Connection successfully");

        MongoDatabase db = mongoClient.getDatabase("jibendu");
        System.out.println("Get database is successful");

        System.out.println("Below is the list of database available:");
        MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
        while(dbsCursor.hasNext())
        {
            System.out.println(dbsCursor.next());
        }
        MongoCollection<Document> collection= db.getCollection("channels");
        Document doc =new Document("work","DEVELOPER");
        collection.insertOne(doc);
        System.out.println("########### Insert is completed  ###############");


        MongoCursor<String> dbsCursorD = mongoClient.listDatabaseNames().iterator();
        while(dbsCursorD.hasNext())
        {
            System.out.println(dbsCursorD.next());
        }

    }
}
