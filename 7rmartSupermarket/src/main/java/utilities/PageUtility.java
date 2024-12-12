package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void elementSelectByIndex(WebElement dropdown,int index)
	{
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public void categorySelectByVisibleText(WebElement catdropdown,String text)
	{
		Select select=new Select(catdropdown);
		select.selectByVisibleText(text);
	}
	
	public void elementSelectByValue(WebElement dropdown,String value)
	{
		Select selectvalue=new Select(dropdown);
		selectvalue.selectByValue(value);
	}
	
}
