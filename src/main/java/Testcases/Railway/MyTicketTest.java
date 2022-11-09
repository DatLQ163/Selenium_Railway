package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.testng.annotations.Test;

public class MyTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void TC05(){
        System.out.println("TC-05 - User can filter ticket successfully");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoMyTicketPage();
        myTicketPage.filter("");

//        String actualMsg = bookTicketPage.getMsgBook();
//        String expectedMsg = "Ticket Booked Successfully!";
//
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
    }
}
