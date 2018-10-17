package com.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class class_screenshot {
	
	public static void captureScreen(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(src,new File("C:\\Users\\anjali.t.arasu\\Desktop\\screenshot\\demo.jpg"));
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
