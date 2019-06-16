package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVReaderInJava {

	public static void main(String[] args) {
	//String z="C:\\Users\\User\\eclipse-workspace\\csvfile1\\src\\com\\inputfile.csv";
		 List<Employee> records = readFilesFromCSV("inputfile.csv");
		 for(Employee a : records)
		 {
			 System.out.println(a);
		 }
	    List<Employee> records1=getSortedList(records);
	    for(Employee a : records1)
	    {
	    	System.out.println(a.getFirst_name());
	    }
	    filterFileBasedOnCity(records);
		 
	}
	private static List<Employee> readFilesFromCSV(String fileName)
	{
		List<Employee> records = new ArrayList<>();
	Path pathToFile = Paths.get(fileName);
	try 
	(BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII))
	{
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null)
		{
			String[] attributes=line.split(" , ");
			Employee file=createList(attributes);
			records.add(file);
			line=br.readLine();
		}
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
	}
	return records;
	}
	private static Employee createList(String[] metadata)
	{
		String fName=metadata[0];
		String lName=metadata[1];
		String companyName=metadata[2];
		String address=metadata[3];
		String city=metadata[4];
		String country=metadata[5];
		String state=metadata[6];
		String zip=metadata[7];
		String phone1=metadata[8];
		String phone2=metadata[9];
		String email=metadata[10];
		String web=metadata[11];
		return new Employee(fName,lName,companyName,address,city,country,state,zip,phone1,phone2,email,web);
	}
	public static List<Employee> getSortedList(List<Employee> e)
	{
		for(int i=0;i<e.size()-1;i++)
		{
			for(int j=i+1;j<e.size()-1;j++)
			{
				if(e.get(i).getFirst_name().compareTo(e.get(j).getFirst_name())>0)
				{
					Collections.swap(e, i, j);
					
				}
			}
		
			
	}
		return e;
	}
	public static void filterFileBasedOnCity(List<Employee> g)
	{
		for(Employee a: g)
		{
			if(a.getCity().equals("\"New York\""))
			{
				System.out.println(a.getFirst_name()+" "+a.getLast_name()+" "+a.getCity());
				
			}
		}
	}
		
	}
	
		

 
