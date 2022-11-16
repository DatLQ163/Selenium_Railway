package testcases.railway;

import common.Constant;
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
        System.out.println("TC-07 - User can create new account");
        homePage.gotoPage("Register");
        registerPage.fillDataRegister(Constant.REGISTER_USERNAME, Constant.PASSWORD, testConfirmPassword, Constant.PASSPORT_NUMBER);
        Utilities.scrollToFindElement();
        registerPage.clickRegister();

        String actualMsg = registerPage.getMsgRegisterSuccessfully().getText();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "Testcase failed");
    }
    @Test
    public void TC10(){
        String testConfirmPassword = Constant.PASSWORD + (int)(Math.random() * 10);
        System.out.println("User can't create account with 'Confirm password' is not the same with 'Password'");
        homePage.gotoPage("Register");
        registerPage.fillDataRegister(Constant.REGISTER_USERNAME, Constant.PASSWORD,testConfirmPassword,Constant.PASSPORT_NUMBER);
        registerPage.clickRegister();

        String actualMsg = registerPage.getLblErrormessage().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Testcase failed");
    }
    @Test
    public void TC11(){
        String testPassword = "";
        String testPID ="";
        String testConfirmPassword = Constant.PASSWORD;
        System.out.println("User can't create account while password and PID fields are empty'");
        homePage.gotoPage("Register");
        Utilities.scrollToFindElement();
        registerPage.fillDataRegister(Constant.REGISTER_USERNAME, testPassword,testConfirmPassword,testPID);
        registerPage.clickRegister();

        String actualMsg = registerPage.getLblErrormessage().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Testcase failed");

        String actualMsgPassword = registerPage.getLblValidation("password").getText();
        String expectedMsgPassword = "Invalid password length";
        Assert.assertEquals(actualMsgPassword,expectedMsgPassword,"Testcase failed");

        String actualMsgPID = registerPage.getLblValidation("pid").getText();
        String expectedMsgPID = "Invalid ID length";
        Assert.assertEquals(actualMsgPID,expectedMsgPID,"Testcase failed");
    }
}
