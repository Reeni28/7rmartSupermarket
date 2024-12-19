package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public WebDriver driver;

	public void waitforElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(element));// explicit wait
	}

	public void waitforVisibilityOfElement(WebDriver driver, WebElement newelement) {
		WebDriverWait waitforvisibility = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait
		waitforvisibility.until(ExpectedConditions.visibilityOf(newelement));
	}

	public void waitforAlertIsPresent(WebDriver driver, WebElement alert) {
		WebDriverWait waitforalert = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait
		waitforalert.until(ExpectedConditions.alertIsPresent());
	}

	public void waitforElementToBeSelected(WebDriver driver, WebElement selectedelement) {
		WebDriverWait waitforselectedelement = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait
		waitforselectedelement.until(ExpectedConditions.elementToBeSelected(selectedelement));
	}

	public void waitforTitleContains(WebDriver driver, WebElement title) {
		WebDriverWait waitfortitleContains = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait
		waitfortitleContains.until(ExpectedConditions.titleContains("title"));
	}

}