package com.kun.mongo;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class Handler {
	
	
	
	Handler()
	{
		
	}

	public void Insert(DBCollection table,BasicDBObject d,String name, int age)
	{
		d.put("name",name);
		d.put("age", age);
		d.put("time",new Date());
		table.insert(d);
	}
	
	public void update(DBCollection table,BasicDBObject d,String name, int age)
	{
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", name);
					
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);

		table.update(d, updateObj);
	}
	
	public void find(DBCollection table,BasicDBObject d)
	{
		DBCursor cursor = table.find(d);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public void delete(DBCollection table,BasicDBObject d)
	{
		table.remove(d);
	}
	
}
