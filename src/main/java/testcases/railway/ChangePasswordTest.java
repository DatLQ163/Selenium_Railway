package testcases.railway;

import common.Constant;
import common.Log;
import common.PropertiesFile;
import org.testng.Assert;
import pageobjects.ChangePasswordPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import org.testng.annotations.Test;

public class ChangePasswordTest extends GeneralTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09(){
        String testNewPass = Constant.PASSWORD + (int)(Math.random() * 10);
        Log.info("User can change password");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Login with valid account");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        loginPage.clickLogin();
        Log.info("3. Click on 'Change Password' tab");
        loginPage.gotoPage("Change password");
        Log.info("4. Enter valid value into all fields then click on 'Change Password' button.");
        changePasswordPage.changePassword(PropertiesFile.getPropValue("password"), testNewPass, testNewPass);
        //set new password to config.properties file
        PropertiesFile.setPropValue("password", testNewPass);

        String actualMsg = changePasswordPage.displayChangePasswordSuccessfullyMessage();
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg,expectedMsg);
    }
}
