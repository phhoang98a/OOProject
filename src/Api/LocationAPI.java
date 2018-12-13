package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

public class LocationAPI {
	public void addLocation(Driver driver)
    {
        // Sessions are lightweight and disposable connection wrappers.
    	try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
    		try {
    			Scanner input = new Scanner(new FileReader("dataEntity/location.csv"));
    			while (input.hasNextLine()) {
    				String[] content = input.nextLine().split(",");
    				try(Transaction tx = session.beginTransaction())
    				{
    					Map<String, Object> parameters = new HashMap<String, Object>();
    					parameters.put("loc1", content[0]);
    					parameters.put("loc2", content[1]);
    					parameters.put("loc3", content[2]);
    					parameters.put("loc4", content[3]);
    					parameters.put("loc5", content[4]);
						tx.run("CREATE (l:Location {id: {loc1}, name: {loc2}, link: {loc3},describe: {loc4}, date: {loc5}})",parameters);
                        tx.success(); 
    				}	
    			}
    	    	input.close();
    		}catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
    }
}
