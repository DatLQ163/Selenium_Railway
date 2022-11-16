package testcases.railway;

import common.Constant;
import common.Utilities;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;
import org.testng.annotations.Test;

public class MyTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void TC17(){
        System.out.println("TC-05 - User can filter ticket successfully");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();
        loginPage.gotoPage("My ticket");
        Utilities.scrollToFindElement();
        myTicketPage.fillDataFilter("");
        myTicketPage.clickFilter();

//        String actualMsg = bookTicketPage.getMsgBook();
//        String expectedMsg = "Ticket Booked Successfully!";
//
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
    }
    @Test
    public void TC16(){
        System.out.println("TC-16 - User can cancel a ticket");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();
        loginPage.gotoPage("My ticket");
        Utilities.scrollToFindElement();
        myTicketPage.cancelTicket("3");
        myTicketPage.clickOkAlert();
    }
}
