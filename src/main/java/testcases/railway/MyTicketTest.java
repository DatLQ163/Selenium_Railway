package testcases.railway;

import common.Constant;
import common.Log;
import common.PropertiesFile;
import common.Utilities;
import pageobjects.BookTicketPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;
import org.testng.annotations.Test;

public class MyTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    @Test
    public void TC17(){
        Log.info("TC-17 - User can filter ticket successfully");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();
        loginPage.gotoPage("My ticket");
        Utilities.scrollToFindElement();
        myTicketPage.fillDataFilter("");
        myTicketPage.clickFilter();

//        String actualMsg = bookTicketPage.getMsgBook();
//        String expectedMsg = "Ticket Booked Successfully!";
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
    }
    @Test
    public void TC16(){
        Log.info("TC-16 - User can cancel a ticket");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Login with a valid account");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        loginPage.clickLogin();
        Log.info("3. Book a ticket");
        loginPage.gotoPage("Book ticket");
        Utilities.scrollToFindElement();
        bookTicketPage.fillDataBookTicket(Constant.DEPART_DATE,"Sài Gòn","Nha Trang",  "Soft bed with air conditioner", "1" );
        bookTicketPage.clickBookTicket();
        Log.info("4. Click on 'My ticket' tab");
        loginPage.gotoPage("My ticket");
        Log.info("5. Click on 'Cancel' button of ticket which user want to cancel.");
        Utilities.scrollToFindElement();
        myTicketPage.cancelTicket("3");
        Log.info("6. Click on 'OK' button on Confirmation message 'Are you sure?'");
        myTicketPage.clickOkAlert();
    }
}
