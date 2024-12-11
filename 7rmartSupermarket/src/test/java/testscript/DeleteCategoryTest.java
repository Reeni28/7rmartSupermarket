package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import supermarketPages.AdminUser;
import supermarketPages.DeleteCategoryPage;
import supermarketPages.Homepage;
import supermarketPages.ManageCategoryPage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class DeleteCategoryTest extends Base {
	public Homepage homepage;
	
	public ManageCategoryPage managecategorypage;
	public DeleteCategoryPage deletecategorypage;
  @Test
  public void deletecategoryvalues() throws IOException {
	  String username = ExcelUtility.readStringData(1, 0, "Login");
	  String password = ExcelUtility.readStringData(1, 1, "Login");
	  UserLogin login = new UserLogin(driver);
	  login.enterUserNamePasswordField(username, password);
	  homepage = login.loginButton();
	
	  managecategorypage=homepage.manageclick();
	  deletecategorypage=homepage.deleteclick();
	  deletecategorypage.alert();
	  
    
  
  }
}
