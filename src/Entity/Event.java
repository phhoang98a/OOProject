package Entity;

import java.io.FileNotFoundException;
import FileHandle.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Event extends Attribute {
	private String name;
	private List<String> list_name = new ArrayList<String>(new HandleTXT().getData("dataset/event/name.txt"));
    public Event(){
        super();
        name = "";
    }
    public Event(String identify, String name, String link, String describe, String date ) {
        super(identify,link,describe,date);
        this.name = name;
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
    @Override
    public String toString() {
        return identify + "," + name + "," + link + "," + describe + "," + date;
    }
}
