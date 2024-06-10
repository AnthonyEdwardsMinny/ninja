package com.ninzahrm.projectTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.protocol.Resultset;
import com.ninzahrm.genericUtility.dbUtility;
import com.ninzahrm.genericUtility.excelutility;
import com.ninzahrm.genericUtility.fileutility;
import com.ninzahrm.genericUtility.javautility;
import com.ninzahrm.genericUtility.webdriverutility;

public class projectTest {
	public static void main(String[] args) throws IOException, SQLException {
		WebDriver driver=null;
		fileutility f=new fileutility();
		excelutility elib=new excelutility();
		webdriverutility wlib=new webdriverutility();
		dbUtility db =new dbUtility();
		javautility jlib=new javautility();
		
		String browser=f.getdatafrompropertyHrm("browser");
		
		String url=f.getdatafrompropertyHrm("url");
	
		String un=f.getdatafrompropertyHrm("un");
		
		String pwd=f.getdatafrompropertyHrm("pwd");
		
//		
//		String projname=elib.getdatafromExcel("sheet1", 1, 2)+jlib.RandomNUm();
//		String ts=elib.getdatafromExcel("sheet1", 1,3);
//		String pm=elib.getdatafromExcel("sheet1", 1,4)+jlib.RandomNUm();
//		String ps=elib.getdatafromExcel("sheet1", 1,5);
//		String created=elib.getdatafromExcel("sheet", 1, 6);
//		String projid=elib.getdatafromExcel("sheet1", 1, 1)+jlib.RandomNUm();
		db.getDbconnection();
		String query="insert into project values('TY_PROJ_09789','Kishore','17/05/2024', 'On Going','K_12','10')";
		int count=db.executeNonSelectQuery(query);
		System.out.println(count);
		
		
		if(browser.equalsIgnoreCase("chrome"))
		
		    driver=new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waittoloadpage(driver);
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("TY_PROJ_09789");
		WebElement element=driver.findElement(By.xpath("//td[text()='TY_PROJ_09789']"));
		if(element.isDisplayed()) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
	}
	String table=	driver.findElement(By.xpath("//tr[@class='tr']")).getText();
	System.out.println(table);
	String[]str=table.split(" ");
	for(String data:str) {
		System.out.println(data);
		elib.setdataintoExcel("Sheet1", 1, 1, data);
	}
	
	driver.quit();
	}
	
	
}