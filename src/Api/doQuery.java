package Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;
import java.time.LocalDateTime;    


public class doQuery {
	
	//lay ten cua location 1
	private static String q1 = "MATCH (l:Location{id:'location_1'}) RETURN l.name AS result";
	
	//lay so dien thoai cua to chuc Guttmacher Institute
	private static String q2 = "MATCH (o:Organization{name:'Guttmacher Institute'}) RETURN o.phone AS result";
	
	//nhung su kien nao duoc to chuc o Pu Mat
	private static String q3 = "MATCH (e:Event)-[:duoc_to_chuc_o]->(l:Location{name:'Pu Mat'}) RETURN e.name AS result";
	
	//ngay dien ra su kien Space trip
	private static String q4 = "MATCH (e:Event) WHERE e.name='Space Trip' RETURN e.date AS result";
	
	//so dien thoai (565) 466-4210 la cua to chuc nao
	private static String q5 = "MATCH (o:Organization) WHERE o.phone='(565) 466-4210' RETURN o.name AS result";
	
	//nghe nghiep cua person 1
	private static String q6 = "MATCH (p:Person{id:'person_1'}) RETURN p.job AS result";
	
	// Frisco Woods dang dien ra su kien gi
	private static String q7 = "MATCH (l:Location{name:'Frisco Woods'})-[:dang_dien_ra]->(e:Event) RETURN e.name AS result";
	
	//ten cua nhan vien Firefighters
	private static String q8 = "MATCH (p:Person) WHERE p.job='Firefighters' RETURN p.name";

	//Slovenia nam o chau luc nao
	private static String q9 = "MATCH (c:Country{name:'Slovenia'}) RETURN c.location AS result";
	
	//Ten cua nhung nguoi duoc trich rut ngay 11-5-2013
	private static String q10 ="MATCH (p:Person) WHERE p.date='2013-05-11'  RETURN p.name AS result";
	
	// Frisco dien ra su kien World Space Week 2018 CSS Winnipeg Meet & Greet Event vao thoi gian nao
	private static String q11 = "MATCH (l:Location{name:'Frisco Woods'})-[r:dang_dien_ra]->(e:Event{name:'World Space Week 2018 CSS Winnipeg Meet & Greet Event'}) RETURN r.Time AS result";
	
	//Nhung dia diem dien ra su kien Life is possible in Mars vao thang 9 thang 10 nam 2015
	private static String q12 = "MATCH (l:Location)-[r:dang_dien_ra]->(e:Event{name:'Life is possible in Mars'})\r\n" 
							+ 	"WHERE r.Time [0]='2015-10' OR r.Time [0]='2015-09'\r\n" 
							+ 	"RETURN l.name AS result";
	
	
	private static String[] query = new String[] {q1, q2, q3, q4, q5, q6, q7, q8, q9,q10,q11,q12};
	
	public void getResult(Driver driver)
    {
       try(Session session = driver.session()){  
    	   for (int i=0;i<12;i++) {
    		   System.out.println("KET QUA CUA QUERY "+(i+1)+" LA:");
    		   double startTime = System.nanoTime();  
    		   StatementResult result = session.run(query[i]);
    		   double endTime = System.nanoTime();  
    		  
        	   while (result.hasNext())
               {
                   Record record = result.next();
                   System.out.println(record.get("result"));
               }
        	   
        	   double duration = (endTime - startTime)/1000000.0;
    		   System.out.println("Thoi gian chay " + duration);
    		 
    	   }
       }
		
       
    }
}
