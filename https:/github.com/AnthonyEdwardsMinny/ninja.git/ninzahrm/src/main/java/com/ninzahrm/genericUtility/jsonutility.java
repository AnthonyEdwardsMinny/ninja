package com.ninzahrm.genericUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonutility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fir=new FileReader("./configdata/ninz.json");
		JSONParser parse=new JSONParser();
		Object obj=parse.parse(fir);
		JSONObject values= (JSONObject) obj;
		String data=values.get(key).toString();
		
		return data;
		
	}

}
