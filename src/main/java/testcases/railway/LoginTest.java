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
        Log.info("3. Login with valid Email and Password");
        Utilities.scrollByJavaScript();
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + PropertiesFile.getPropValue("username");
        Assert.assertEquals(actualMsg, expectedMsg,"User can not log into Railway with valid username and password");
    }

    @Test
    public void TC02(){
        System.out.println("TC-02 - User can't login with blank 'Username' textbox");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox then click login button ");
        loginPage.login("", PropertiesFile.getPropValue("password"));

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg,"still login successfully with blank 'Username' textbox");
    }

    @Test
    public void TC03(){
        Log.info("TC-03 - User cannot log into Railway with invalid password");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Enter valid Email and invalid Password then click login button");
        loginPage.login(PropertiesFile.getPropValue("username"), Constant.INVALID_PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg,"still login successfully with invalid password");
    }

    @Test
    public void TC05(){
        Log.info("TC-05 - System shows message when user enters wrong password several times");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Enter valid information into 'Username' textbox except 'Password' textbox then click login.");
        Log.info("4. Repeat step 3 three more times.");
        for(int i = 0;i <= 6; i++) {
            loginPage.login(PropertiesFile.getPropValue("username"), "");
        }
        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg,"System do not show message when user enters wrong password several times" );
    }

    @Test
    public void TC06(){
        Log.info("TC-06 - Additional pages display once user logged in");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Login with valid account");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));

        //display MyTicket tab
        boolean actualMyTicketTabDisplay = homePage.displayTabMenu("My ticket");
        boolean expectedMyTicketTabDisplay = true;
        Assert.assertEquals(actualMyTicketTabDisplay, expectedMyTicketTabDisplay, "MyTicket tab do not display");

        //display ChangePassword tab
        boolean actualChangePasswordTabDisplay = homePage.displayTabMenu("Change password");
        boolean expectedChangePasswordTabDisplay = true;
        Assert.assertEquals(actualChangePasswordTabDisplay, expectedChangePasswordTabDisplay,"ChangPassword tab do not display");

        //display Logout tab
        boolean actualLogoutTabDisplay = homePage.displayTabMenu("Log out");
        boolean expectedLogoutTabDisplay = true;
        Assert.assertEquals(actualLogoutTabDisplay, expectedLogoutTabDisplay,"Logout tab do not display");

        //go to MyTicket page
        loginPage.gotoPage("My ticket");
        boolean actualMyTicketPageResult = myTicketPage.displayMyTicketTitle();
        boolean expectedMyTicketPageResult = true;
        Assert.assertEquals(expectedMyTicketPageResult,actualMyTicketPageResult,"can not go to MyTicket page");

        //go to ChangePassword page
        loginPage.gotoPage("Change password");
        boolean actualChangePasswordPageResult = changePasswordPage.displayChangePasswordPageTitle();
        boolean expectedChangePasswordPageResult = true;
        Assert.assertEquals(actualChangePasswordPageResult, expectedChangePasswordPageResult,"can not dot to Change password page");
    }

    @Test
    public void TC08(){
        Log.info("TC-08: User can't login with an account hasn't been registered");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Login' tab");
        homePage.gotoPage("Login");
        Log.info("3. Login with unregistered account");
        loginPage.login(Constant.UNREGISTERED_ACCOUNT, Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg,"still login successfully with unregistered account");
    }
}
