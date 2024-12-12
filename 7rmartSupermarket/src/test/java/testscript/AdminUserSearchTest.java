package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketPages.AdminUser;
import supermarketPages.AdminUserSearch;
import supermarketPages.Homepage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class AdminUserSearchTest extends Base {
	public Homepage homepage;
	public AdminUser adminuser;
	public AdminUserSearch adminusersearch;

	@Test
	@Parameters({ "user" })
	public void usersearch(String usernameuser) throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		adminuser = homepage.adminuser();
		adminusersearch = adminuser.adminusersearch();
		adminusersearch.searchbutton().usernamesearchtext(usernameuser).dropdownlist().searchsubmitbutton();
		boolean reultpageisloaded = adminusersearch.isresultpageisloaded();
		Assert.assertTrue(reultpageisloaded, Constant.ERRORMESSAGEFORUSERSEARCH);

	}
}
