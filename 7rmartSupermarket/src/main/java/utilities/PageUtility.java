package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void elementSelectByIndex(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	public void categorySelectByVisibleText(WebElement catdropdown, String text) {
		Select select = new Select(catdropdown);
		select.selectByVisibleText(text);
	}

	public void elementSelectByValue(WebElement dropdown, String value) {
		Select selectvalue = new Select(dropdown);
		selectvalue.selectByValue(value);
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}

	public void rightClick() {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();
	}

	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public boolean isElementVisible(WebElement element) {
		return (element.isDisplayed());
	}

}
