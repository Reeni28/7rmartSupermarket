package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class UserLoginTest extends Base {
	@DataProvider(name = "Credentials")
	public Object[][] testData() {
		Object data[][] = { { "fdfnb", "@#%$$^%&" }, { "Reeni", "1234#" }, { "sdgsga", "xnzbc^&&*(" } };
		return data;
	}

	@Test(dataProvider = "Credentials")
	public void verifyUserLoginWithInValidCredentials(String Invalidusername, String Invalidpassword) {

		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(Invalidusername, Invalidpassword);
		login.loginButton();
		boolean homepageisloaded = login.isHomepageisloaded();
		Assert.assertTrue(homepageisloaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifyValidCredentials(String username, String password) {
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		login.loginButton();
		boolean loginpageisloaded = login.isHomepageisloaded();
		Assert.assertTrue(loginpageisloaded, Constant.ERRORMESSAGEFORVALID);
	}

	@Test
	@Parameters({ "invalidusername", "invalidpassword" })
	public void verifywithInvalidUsernameInvalidPassword(String invalidusername, String invalidpassword) {
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(invalidusername, invalidpassword);
		login.loginButton();
		boolean loginpageisloaded = login.isHomepageisloaded();
		Assert.assertTrue(loginpageisloaded, Constant.ERRORMESSAGEFORVALID);
	}

	@Test

	public void verifyInvalidUserValidPassword() throws IOException {
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(ExcelUtility.readStringData(1, 0, "LoginTest1"),
				ExcelUtility.readStringData(1, 1, "LoginTest1"));
		login.loginButton();
		boolean loginpageisloaded = login.isHomepageisloaded();
		Assert.assertTrue(loginpageisloaded, Constant.ERRORMESSAGEFORLOGIN);
	}

	@Test

	public void verifyValidUserInalidPassword() throws IOException {
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(ExcelUtility.readStringData(1, 0, "LoginTest1"),
				ExcelUtility.readStringData(1, 1, "LoginTest1"));
		login.loginButton();
		boolean loginpageisloaded = login.isHomepageisloaded();
		Assert.assertTrue(loginpageisloaded, Constant.ERRORMESSAGEFORLOGIN);
	}

}
