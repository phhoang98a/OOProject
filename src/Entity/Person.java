package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import FileHandle.*;

public class Person extends Attribute {
    private String name;
    private String job;
    private List<String> list_name = new ArrayList<String>(new HandleTXT().getData("dataset/person/name.txt"));
    private List<String> list_job = new ArrayList<String>(new HandleTXT().getData("dataset/person/job.txt"));
    

    public Person() {
        super();
        job = "";
        name = "";
    }

    public Person(String ident, String name, String link, String describe, String date, String job) {
        super(ident, link, describe, date);
        this.job = job;
        this.name = name;
    }

    //getter and setter of job
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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
    
    public String getRandomJob() throws FileNotFoundException {
    	
		Random rado = new Random();
		int id = rado.nextInt(list_job.size());
		return list_job.get(id);
	}
    

    @Override
    public String toString() {
        String s = "";
        s = identify + "," + name + "," + link + "," + describe + "," + date + "," + job;
        return s;
    }
}
