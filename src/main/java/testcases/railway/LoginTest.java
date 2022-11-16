package testcases.railway;

import common.Constant;
import common.Log;
import common.Utilities;
import pageobjects.ChangePasswordPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest extends GeneralTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC01(){
//        Log.info("TC-01 - User can log into Railway with valid username and password");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Enter valid Email and Password");
        Utilities.scrollByJavaScript();
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        Log.info("4. Click on 'Login' button");
        loginPage.clickLogin();

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC02(){
        System.out.println("TC-02 - User can't login with blank 'Username' textbox");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin("", Constant.PASSWORD);
        loginPage.clickLogin();

        String actualMsg = loginPage.getMsgErrorLogin().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC03(){
        System.out.println("TC-03 - User cannot log into Railway with invalid password");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.INVALID_PASSWORD);
        loginPage.clickLogin();

        String actualMsg = loginPage.getMsgErrorLogin().getText();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC05(){
        System.out.println("TC-05 - System shows message when user enters wrong password several times");
        homePage.gotoPage("Login");
        for(int i = 0;i < 5; i++) {
            loginPage.fillDataLogin(Constant.USERNAME, Constant.INVALID_PASSWORD);
            loginPage.clickLogin();
        }
        String actualMsg = loginPage.getMsgErrorLogin().getText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC06(){
        System.out.println("TC-06 - Additional pages display once user logged in");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();

        //display MyTicket tab
        String actualTleMyTickettab = homePage.getTabMenu("My ticket").getText();
        String expectedTleMyTickettab = "My ticket";
        Assert.assertEquals(actualTleMyTickettab, expectedTleMyTickettab, "test case failed");

        //display ChangePassword tab
        String actualTleChangePasswordtab = homePage.getTabMenu("Change password").getText();
        String expectedTleChangePasswordtab = "Change password";
        Assert.assertEquals(actualTleChangePasswordtab, expectedTleChangePasswordtab, "test case failed");

        //display Logout tab
        String actualTleLogouttab = homePage.getTabMenu("Log out").getText();
        String expectedTleLogouttab = "Log out";
        Assert.assertEquals(actualTleLogouttab, expectedTleLogouttab, "test case failed");

        //go to MyTicket page
        loginPage.gotoPage("My ticket");
        String actualTleMyTicket = myTicketPage.getTitleMyTicketPage().getText();
        String expectedTleMyTicket = "Manage Tickets";
        Assert.assertEquals(actualTleMyTicket, expectedTleMyTicket, "test case failed");

        //go to ChangePassword page
        loginPage.gotoPage("Change password");
        String actualMsgChangePassword = changePasswordPage.getTitleChangePasswordPage().getText();
        String expectedMsgChangePassword = "Change password";
        Assert.assertEquals(actualMsgChangePassword, expectedMsgChangePassword, "test case failed");
    }
}
