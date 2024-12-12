package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketPages.AdminUser;
import supermarketPages.Homepage;
import supermarketPages.ManageCategoryPage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	public Homepage homepage;
	public AdminUser adminuser;
	public ManageCategoryPage managecategorypage;

	@Test
	public void addcategoryvalues() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		managecategorypage = homepage.manageclick();
		String value = ExcelUtility.readStringData(3, 0, "Values");
		managecategorypage.manageclick().newclick().entercategoryvalue(value).selectgroup().chooseimagevalue()
				.checktopradiobutton().checkleftradiobutton().categorysavebutton();
		boolean alertmsgisloaded = managecategorypage.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
	}
}
