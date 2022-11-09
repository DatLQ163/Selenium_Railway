package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.annotations.Test;

public class BookTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void TC04(){
        System.out.println("TC-04 - User can book ticket successfully");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket();

//        String actualMsg = bookTicketPage.getMsgBook();
//        String expectedMsg = "Ticket Booked Successfully!";
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message  is not displayed");
//        bookTicketPage.verifyBooking();
    }
}
