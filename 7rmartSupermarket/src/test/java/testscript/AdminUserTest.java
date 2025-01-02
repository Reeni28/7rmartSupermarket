package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketPages.AdminUser;
import supermarketPages.Homepage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	public Homepage homepage;
	public AdminUser adminuser;
	public FakerUtility faker = new FakerUtility();

	@Test(retryAnalyzer = retry.Retry.class)

	public void adminuserpage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		adminuser = homepage.adminuser();
		String adminusername = faker.getFakeFirstName();
		String adminpassword = faker.getFakePassword();
		adminuser.newuser().newusername(adminusername).newpassword(adminpassword).dropdownlist().save();

		boolean alertmsgisloaded = adminuser.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);

	}
}