package com.kun.mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        try
        {
        	MongoClient mongo = new MongoClient("localhost",27017);
        	
        	DB db = mongo.getDB("mytest");
        	
        	DBCollection table = db.getCollection("myuser");
        	
        	BasicDBObject d = new BasicDBObject();
        	
        	Handler h = new Handler();
        	
        	h.Insert(table, d, "kun", 26);
        	//h.update(table, d, "kkun", 26);
        	h.delete(table, d);
        	h.find(table, d);
        }
        catch (MongoException e) 
        {
    	e.printStackTrace();
        }
    }
}
