package com.ninzahrm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	public int RandomNUm() {
		
	
Random random=new Random();
int randomNO=random.nextInt(1000);
     return randomNO;
}
	public String DATEFORMATINYYYYMMDD() {
		
	Date day=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	                   String date=sim.format(day);
	                   return date;
	
}
	
	public String DATEreqfromYYYYMMDD(int days) {
		
		Date day=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		                   String date=sim.format(day);
		  Calendar cal=sim.getCalendar();
		  cal.add(cal.DAY_OF_MONTH,days);
		  String datereq=sim.format(cal.getTime());
		                
		                   return datereq;
		



	}
}