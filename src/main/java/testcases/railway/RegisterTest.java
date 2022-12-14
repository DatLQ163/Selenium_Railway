package testcases.railway;

import common.Constant;
import common.Log;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends GeneralTest{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07(){
        String REGISTER_USERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
        String testConfirmPassword = Constant.PASSWORD_TEST;
        Log.info("TC-07 - User can create new account");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Register' tab");
        homePage.gotoPage("Register");
        Log.info("3. Enter valid information into all fields then click on 'Register' button");
        registerPage.register(REGISTER_USERNAME, Constant.PASSWORD_TEST, testConfirmPassword, Constant.PASSPORT_NUMBER);

        String actualMsg = registerPage.getRegisterSuccessfullyMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg,"User cannot create new account");
    }

    @Test
    public void TC10(){
        String REGISTER_USERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
        String testConfirmPassword = Constant.PASSWORD_TEST + (int)(Math.random() * 10);
        Log.info("TC-10 - User can't create account with 'Confirm password' is not the same with 'Password'");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Register' tab");
        homePage.gotoPage("Register");
        Log.info("3. Enter valid information into all fields except 'Confirm password' is not the same with 'Password' then click on 'Register' button");
        registerPage.register(REGISTER_USERNAME, Constant.PASSWORD_TEST,testConfirmPassword,Constant.PASSPORT_NUMBER);

        String actualMsg = registerPage.displayErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"User can create account with 'Confirm password' is not the same with 'Password'");
    }

    @Test
    public void TC11(){
        String REGISTER_USERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
        Log.info("TC-11 - User can't create account while password and PID fields are empty");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Register; tab");
        homePage.gotoPage("Register");
        Log.info("3. Enter valid email address and leave other fields empty then click on 'Register' button");
        registerPage.register(REGISTER_USERNAME, "","","");

        //message above the form
        String actualErrMsg = registerPage.displayErrorMessage();
        String expectedErrMsg = "There're errors in the form. Please correct the errors and try again.";
        Log.info("Verify error message display above the form");
        Assert.assertEquals(actualErrMsg,expectedErrMsg,"error message display above the form different with expected message");

        //message next to password field
        String actualPasswordMsg = registerPage.displayValidationMessage("password");
        String expectedPasswordMsg = "Invalid password length";
        Log.info("Verify error message display next to password field");
        Assert.assertEquals(actualPasswordMsg,expectedPasswordMsg,"error message display next to password field different with expected message");

        //message next to PID field
        String actualPIDMsg = registerPage.displayValidationMessage("pid");
        String expectedPIDMsg = "Invalid ID length";
        Log.info("Verify error message display next to PID field");
        Assert.assertEquals(actualPIDMsg,expectedPIDMsg,"error message display next to PID field different with expected message");
    }
}
