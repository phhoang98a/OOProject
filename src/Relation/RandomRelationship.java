package Relation;

import java.util.ArrayList;

/*
Person: 1
Organization: 2
Location: 3
Event: 4
Country: 5
Relationship: 0
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import Entity.*;
import FileHandle.*;
import Entity.*;

public class RandomRelationship {
    /*
    Cac buoc random
        - random entity1
        - random tu du lieu cua thuc the co entity tuong ung
        - dua att1 ve dang doi tuong vua random duoc
        - thuc hien 3 buoc tren doi voi entity2
        - random relationship
    Cac buoc random du lieu cua 1 thuc the bat ky
        - random index
        - lay du lieu tu linked list
     */
    private int entity1;
    private int entity2;
    private String time;
    private Relationship relationship;
    private Attribute att1;
    private Attribute att2;
    private List<String> list_time = new ArrayList<String>(new HandleTXT().getData("dataEntity/time.txt"));
    private LinkedList<Person> list_person = new HandleCSV().readPersonFile();
    private LinkedList<Organization> list_organization = new HandleCSV().readOrganizationFile();
    private LinkedList<Location> list_location = new HandleCSV().readLocationFile();
    private LinkedList<Event> list_event = new HandleCSV().readEventFile();
    private LinkedList<Country> list_country = new HandleCSV().readCountryFile();
    private LinkedList<Relationship> list_relationship;


    //Random entity1--relation-->entity2
    public void random() {
        Random rand = new Random();
        entity1 = rand.nextInt(4) + 1;

        while (entity2 == entity1 || entity2 == 0)
            entity2 = rand.nextInt(4) + 1;

		//Random Attribute1
        if (entity1 == 1) {
            att1 = randomPerson();
        } else if (entity1 == 2) {
            att1 = randomOrganization();
        } else if (entity1 == 3) {
            att1 = randomLocation();
        } else if (entity1 == 4) {
            att1 = randomEvent();
        } else if (entity1 == 5) {
            att1 = randomCountry();
        }

        //Random Attribute2
        if (entity2 == 1) {
        	att2 = randomPerson();
        } else if (entity2 == 2) {
            att2 = randomOrganization();
        } else if (entity2 == 3) {
        	att2 = randomLocation();
        } else if (entity2 == 4) {
        	att2 = randomEvent();
        } else if (entity2 == 5) {
        	att2 = randomCountry();
        }

        //Random relation
        list_relationship = new HandleTXT().readRelationshipFile(entity1, entity2);
        relationship =  new Relationship();
        relationship = randomRelation();
        time = randomTime();
    }
    
    //random person
    public Person randomPerson() {
        Random rand = new Random();
        int index = rand.nextInt(list_person.size());
        return list_person.get(index);
    }
    //random organization
    public Organization randomOrganization() {
        Random rand = new Random();
        int index = rand.nextInt(list_organization.size());
        return list_organization.get(index);
    }
    //random relationship
    public Relationship randomRelation() {
        Random rand = new Random();
        int index = rand.nextInt(list_relationship.size());
        return list_relationship.get(index);
    }
    //random country
    public Country randomCountry() {
        Random rand = new Random();
        int index = rand.nextInt(list_country.size());
        return list_country.get(index);
    }
    //random location
    public Location randomLocation() {
        Random rand = new Random();
        int index = rand.nextInt(list_location.size());
        return list_location.get(index);
    }
    //random event
    public Event randomEvent() {
        Random rand = new Random();
        int index = rand.nextInt(list_event.size());
        return list_event.get(index);
    }
    
    //random time
    public String randomTime() {
    	Random rand = new Random();
		int index = rand.nextInt(list_time.size());
		return list_time.get(index);
    }
    
    @Override
    public String toString() {
        String s = "";
        s = att1.getIdentify() + "," + relationship.getRelation() + "," + att2.getIdentify()+","+time;
        return s;
    }
}
