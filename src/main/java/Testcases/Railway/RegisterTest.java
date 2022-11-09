package Testcases.Railway;

import Common.Utilities;
import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends GeneralTest{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Utilities utilities = new Utilities();
    @Test
    public void TC03(){
        System.out.println("TC-03 - User can register with valid username");
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.REGISTERUSERNAME, Constant.PASSWORD, Constant.CONFIRMPASSWORD, Constant.PASSPORTNUMBER);

        String actualMsg = registerPage.getMsgRegister();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
    }
}
