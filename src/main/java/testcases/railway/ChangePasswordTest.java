package testcases.railway;

import common.Constant;
import common.Utilities;
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
        System.out.println("User can change password");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();

        loginPage.gotoPage("Change password");

        Utilities.scrollToFindElement();
        changePasswordPage.fillDataChangePassword(Constant.PASSWORD, testNewPass, testNewPass);
        changePasswordPage.clickChangePassword();

        changePasswordPage.fillDataChangePassword(testNewPass,Constant.PASSWORD,Constant.PASSWORD);
        changePasswordPage.clickChangePassword();
    }
}
