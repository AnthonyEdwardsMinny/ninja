package com.ninzahrm.projectTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.ninzahrm.genericUtility.fileutility;
import com.ninzahrm.genericUtility.webdriverutility;

public class moonsite {
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
				fileutility flib=new fileutility();
		webdriverutility wlib=new webdriverutility();
		  String browser = flib.getdatafrompropertyHrm("browser");
		    String url = flib.getdatafrompropertyHrm("Urlspice");
		    String searchnamee = flib.getdatafrompropertyHrm("search");


			if(browser.equalsIgnoreCase("chrome")) {
			
			    WebDriver driver=new ChromeDriver(opt);
			   
			driver.manage().window().maximize();
			wlib.waittoloadpage(driver);
			driver.get(url);
			driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("noon.com");
			driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			//step2 use jse methods and pass
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,1200)");
			
String data=null;
	 FileInputStream fis =  new FileInputStream("./configdata/spice.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("moon"+Math.random());
	
//		int rowno=0,cellno=0;
//		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
//		System.out.println(elements.size());
//		for(int i=0;i<=6;i++) {
//			for(WebElement elses:elements) {
//				data=elses.getText();
//				if(data.contains("Apple"))
//					System.out.println(data);
//				Row row=	sh.createRow(rowno++);
//				Cell cell=row.createCell(cellno);
//				cell.setCellValue(data);
////		 		}
//		WebElement ele=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div/div/div[5]/div/div/div/div/div/div/div/div[2]/div[2]"));
//		
//	 ele.click();
//	 Thread.sleep(2000);
//	 elements = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));}
//	//List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sc-fKWMtX jPgkAQ']/div/div/div"));
//
//		FileOutputStream fos=new FileOutputStream("./configdata/spice.xlsx");
//	wb.write(fos);
//	}
//	}
//	
//
//		
//		
//		
//	
//	
//			
//			wb.close();
//			driver.quit();
//				}}
//}				
//		


		int j=0 ;
		List<WebElement> apple = driver.findElements(By.xpath("//span[contains(text() , 'Apple')]"));
		for(int i=1 ; i<=6 ; i++)
		{
		for (WebElement apples : apple) 
		{
			
			if(apples.getText().contains("Apple"))
			{
				Cell cell = sh.createRow(j++).createCell(0);
			System.out.println(apples.getText());
		    cell.setCellValue(apples.getText().toString());	
			}
		}
		driver.findElement(By.xpath("(//div[contains(@class, '-recommendedProducts')])[1]")).click();
		Thread.sleep(1000);
		apple = driver.findElements(By.xpath("//span[contains(text() , 'Apple')]"));
		}
		FileOutputStream fos = new FileOutputStream("./configdata/spice.xlsx");
		wb.write(fos);
		wb.close();
		
		driver.quit();
		
	
		
	}	

	}}
