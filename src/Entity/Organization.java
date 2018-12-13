package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import FileHandle.*;

public class Organization extends Attribute {
    private String phone;
    private String address;
    private String name;
    private List<String> list_name = new ArrayList<String>(new HandleTXT().getData("dataset/organization/name.txt"));
    private List<String> list_address = new ArrayList<String>(new HandleTXT().getData("dataset/organization/address.txt"));
    private List<String> list_phone = new ArrayList<String>(new HandleTXT().getData("dataset/organization/phone.txt"));
    

    public Organization() {
        super();
        address = "";
        name = "";
        phone = "";
    }

    public Organization(String identify, String name, String link, String describe, String date, String address, String phone) {
        super(identify, link, describe, date);
        this.phone = phone;
        this.address = address;
        this.name = name;
    }
    
    //getter and setter of name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter and setter of address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //getter and setter of phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getRandomName() throws FileNotFoundException {
 
		Random rado = new Random();
		int id = rado.nextInt(list_name.size());
		return list_name.get(id);
	}
    
    public String getRandomAddress() throws FileNotFoundException {
   
		Random rado = new Random();
		int id = rado.nextInt(list_address.size());
		return list_address.get(id);
	}
    
    public String getRandomPhone() throws FileNotFoundException {
    	
		Random rado = new Random();
		int id = rado.nextInt(list_phone.size());
		return list_phone.get(id);
	}

    @Override
    public String toString() {
        String s = "";
        s = identify + "," + name + "," + link + "," + describe + "," + date + "," + address + "," + phone;
        return s;
    }
}
