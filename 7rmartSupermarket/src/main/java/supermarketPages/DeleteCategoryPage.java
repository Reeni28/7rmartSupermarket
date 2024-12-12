package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCategoryPage {
	public WebDriver driver;

	public DeleteCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=573&page_ad=1']")
	WebElement deletebutton;
	@FindBy(xpath = "//a[@onclick='return confirm('Do you want to delete this Category?')']")
	WebElement alertclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public DeleteCategoryPage deleteclick() {
		deletebutton.click();
		return this;
	}

	public DeleteCategoryPage alert() {
		alertclick.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isalertisloaded() {
		return alertmessage.isDisplayed();// checking assertion

	}

}