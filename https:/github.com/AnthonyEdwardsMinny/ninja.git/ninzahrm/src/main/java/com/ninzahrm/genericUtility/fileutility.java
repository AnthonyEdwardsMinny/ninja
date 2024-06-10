package com.ninzahrm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileutility{
	//public static void main(String[] args) throws IOException {
		
	
	public String  getdatafrompropertyHrm(String key) throws IOException {
	
	FileInputStream fis= new FileInputStream("./configdata/hrm.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data=prop.getProperty(key);
	//System.out.println(data);
return data;
	
}
}