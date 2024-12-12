package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketPages.AdminUser;
import supermarketPages.Homepage;
import supermarketPages.ManageContactPage;
import supermarketPages.UserLogin;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	public Homepage homepage;
	public ManageContactPage managecontactpage;

	@Test
	public void updatemanagecontact() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		managecontactpage = homepage.contactclick();
		String phonenumber = ExcelUtility.readStringData(0, 0, "ContactDetails");
		String emailaddress = ExcelUtility.readStringData(1, 0, "ContactDetails");
		String addressdetails = ExcelUtility.readStringData(2, 0, "ContactDetails");
		String deliverytimevalue = ExcelUtility.readStringData(3, 0, "ContactDetails");
		String deliverycharge = ExcelUtility.readStringData(4, 0, "ContactDetails");
		managecontactpage.editactionclick().inputphonenumber(phonenumber).inputemailaddress(emailaddress)
				.inputaddress(addressdetails).inputdeliverytime(deliverytimevalue).inputdeliverycharge(deliverycharge)
				.updatebuttonclick();
		boolean alertmsgisloaded = managecontactpage.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);

	}
}
