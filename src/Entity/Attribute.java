package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.FileNotFoundException;
import FileHandle.*;



public class Attribute  {
	
	private List<String> list_link = new ArrayList<String>(new HandleTXT().getData("dataset/link/link.txt"));
	private List<String> list_time_extracted = new ArrayList<String>(new HandleTXT().getData("dataset/TimeExtracted/TimeExtracted.txt"));
    protected String identify;
    protected String link;
    protected String describe;
    protected String date;
   
    
    
    private static int[] number = new int[5];
    public Attribute(){
        identify = "";
        link = "";
        describe = "";
        date = "";
    }
    public Attribute(String identify, String link, String describe, String date ) {
        this.identify = identify;
        this.link = link;
        this.describe = describe;
        this.date = date;
    }
    //getter and setter of identify
    
    public String getIdentify() {
    	return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
    
    //getter and setter of link
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    //getter and setter of describe
    public String getDescribe() {
    	return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    //getter and setter of date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public String getRandomDescribe(int idEntity) {
    	switch (idEntity) {
		case 0:
			return "Mo_ta_thuc_the_person";
		case 1:
			return "Mo_ta_thuc_the_organization";
		case 2:
			return "Mo_ta_thuc_the_location";
		case 3:
			return "Mo_ta_thuc_the_event";
		case 4:
			return "Mo_ta_thuc_the_country";
		default:
			return null;
		}
    }
    
    public String getRandomIdentify(int idEntity) {
    	number[idEntity] = number[idEntity]+1;
        String ident = String.valueOf(number[idEntity]);   
        switch (idEntity) {
		case 0:
			return "person_"+ident;
		case 1:
			return "organization_"+ident;
		case 2:
			return "location_"+ident;
		case 3:
			return "event_"+ident;
		case 4:
			return "country_"+ident;
		default:
			return null;
		}
    }
    
    public String getRandomLink() throws FileNotFoundException {
		Random rado = new Random();
		int id = rado.nextInt(list_link.size());
		return list_link.get(id);
	}
	
    public String getRandomDate() throws FileNotFoundException  {
 
		Random rado = new Random();
		int id = rado.nextInt(list_time_extracted.size());
		return list_time_extracted.get(id);
	}
    
}
