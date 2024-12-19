package supermarketPages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement contact;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement editaction;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverychargelimit;
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	// public ManageContactPage contactclick() {
	// contact.click();
	// return this;
	// }

	public ManageContactPage editactionclick() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, editaction);
		editaction.click();
		return this;
	}

	public ManageContactPage inputphonenumber(String phonenumber) throws AWTException {
		FileUploadUtility fileupload = new FileUploadUtility();
		//fileupload.cleartextbox(phonenumber);
		fileupload.cleartextbox(phone,phonenumber);
		
		return this;
	}

	public ManageContactPage inputemailaddress(String emailaddress) {
		email.sendKeys(emailaddress);
		return this;
	}

	public ManageContactPage inputaddress(String addressdetails) {
		address.sendKeys(addressdetails);
		return this;
	}

	public ManageContactPage inputdeliverytime(String deliverytimevalue) {
		deliverytime.sendKeys(deliverytimevalue);
		return this;
	}

	public ManageContactPage inputdeliverycharge(String deliverycharge) {
		deliverychargelimit.sendKeys(deliverycharge);
		return this;
	}

	public ManageContactPage updatebuttonclick() {
		updatebutton.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion

	}
}
