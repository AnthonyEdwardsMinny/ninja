package com.ninzahrm.projectTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class flipkart {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		Actions act=new Actions(driver);
	WebElement ele=	driver.findElement(By.xpath("//span[text()='Fashion']"));
		act.moveToElement(ele).perform();
		
		 FileInputStream fis =  new FileInputStream("./configdata/spice.xlsx");
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sh = wb.createSheet("flip"+Math.random());
			int i=0,rn=0;
			

    List<WebElement>ELE=driver.findElements(By.className("_1BJVlg"));
    
    for(WebElement eles:ELE) {
    	act.moveToElement(eles).perform();
    	
    	List<WebElement>ele1=driver.findElements(By.className("_3490ry"));
    	for (WebElement else1 : ele1) {
    		String data=else1.getText();
    		Row r=sh.createRow(i++);
    		Cell c=r.createCell(rn);
    		c.setCellValue(data);
    		System.out.println(data);
			
		}
    	
    }
     FileOutputStream fos= new FileOutputStream("./configdata/spice.xlsx");
wb.write(fos);
wb.close();
    
    
    
	}

}
