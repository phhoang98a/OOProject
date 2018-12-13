package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

public class OrganizationAPI {
	public void addOrganization(Driver driver)
    {
        // Sessions are lightweight and disposable connection wrappers.
    	try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
    		try {
    			Scanner input = new Scanner(new FileReader("dataEntity/organization.csv"));
    			while (input.hasNextLine()) {
    				String[] content = input.nextLine().split(",");
    				try(Transaction tx = session.beginTransaction())
    				{
    					Map<String, Object> parameters = new HashMap<String, Object>();
    					parameters.put("org1", content[0]);
    					parameters.put("org2", content[1]);
    					parameters.put("org3", content[2]);
    					parameters.put("org4", content[3]);
    					parameters.put("org5", content[4]);
    					parameters.put("org6", content[5]);
    					parameters.put("org7", content[6]);
    					
						tx.run("CREATE (o:Organization {id: {org1}, name: {org2}, link: {org3},describe: {org4}, date: {org5}, address: {org6}, phone: {org7}})",parameters);
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
