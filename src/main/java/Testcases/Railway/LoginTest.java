package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends GeneralTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void TC01(){
        System.out.println("TC-01 - User can login with valid username and password");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
    }
    @Test
    public void TC02(){
        System.out.println("TC-01 - User can not login with invalid username");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.INVALIDUSERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome guest!";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
    }
}
