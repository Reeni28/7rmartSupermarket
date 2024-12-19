package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void sendkeyforFileUpload(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void robotclassforFileUpload(WebElement element,String path) throws AWTException
	{
		StringSelection selection=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robot	=new Robot();		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void sendkeyforImageUpload(WebElement imgelement,String imgpath)
	{
		imgelement.sendKeys(imgpath);
	}
	public void imageUpload(WebElement imgelement,String imgpath) throws AWTException
	{
		StringSelection selectionimage=new StringSelection(imgpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectionimage,null);
		Robot robot	=new Robot();		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
	}
	
	public void cleartextbox(WebElement contactclear,String value) throws AWTException
	{
	  
		Robot robot	=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
			
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_CLEAR);
			
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CLEAR);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
	}
}
