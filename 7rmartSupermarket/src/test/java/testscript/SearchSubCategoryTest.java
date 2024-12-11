package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import supermarketPages.AdminUser;
import supermarketPages.AdminUserSearch;
import supermarketPages.Homepage;
import supermarketPages.SearchSubCategoryPage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class SearchSubCategoryTest extends Base{
	public Homepage homepage;
	public AdminUser adminuser;
	public SearchSubCategoryPage searchsubcategorypage;
	
  @Test
  public void searchsubcategory() throws IOException {
	  String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
	
	    searchsubcategorypage=homepage.subcatclick();
		 String catvalue = ExcelUtility.readStringData(5, 0, "Values");
	     String subvalue = ExcelUtility.readStringData(5, 1, "Values");
	    searchsubcategorypage.subcatclick().subcatsearch().categorydropdownlist(catvalue).subcategory(subvalue).search();
		 
		 
  }
}
