package supermarketPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUser {
	public WebDriver driver;

	public AdminUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameinput;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordinput;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement dropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath="(//a[@onclick='click_button(2)'])[1]")WebElement search;

	

	public AdminUser newuser() {
		newbutton.click();
		return this;
	}

	public AdminUser newusername(String newusernamefield) {
		usernameinput.sendKeys(newusernamefield);
		return this;

	}

	public AdminUser newpassword(String newpasswordfield) {
		passwordinput.sendKeys(newpasswordfield);
		return this;

	}

	public AdminUser dropdownlist() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(dropdown, 3);
		return this;
	}

	public AdminUser save() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion

	}
	public AdminUserSearch adminusersearch() {
		search.click();
		return new AdminUserSearch(driver);
	}
}
