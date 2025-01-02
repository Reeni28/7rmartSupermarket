package testscript;

import java.awt.AWTException;
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
	public void updatemanagecontact() throws IOException, AWTException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		managecontactpage = homepage.contactclick();
		managecontactpage.editactionclick();
		String phonenumber = ExcelUtility.readIntegerCellValue(0, 0, "ContactDetails");
		String emailaddress = ExcelUtility.readStringData(1, 0, "ContactDetails");
		String addressdetails = ExcelUtility.readStringData(2, 0, "ContactDetails");
		String deliverytimevalue = ExcelUtility.readStringData(3, 0, "ContactDetails");
		String deliverycharge = ExcelUtility.readIntegerCellValue(4, 0, "ContactDetails");
		managecontactpage.inputphonenumber(phonenumber).inputemailaddress(emailaddress).inputaddress(addressdetails)
				.inputdeliverytime(deliverytimevalue).inputdeliverycharge(deliverycharge).updatebuttonclick();
		boolean alertmsgisloaded = managecontactpage.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);

	}
}
