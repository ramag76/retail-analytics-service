/**
 * 
 */
package com.bullet.proof.retail.analytics.service;

/**
 * @author Ram
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bullet.proof.retail.analytics.service.db.model.Customer;
 
public class CSVFileReader
{
	//Delimiter used in CSV file
		private static final String COMMA_DELIMITER = ",";
		
		//Student attributes index
		//private static final int CUSTOMER_ID_IDX = 0;
		private static final int CUSTOMER_FNAME_IDX = 0;
		private static final int CUSTOMER_LNAME_IDX = 1;
		private static final int CUSTOMER_DOB_IDX = 2; 
		private static final int CUSTOMER_GENDER_IDX = 3;
		
		public static List readCsvFile(String fileName) {

			BufferedReader fileReader = null;
			List custLists = new ArrayList();
	     
	        try {
	        	
	        	//Create a new list of student to be filled by CSV file data 
	        	
	        	
	            String line = "";
	            
	            //Create the file reader
	            fileReader = new BufferedReader(new FileReader(fileName));
	            
	            //Read the CSV file header to skip it
	            fileReader.readLine();
	            
	            //Read the file line by line starting from the second line
	            while ((line = fileReader.readLine()) != null) {
	                //Get all tokens available in line
	                String[] tokens = line.split(COMMA_DELIMITER);
	                if (tokens.length > 0) {
	                	//Create a new student object and fill his  data
						Customer cust = new Customer();
						cust.setFirstName(tokens[0]);
						cust.setLastName(tokens[1]);
						cust.setDob(new SimpleDateFormat("dd-mm-yyyy").parse(tokens[2]));
						cust.setGender(tokens[3]);
						//System.out.println(cust.toString());
						custLists.add(cust);
					}
	                
	            }
	            
/*	            //Print the new student list
	            for (Customer cust : custLists) {
					System.out.println(cust.toString());
				}*/
	        } 
	        catch (Exception e) {
	        	System.out.println("Error in CsvFileReader !!!");
	            e.printStackTrace();
	        } finally {
	            try {
	                fileReader.close();
	            } catch (IOException e) {
	            	System.out.println("Error while closing fileReader !!!");
	                e.printStackTrace();
	            }
	        }
			return custLists;

		}

}