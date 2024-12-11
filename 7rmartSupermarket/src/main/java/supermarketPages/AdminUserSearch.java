package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserSearch {
	public WebDriver driver;

	public AdminUserSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@onclick='click_button(2)'])[1]")
	WebElement search;

	@FindBy(xpath = "//input[@id='un']")
	WebElement usernamesearch;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertypedropdown;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchsubmit;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement resultpage;

	public AdminUserSearch searchbutton() {
		search.click();
		return this;
	}

	public AdminUserSearch usernamesearchtext(String user) {
		usernamesearch.sendKeys(user);
		return this;

	}

	public AdminUserSearch dropdownlist() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(usertypedropdown, 1);
		return this;
	}

	public AdminUserSearch searchsubmitbutton() {
		searchsubmit.click();
		return this;
	}

	public boolean isresultpageisloaded() {
		return resultpage.isDisplayed();// checking assertion

	}

}
