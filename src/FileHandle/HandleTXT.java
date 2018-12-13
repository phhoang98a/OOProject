package FileHandle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Entity.Relationship;

public class HandleTXT {
	
	private LinkedList<Relationship> relationship;
	
	public List<String> getData(String path)   {
		
		List<String> content = new ArrayList<String>();
    	Scanner input;
		try {
			input = new Scanner(new FileReader(path));
			while (input.hasNextLine()) {
	            content.add(input.nextLine());
	        }
	    	input.close();
			return content;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
	}
	
	 public LinkedList<Relationship> readRelationshipFile(int entity1,int entity2) {
	        String fileName = "";
	        relationship = new LinkedList<Relationship>();
	        //cac file person
	        if (entity1 == 1 && entity2 == 2)
	            fileName = "dataEntity/person_organization.txt";
	        else if (entity1 == 1 && entity2 == 3)
	            fileName = "dataEntity/person_location.txt";
	        else if (entity1 == 1 && entity2 == 4)
	            fileName = "dataEntity/person_event.txt";
	        else if (entity1 == 1 && entity2 == 5)
	            fileName = "dataEntity/person_country.txt";
	            //cac file organization
	        else if (entity1 == 2 && entity2 == 1)
	            fileName = "dataEntity/organization_person.txt";
	        else if (entity1 == 2 && entity2 == 3)
	            fileName = "dataEntity/organization_location.txt";
	        else if (entity1 == 2 && entity2 == 4)
	            fileName = "dataEntity/organization_event.txt";
	        else if (entity1 == 2 && entity2 == 5)
	            fileName = "dataEntity/organization_country.txt";
	            //cac file location
	        else if (entity1 == 3 && entity2 == 1)
	            fileName = "dataEntity/location_person.txt";
	        else if (entity1 == 3 && entity2 == 2)
	            fileName = "dataEntity/location_organization.txt";
	        else if (entity1 == 3 && entity2 == 4)
	            fileName = "dataEntity/location_event.txt";
	        else if (entity1 == 3 && entity2 == 5)
	            fileName = "dataEntity/location_country.txt"; 
	            //cac file event
	        else if (entity1 == 4 && entity2 == 1)
	            fileName = "dataEntity/event_person.txt";
	        else if (entity1 == 4 && entity2 == 2)
	            fileName = "dataEntity/event_organization.txt";
	        else if (entity1 == 4 && entity2 == 3)
	            fileName = "dataEntity/event_location.txt";
	        else if (entity1 == 4 && entity2 == 5)
	            fileName = "dataEntity/event_country.txt";
	        //cac file country
	        else if (entity1 == 5 && entity2 == 1)
	            fileName = "dataEntity/country_person.txt";
	        else if (entity1 == 5 && entity2 == 2)
	            fileName = "dataEntity/country_organization.txt";
	        else if (entity1 == 5 && entity2 == 3)
	            fileName = "dataEntity/country_location.txt";
	        else if (entity1 == 5 && entity2 == 4)
	            fileName = "dataEntity/country_event.txt";
	        
	        
	        File f = new File(fileName);
	        String content = "";

	        if (f.exists() && f.isFile()) {
	            Scanner input = null;
	            try {
	                input = new Scanner(f);
	                while (input.hasNextLine()) {
	                    content = input.nextLine();
	                    Relationship rela = new Relationship(content);
	                    relationship.addLast(rela);
	                }
	                return relationship;
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            } finally {
	                if (input != null)
	                    input.close();
	            }
	        }
	        return null;
	    }

}
