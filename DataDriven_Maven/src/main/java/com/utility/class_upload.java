package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class class_upload {
	
	//File upload by Robot class
	public static void UploadFile(String path)
	{
			
		//Copy the filepath
		StringSelection stringSelect=new StringSelection(path);
		Clipboard clipbrd=Toolkit.getDefaultToolkit().getSystemClipboard();
		clipbrd.setContents(stringSelect, null);
		
		Robot rbt=null;
		
		try
		{
			rbt=new Robot();
		}
		
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		
		rbt.delay(250);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.delay(150);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		}

}
