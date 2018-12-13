package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

import FileHandle.*;

public class RelationAPI {
	public void addRelation(Driver driver)
    {
        // Sessions are lightweight and disposable connection wrappers.
    	try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
    		try {
    			Scanner input = new Scanner(new FileReader("dataRelation/relation.csv"));
    			while (input.hasNextLine()) {
    				String[] content = input.nextLine().split(",");
    				try(Transaction tx = session.beginTransaction())
    				{
    					Map<String, Object> parameters = new HashMap<String, Object>();
    					parameters.put("entity1", content[0]);
    					parameters.put("entity2", content[2]);
    					parameters.put("time", content[3]);
    					String CREATE_RELATION = Query( getNumber(content[0]) , getNumber(content[2]) , content[1] );
						tx.run(CREATE_RELATION,parameters);
						
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
	
	public int getNumber(String entity) {
		switch (entity.charAt(0)) {
		case 'p':
			return(1);
		case 'o':
			return(2);
		case 'l':
			return(3);
		case 'e':
			return(4);
		case 'c':
			return(5);
		default:
			return(0);
		}
	}
	
	public String getQuery(String path, String rela) {
		List<String> list_rela = new ArrayList<String>(new HandleTXT().getData(path));
		for (int i=0; i<list_rela.size();i++) {
			String content = list_rela.get(i);
			if (content.contains(rela)==true) return content;
		}
		return null;
		
		
	}
	
	public String Query(int entity1, int entity2, String rela) {
		if (entity1 == 1 && entity2 == 2)
			return getQuery("dataRelation/person_organization.txt",rela);
        else if (entity1 == 1 && entity2 == 3)
        	return getQuery("dataRelation/person_location.txt",rela);
        else if (entity1 == 1 && entity2 == 4)
        	return getQuery("dataRelation/person_event.txt",rela);
        else if (entity1 == 1 && entity2 == 5)
        	return getQuery("dataRelation/person_country.txt",rela);
        else if (entity1 == 2 && entity2 == 1)
        	return getQuery("dataRelation/organization_person.txt",rela);
        else if (entity1 == 2 && entity2 == 3)
        	return getQuery("dataRelation/organization_location.txt",rela);
        else if (entity1 == 2 && entity2 == 4)        	
        	return getQuery("dataRelation/organization_event.txt",rela);
        else if (entity1 == 2 && entity2 == 5)
        	return getQuery("dataRelation/organization_country.txt",rela);
        else if (entity1 == 3 && entity2 == 1)
        	return getQuery("dataRelation/location_person.txt",rela);
        else if (entity1 == 3 && entity2 == 2)
        	return getQuery("dataRelation/location_organization.txt",rela);
        else if (entity1 == 3 && entity2 == 4)
        	return getQuery("dataRelation/location_event.txt",rela);
        else if (entity1 == 3 && entity2 == 5)
        	return getQuery("dataRelation/location_country.txt",rela);
        else if (entity1 == 4 && entity2 == 1)	
        	return getQuery("dataRelation/event_person.txt",rela);
        else if (entity1 == 4 && entity2 == 2)
        	return getQuery("dataRelation/event_organization.txt",rela);
        else if (entity1 == 4 && entity2 == 3)
        	return getQuery("dataRelation/event_location.txt",rela);
        else if (entity1 == 4 && entity2 == 5)
        	return getQuery("dataRelation/event_country.txt",rela);
        else if (entity1 == 5 && entity2 == 1)
        	return getQuery("dataRelation/country_person.txt",rela);
        else if (entity1 == 5 && entity2 == 2)
        	return getQuery("dataRelation/country_organization.txt",rela);
        else if (entity1 == 5 && entity2 == 3)
        	return getQuery("dataRelation/country_location.txt",rela);
        else if (entity1 == 5 && entity2 == 4)
        	return getQuery("dataRelation/country_event.txt",rela);
		return null;
	}

}
