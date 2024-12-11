package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import supermarketPages.EditCategory;
import supermarketPages.Homepage;
import supermarketPages.ManageCategoryPage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class EditCategoryTest extends Base {
	public Homepage homepage;

	public ManageCategoryPage managecategorypage;
	public EditCategory editcategorypage;

	@Test
	public void editcategoryvalues() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();

		managecategorypage = homepage.manageclick();
		editcategorypage = homepage.editclick();
		editcategorypage.choosefileclick();
	}
}
