package com.ninzahrm.projectTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ninzahrm.genericUtility.fileutility;
import com.ninzahrm.genericUtility.webdriverutility;

public class spicejet {
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
			driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(searchnamee);
			driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
			driver.findElement(By.xpath("//h3[contains(.,'SpiceJet - Flight Booking')]")).click();
			driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("DEL");
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("HYD");
		Actions act=new Actions(driver);
//			WebElement element=driver.findElement(By.xpath("(//*[name()='svg'and @data-testid='svg-img'])[13]"));
//			act.click(element).perform();
			WebElement element1=driver.findElement(By.xpath("(//div[@dir='auto'])[95]"));
		act.click(element1).perform();
		//WebElement element2=driver.findElement(By.xpath("(//*[name()='svg'and @data-testid='svg-img'])[14]"));
		//	act.click(element2).perform();
			WebElement element3=driver.findElement(By.xpath("(//div[@dir='auto'])[115]"));
			act.click(element3).perform();
		WebElement dd=driver.findElement(By.xpath("(//*[name()='svg' and @data-testid='svg-img'])[15]"));
			act.click(dd).perform();
////			
		WebElement selectdd=driver.findElement(By.xpath("(//*[name()='svg'and @data-testid='svg-img'])[18]"));
			act.moveToElement(selectdd).doubleClick();
		WebElement searchbtn=driver.findElement(By.xpath("//div[text()='Search Flight']"));
		act.click(searchbtn).perform();
		//List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"list-results-section-0\"]/div[5]/div[1]/div"));
		//elements.forEach((e)->System.out.print(e.getText()));
        List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-3aj1re r-18u37iz']/div/div/div/div"));
		FileInputStream fis =  new FileInputStream("./configdata/spice.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("spicejet"+Math.random());
		
		System.out.println(findElements.size());
		int i=0,rn=0;
		sh.createRow(rn);
		for (WebElement webElement : findElements) {
			Thread.sleep(200);
			System.out.println(webElement.getText());
			String s = webElement.getText();
			if(i<=11)
			{
				sh.getRow(rn).createCell(i).setCellValue(s);
				i++;
			}
			
			else {
				
				sh.createRow(++rn);
				i=0;
				sh.getRow(rn).createCell(i).setCellValue(s);
				
			}
			
			
		}
		FileOutputStream fos=new FileOutputStream("./configdata/spice.xlsx");

		wb.write(fos);
		wb.close();
		
		driver.quit();
}
		
		
		
		
		
		
		
		
		
						
			//driver.quit();
		

	}

}
