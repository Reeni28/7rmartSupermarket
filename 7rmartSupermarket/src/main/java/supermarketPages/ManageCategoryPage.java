package supermarketPages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;

public class ManageCategoryPage {
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Category']")
	WebElement manage;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryvalue;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement group;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//input[@name='top_menu']")
	WebElement radiotopbutton;
	@FindBy(xpath = "(//input[@value='no'])[2]")
	WebElement radioleftbutton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement addcategorysave;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public ManageCategoryPage manageclick() {
		manage.click();
		return this;
	}

	public ManageCategoryPage newclick() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage entercategoryvalue(String value) {
		categoryvalue.sendKeys(value);
		return this;
	}

	public ManageCategoryPage selectgroup() {
		group.click();
		return this;
	}

	public ManageCategoryPage chooseimagevalue() {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendkeyforImageUpload(choosefile, Constant.CATEGORYIMG);
		return this;
	}

	public ManageCategoryPage checktopradiobutton() {
		radiotopbutton.click();
		return this;
	}

	public ManageCategoryPage checkleftradiobutton() {
		radioleftbutton.click();
		return this;
	}

	public ManageCategoryPage categorysavebutton() {
		addcategorysave.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion

	}
}
