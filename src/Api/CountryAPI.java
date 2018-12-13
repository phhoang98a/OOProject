package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

public class CountryAPI {
	public void addCountry(Driver driver)
    {
        // Sessions are lightweight and disposable connection wrappers.
    	try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
    		try {
    			Scanner input = new Scanner(new FileReader("dataEntity/country.csv"));
    			while (input.hasNextLine()) {
    				String[] content = input.nextLine().split(",");
    				try(Transaction tx = session.beginTransaction())
    				{
    					Map<String, Object> parameters = new HashMap<String, Object>();
    					parameters.put("cou1", content[0]);
    					parameters.put("cou2", content[1]);
    					parameters.put("cou3", content[2]);
    					parameters.put("cou4", content[3]);
    					parameters.put("cou5", content[4]);
    					parameters.put("cou6", content[5]);
						tx.run("CREATE (c:Country {id: {cou1}, name: {cou2}, link: {cou3},describe: {cou4}, date: {cou5}, location: {cou6}})",parameters);
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
