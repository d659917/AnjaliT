package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.class_screenshot;

import Utility.ExcelUtility;

public class TestClass1 {

	WebDriver driver;

	@BeforeTest
	public void  setUp() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.phptravels.net/admin");
	
	//call screenshot method here
	class_screenshot.captureScreen(driver);
	Thread.sleep(20000);
	}
	
	@Test
	public void loginOperation() throws InterruptedException
	{
		WebElement email=null;
		WebElement pwd=null;
		WebElement login=null;
		
		String excelPath="C:\\Users\\anjali.t.arasu\\eclipse-workspace\\DataDriven_Maven\\src\\test\\resources\\credentials.xlsx";		
		
		ExcelUtility exu=new ExcelUtility(excelPath);
		
	    String sheetName="Admin";
		
		int rowCount=exu.getNumberOfRows(sheetName);
		int colCount=exu.getNumberOfCols(sheetName);
		
		String email1=null;
		String pwd1=null;
		
		for(int i=1; i<rowCount; i++)
		{
			email1=exu.getCellData(sheetName,i,0);
			pwd1=exu.getCellData(sheetName,i,1);
			
			email = driver.findElement(By.name("email"));
			pwd = driver.findElement(By.name("password"));
			login = driver.findElement(By.xpath("//button[@type='submit']"));
		
			
			email.sendKeys(email1);
			pwd.sendKeys(pwd1);
			login.click();
			
			Thread.sleep(8000);
			
			String pageTitle=driver.getTitle();
			if(pageTitle.equals("Dashboard"))
			{
				exu.setCellData(sheetName, i, 2, "PASS");
				driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
				Thread.sleep(10000);
			}
			
			else
			{
				exu.setCellData(sheetName, i, 2, "FAIL");
				email.clear();
				pwd.clear();
			}
		}
		
		String destinationPath="C:\\Users\\anjali.t.arasu\\Desktop\\result.xlsx";
		ExcelUtility.writeAndSaveExcel(destinationPath);
		Thread.sleep(10000);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}

