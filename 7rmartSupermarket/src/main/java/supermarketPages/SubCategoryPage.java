package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subcategory;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement subcatnewbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectcategorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryvalue;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement inputimage;
	@FindBy(xpath = "//button[contains(@name,'create')]")
	WebElement savesubcategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public SubCategoryPage subcatgy() {
		subcategory.click();
		return this;
	}

	public SubCategoryPage subcatnew() {
		subcatnewbutton.click();
		return this;
	}

	public SubCategoryPage selectcategorydropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(selectcategorydropdown, 3);
		return this;
	}

	public SubCategoryPage subcategory(String subcategoryvalueinput) {
		subcategoryvalue.sendKeys(subcategoryvalueinput);
		return this;
	}

	public SubCategoryPage imagevalue() {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendkeyforImageUpload(inputimage, Constant.SUBCATIMG);
		return this;
	}

	public SubCategoryPage savesubcategory() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, savesubcategory);
		savesubcategory.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alertmessage.isDisplayed();// checking assertion

	}

}
