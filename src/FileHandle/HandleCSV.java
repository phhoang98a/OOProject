package FileHandle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import Entity.*;
public class HandleCSV {
	
	 private LinkedList<Person> person;
	 private LinkedList<Country> country;
	 private LinkedList<Event> event;
	 private LinkedList<Location> location;
	 private LinkedList<Organization> organization;
	 private LinkedList<Relationship> relationship;
	
	public void AddDataCSV(String path, String data) throws IOException {
		FileWriter writer = new FileWriter(path,true);
		writer.append(data);
		writer.append("\n");
		writer.flush();
		writer.close();
	}
	
	public void GenerateCSV(String path) throws IOException {
		File f = new File(path);
		if(f.exists() && !f.isDirectory()) { 
		    f.delete();
		}
		f.createNewFile();
		
	}
	
	 //Doc file person.csv
    public LinkedList<Person> readPersonFile() {
        File f = new File("dataEntity/person.csv");
        String content = "";
        person = new LinkedList<Person>();

        if (f.exists() && f.isFile()) {
            Scanner input = null;
            try {
                input = new Scanner(f);
                while (input.hasNextLine()) {
                    content = input.nextLine();
                    String str[] = content.split(",");
                    Person p = new Person(str[0], str[1], str[2], str[3], str[4], str[5]);
                    person.addLast(p);
                }
                return person;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (input != null)
                    input.close();
            }
        } else {
            System.out.println("File person.csv chua ton tai!");
        }
		return null;
    }

    //Doc file country.csv
    public LinkedList<Country> readCountryFile() {
        File f = new File("dataEntity/country.csv");
        String content = "";
        country = new LinkedList<Country>();


        if (f.exists() && f.isFile()) {
            Scanner input = null;
            try {
                input = new Scanner(f);
                while (input.hasNextLine()) {
                    content = input.nextLine();
                    String str[] = content.split(",");
                    Country country1 = new Country(str[0], str[1], str[2], str[3], str[4], str[5]);
                    country.addLast(country1);
                }
                return country;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (input != null)
                    input.close();
            }
        }
        return null;
    }

    //Doc file event.csv
    public LinkedList<Event> readEventFile() {
        File f = new File("dataEntity/event.csv");
        String content = "";
        event = new LinkedList<Event>();

        if (f.exists() && f.isFile()) {
            Scanner input = null;
            try {
                input = new Scanner(f);
                while (input.hasNextLine()) {
                    content = input.nextLine();
                    String str[] = content.split(",");
                    Event event1 = new Event(str[0], str[1], str[2], str[3], str[4]);
                    event.addLast(event1);
                }
                return event;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (input != null)
                    input.close();
            }
        }
        return null;
    }

    //Doc file location.csv
    public LinkedList<Location> readLocationFile() {
        File f = new File("dataEntity/location.csv");
        String content = "";
        location = new LinkedList<Location>();

        if (f.exists() && f.isFile()) {
            Scanner input = null;
            try {
                input = new Scanner(f);
                while (input.hasNextLine()) {
                    content = input.nextLine();
                    String str[] = content.split(",");
                    Location loc = new Location(str[0], str[1], str[2], str[3], str[4]);
                    location.addLast(loc);
                }
                return location;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (input != null)
                    input.close();
            }
        }
        return null;

    }

    //Doc file organization.csv
    public LinkedList<Organization> readOrganizationFile() {
        File f = new File("dataEntity/organization.csv");
        String content = "";
        organization = new LinkedList<Organization>();

        if (f.exists() && f.isFile()) {
            Scanner input = null;
            try {
                input = new Scanner(f);
                while (input.hasNextLine()) {
                    content = input.nextLine();
                    String str[] = content.split(",");
                    Organization org = new Organization(str[0], str[1], str[2], str[3], str[4], str[5], str[6]);
                    organization.addLast(org);
                }
                return organization;
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
