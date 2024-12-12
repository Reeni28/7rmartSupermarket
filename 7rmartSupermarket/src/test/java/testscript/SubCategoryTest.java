package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketPages.AdminUser;
import supermarketPages.Homepage;
import supermarketPages.SubCategoryPage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	public Homepage homepage;
	public AdminUser adminuser;
	public SubCategoryPage subcategorypage;

	@Test
	public void subcategoryvalues() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		subcategorypage = homepage.subcatgy();
		String subcategoryvalueinput = ExcelUtility.readStringData(4, 1, "Values");
		subcategorypage.subcatnew().selectcategorydropdown().subcategory(subcategoryvalueinput).imagevalue()
				.savesubcategory();
		boolean alertmessageisdisplayed = subcategorypage.isalertisloaded();
		Assert.assertTrue(alertmessageisdisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
