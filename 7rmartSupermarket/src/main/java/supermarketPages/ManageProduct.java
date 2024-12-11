package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProduct {
	public WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="(//p[text()='Manage Product'])[1]")WebElement manageproduct;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")WebElement newproductclick;
	
	
	@FindBy(xpath="//input[@id='title']")WebElement title;
	
	@FindBy(xpath="//input[@value='Nonveg']")WebElement radiobutton;
	
	@FindBy(xpath="//select[@id='cat_id']")WebElement categorydropdown;
	
	@FindBy(xpath="//input[@name='top_menu']")WebElement radiotopbutton;
	@FindBy(xpath="(//input[@value='no'])[2]")WebElement radioleftbutton;
	@FindBy(xpath="//button[@type='submit']")WebElement addcategorysave;
	public ManageProduct manageproductlink()
	{
		manageproduct.click();
		return this;
	}
	
	public ManageProduct newproductbutton()
	{
		newproductclick.click();
		return this;
	}
	
	
}
