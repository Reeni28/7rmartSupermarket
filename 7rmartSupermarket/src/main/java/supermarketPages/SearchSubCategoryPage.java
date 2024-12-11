package supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class SearchSubCategoryPage {
	public WebDriver driver;

	public SearchSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//p[text()='Sub Category']")WebElement subcategoryclick;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement subcatsearchbutton;
	@FindBy(xpath="//select[@id='un']")WebElement categorydrop;
	@FindBy(xpath="//input[@class='form-control']")WebElement subcategory;
	@FindBy(xpath="//button[@name='Search']")WebElement search;
	public SearchSubCategoryPage subcatclick()
	{
		subcategoryclick.click();
		return this;
		
	}
	
	public SearchSubCategoryPage subcatsearch()
	{
		subcatsearchbutton.click();
		return this;
		
	}
	public SearchSubCategoryPage categorydropdownlist(String textvalue) {
		PageUtility pageutility = new PageUtility();
		pageutility.categorySelectByVisibleText(categorydrop,textvalue );
		return this;
	}
	public SearchSubCategoryPage subcategory(String subcat)
	{
		subcategory.sendKeys(subcat);
		return this;
		
	}
	public SearchSubCategoryPage search()
	{
		search.click();
		return this;
		
	}

}
