package testcases.railway;

import common.Constant;
import common.Log;
import common.PropertiesFile;
import common.Utilities;
import pageobjects.ChangePasswordPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends GeneralTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC01(){
        Log.info("TC-01 - User can log into Railway with valid username and password");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Enter valid Email and Password");
        Utilities.scrollByJavaScript();
        loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        Log.info("4. Click on 'Login' button");
        loginPage.clickLogin();

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC02(){
        System.out.println("TC-02 - User can't login with blank 'Username' textbox");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox ");
        loginPage.fillDataLogin("", PropertiesFile.getPropValue("password"));
        Log.info("4. Click on 'Login' button");
        loginPage.clickLogin();

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC03(){
        Log.info("TC-03 - User cannot log into Railway with invalid password");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Enter valid Email and invalid Password");
        loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), Constant.INVALID_PASSWORD);
        Log.info("4. Click on 'Login' button");
        loginPage.clickLogin();

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC05(){
        Log.info("TC-05 - System shows message when user enters wrong password several times");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Enter valid information into 'Username' textbox except 'Password' textbox.");
        Log.info("4. Click on 'Login' button");
        Log.info("5. Repeat step 3 three more times.");
        for(int i = 0;i <= 6; i++) {
            loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), "");
            loginPage.clickLogin();
        }
        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC06(){
        Log.info("TC-06 - Additional pages display once user logged in");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Login with valid account");
        loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        loginPage.clickLogin();

        //display MyTicket tab
        boolean actualMyTicketTabDisplay = homePage.displayTabMenu("My ticket");
        boolean expectedMyTicketTabDisplay = true;
        Assert.assertEquals(actualMyTicketTabDisplay, expectedMyTicketTabDisplay, "test case failed");

        //display ChangePassword tab
        boolean actualChangePasswordTabDisplay = homePage.displayTabMenu("Change password");
        boolean expectedChangePasswordTabDisplay = true;
        Assert.assertEquals(actualChangePasswordTabDisplay, expectedChangePasswordTabDisplay, "test case failed");

        //display Logout tab
        boolean actualLogoutTabDisplay = homePage.displayTabMenu("Log out");
        boolean expectedLogoutTabDisplay = true;
        Assert.assertEquals(actualLogoutTabDisplay, expectedLogoutTabDisplay, "test case failed");

        //go to MyTicket page
        loginPage.gotoPage("My ticket");
        boolean actualMyTicketPageResult = myTicketPage.displayMyTicketTitle();
        boolean expectedMyTicketPageResult = true;
        Assert.assertEquals(expectedMyTicketPageResult,actualMyTicketPageResult,"test case failed");

        //go to ChangePassword page
        loginPage.gotoPage("Change password");
        boolean actualChangePasswordPageResult = changePasswordPage.displayChangePasswordTitle();
        boolean expectedChangePasswordPageResult = true;
        Assert.assertEquals(actualChangePasswordPageResult, expectedChangePasswordPageResult, "test case failed");
    }
}
