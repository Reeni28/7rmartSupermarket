package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admindropdown;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
	WebElement loginpage;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	WebElement adminusers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subcategory;
	@FindBy(xpath = "//p[text()='Manage Category']")
	WebElement manage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement subcatsearchbutton;
	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subcategoryclick;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=573&page_ad=1']")
	WebElement deletebutton;
	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement contact;
	// @FindBy(xpath="
	// //a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement
	// newbutton;
	@FindBy(xpath = " (//i[@class='fas fa-edit'])[2]")
	WebElement editbutton;

	public void admin() {
		admindropdown.click();
	}

	public void logout() {
		logout.click();
	}

	public AdminUser adminuser() {
		adminusers.click();
		return new AdminUser(driver);
	}

	public SubCategoryPage subcatgy() {
		subcategory.click();
		return new SubCategoryPage(driver);
	}

	public ManageCategoryPage manageclick() {
		manage.click();
		return new ManageCategoryPage(driver);
	}

	public SearchSubCategoryPage subcatclick() {
		subcategoryclick.click();
		return new SearchSubCategoryPage(driver);

	}

	public DeleteCategoryPage deleteclick() {
		deletebutton.click();
		return new DeleteCategoryPage(driver);
	}

	public ManageContactPage contactclick() {
		contact.click();
		return new ManageContactPage(driver);
	}

	public EditCategory editclick() {
		editbutton.click();
		return new EditCategory(driver);
	}
}
