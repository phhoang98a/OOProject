package Main;

import java.io.IOException;
import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

import Entity.*;
import FileHandle.HandleCSV;
import Relation.*;
import Api.*;
import FileHandle.*;


public class Main {
    
	
	
	public static void main(String args[]) throws IOException{
    	
		boolean CREAT = false;
		if (CREAT == true) {
			//Tao random thuc the
	    	int nEntity = 10000;	
	    	int nRelation = 20000;
	    	System.out.println(nEntity);
	    	
	    	CreateRandomEntity entity = new CreateRandomEntity();
	    	entity.createEntity(nEntity);
	    	System.out.println("creat done entity");
	    	
	    	//Tao random quan he
	    	HandleCSV file = new HandleCSV();
	    	file.GenerateCSV("dataRelation/relation.csv");
	    	
	    	RandomRelationship rand = new RandomRelationship();
	        for(int i = 0; i<nRelation; i++){
	            rand.random();
	            file.AddDataCSV("dataRelation/relation.csv",rand.toString());
	        }
	        System.out.println("creat done relation");
	        
		}
		//API
        Neo4jAPI example = new Neo4jAPI();
        example.connect("bolt://localhost:7687", "neo4j", "19981967");
        //example.addData();
        example.getQueryResult();
        example.close();

   
    	System.out.println("done");
    }
}
