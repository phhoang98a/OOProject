package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.Value;

public class Neo4jAPI {
	

	Driver driver;

    public void connect(String uri, String user, String password)
    {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }
    
    public void close()
    {
        driver.close();
    }
    
    public void addData() {
    	new PersonAPI().addPerson(driver);
    	new CountryAPI().addCountry(driver);
    	new LocationAPI().addLocation(driver);
    	new OrganizationAPI().addOrganization(driver);
    	new EventAPI().addEvent(driver);
    	new RelationAPI().addRelation(driver);
    }
    
    public void getQueryResult() {
    	new doQuery().getResult(driver);
    }
    
    
    
    
    
    
    
    


}
