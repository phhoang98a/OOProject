package Entity;

import java.io.FileNotFoundException;
import FileHandle.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Country extends Attribute {
    private String location;
    private String name;
    private List<String> list_name = new ArrayList<String>(new HandleTXT().getData("dataset/country/name.txt"));
    private List<String> list_location = new ArrayList<String>(new HandleTXT().getData("dataset/country/location.txt"));
    public Country() {
    	  location = "";
          name = "";
    }
    public  Country(String identify, String name, String link, String describe, String date, String location) {
        super(identify,link,describe,date);
        this.location = location;
        this.name = name;
    }
    //getter and setter of location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //getter and setter of name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getRandomName() throws FileNotFoundException {
		Random rado = new Random();
		int id = rado.nextInt(list_name.size());
		return list_name.get(id);
	}
    
    public String getRandomLocation() throws FileNotFoundException {
		Random rado = new Random();
		int id = rado.nextInt(list_location.size());
		return list_location.get(id);
	}
    
    @Override
    public String toString() {
        return identify + "," + name + "," + link + "," + describe + "," + date + "," + location;
    }
}
