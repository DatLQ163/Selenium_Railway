package testcases.railway;

import common.Constant;
import common.Log;
import common.Utilities;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends GeneralTest{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    @Test
    public void TC07(){
        String testConfirmPassword = Constant.PASSWORD;
        Log.info("TC-07 - User can create new account");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Register' tab");
        homePage.gotoPage("Register");
        Log.info("3. Enter valid information into all fields");
        registerPage.fillDataRegister(Constant.REGISTER_USERNAME, Constant.PASSWORD, testConfirmPassword, Constant.PASSPORT_NUMBER);
        Utilities.scrollToFindElement();
        Log.info("4. Click on 'Register' button");
        registerPage.clickRegister();

        String actualMsg = registerPage.getRegisterSuccessfullyMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "Testcase failed");
    }
    @Test
    public void TC10(){
        String testConfirmPassword = Constant.PASSWORD + (int)(Math.random() * 10);
        Log.info("User can't create account with 'Confirm password' is not the same with 'Password'");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Register' tab");
        homePage.gotoPage("Register");
        Log.info("3. Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
        Utilities.scrollToFindElement();
        registerPage.fillDataRegister(Constant.REGISTER_USERNAME, Constant.PASSWORD,testConfirmPassword,Constant.PASSPORT_NUMBER);
        Log.info("4. Click on 'Register' button");
        registerPage.clickRegister();

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Testcase failed");
    }
    @Test
    public void TC11(){
        Log.info("User can't create account while password and PID fields are empty'");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Register; tab");
        homePage.gotoPage("Register");
        Log.info("3. Enter valid email address and leave other fields empty");
        Utilities.scrollToFindElement();
        registerPage.fillDataRegister(Constant.REGISTER_USERNAME, "","","");
        Log.info("4. Click on 'Register' button");
        registerPage.clickRegister();

        //message above the form
        String actualErrMsg = registerPage.getErrorMessage();
        String expectedErrMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrMsg,expectedErrMsg,"Testcase failed");

        //message next to password field
        String actualPasswordMsg = registerPage.getValidationLabel("password");
        String expectedPasswordMsg = "Invalid password length";
        Assert.assertEquals(actualPasswordMsg,expectedPasswordMsg,"Testcase failed");

        //message next to PID field
        String actualPIDMsg = registerPage.getValidationLabel("pid");
        String expectedPIDMsg = "Invalid ID length";
        Assert.assertEquals(actualPIDMsg,expectedPIDMsg,"Testcase failed");
    }
}
