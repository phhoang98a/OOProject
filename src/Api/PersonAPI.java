package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

public class PersonAPI {
	
	
	public void addPerson(Driver driver)
    {
        // Sessions are lightweight and disposable connection wrappers.
    	try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
    		try {
    			Scanner input = new Scanner(new FileReader("dataEntity/person.csv"));
    			while (input.hasNextLine()) {
    				String[] content = input.nextLine().split(",");
    				try(Transaction tx = session.beginTransaction())
    				{
    					Map<String, Object> parameters = new HashMap<String, Object>();
    					parameters.put("per1", content[0]);
    					parameters.put("per2", content[1]);
    					parameters.put("per3", content[2]);
    					parameters.put("per4", content[3]);
    					parameters.put("per5", content[4]);
    					parameters.put("per6", content[5]);
						tx.run("CREATE (p:Person {id: {per1}, name: {per2}, link: {per3},describe: {per4}, date: {per5}, job: {per6}})",parameters);
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
