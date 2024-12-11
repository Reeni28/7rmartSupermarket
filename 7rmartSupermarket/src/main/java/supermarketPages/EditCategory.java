package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;

public class EditCategory {
	public WebDriver driver;

	public EditCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = " (//i[@class='fas fa-edit'])[2]")
	WebElement editbutton;
@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
@FindBy(xpath="//button[@type='submit']")WebElement categoryupdate;
//public EditCategory newclick()
//{
//	newbutton.click();
//	return this;
//}
public EditCategory choosefileclick()
{
	FileUploadUtility fileupload=new FileUploadUtility();
	fileupload.sendkeyforImageUpload(choosefile, Constant.CATEGORYIMG);
	return this;
	
}
public EditCategory updateclick()
{
	categoryupdate.click();
	return this;
}
}
