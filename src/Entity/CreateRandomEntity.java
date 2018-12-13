package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
 
import FileHandle.*;


public class CreateRandomEntity {
	
	public void createEntity(int numberEntity) throws IOException {
		
		HandleCSV file = new HandleCSV();
		
		file.GenerateCSV("dataEntity/person.csv");
		file.GenerateCSV("dataEntity/organization.csv");
		file.GenerateCSV("dataEntity/location.csv");
		file.GenerateCSV("dataEntity/event.csv");
		file.GenerateCSV("dataEntity/country.csv");
		
		
		for (int i=0;i<numberEntity;i++) {
			int random = (int) (Math.random() * 5 + 0);
			switch (random) {
			case 0:
				String dataPerson = PersonGenerate();
				file.AddDataCSV("dataEntity/person.csv",dataPerson);
				continue;
			case 1:
				String dataOrganization = OrganizationGenerate();
				file.AddDataCSV("dataEntity/organization.csv",dataOrganization);
				continue;
			case 2:
				String dataLocation = LocationGenerate();
				file.AddDataCSV("dataEntity/location.csv",dataLocation);
				continue;
			case 3:
				String dataEvent = EventGenerate();
				file.AddDataCSV("dataEntity/event.csv",dataEvent);
				continue;
			case 4:
				String dataCountry = CountryGenerate();
				file.AddDataCSV("dataEntity/country.csv",dataCountry);
				continue;
			default:
				break;
			}
		}
	}
	
	
	public String PersonGenerate() throws FileNotFoundException {
		String data = new Person(new Attribute().getRandomIdentify(0),new Person().getRandomName(),new Attribute().getRandomLink(),new Attribute().getRandomDescribe(0),new Attribute().getRandomDate(),new Person().getRandomJob()).toString();
		return data;
	}
	
	public String OrganizationGenerate() throws FileNotFoundException {
		String data = new Organization(new Attribute().getRandomIdentify(1),new Organization().getRandomName(),new Attribute().getRandomLink(),new Attribute().getRandomDescribe(1),new Attribute().getRandomDate(),new Organization().getRandomAddress(),new Organization().getRandomPhone()).toString();
		return data;
	}
	
	public String LocationGenerate() throws FileNotFoundException {
		String data = new Location(new Attribute().getRandomIdentify(2),new Location().getRandomName(),new Attribute().getRandomLink(),new Attribute().getRandomDescribe(2),new Attribute().getRandomDate()).toString();
		return data;
	}
	
	public String EventGenerate() throws FileNotFoundException {
		String data = new Event(new Attribute().getRandomIdentify(3),new Event().getRandomName(),new Attribute().getRandomLink(),new Attribute().getRandomDescribe(3),new Attribute().getRandomDate()).toString();
		return data;
	}
	
	public String CountryGenerate() throws FileNotFoundException {
		String data = new Country(new Attribute().getRandomIdentify(4),new Country().getRandomName(),new Attribute().getRandomLink(),new Attribute().getRandomDescribe(4),new Attribute().getRandomDate(),new Country().getRandomLocation()).toString();
		return data;
	}

	
}
