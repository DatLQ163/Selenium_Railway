package testcases.railway;

import common.*;
import pageobjects.BookTicketPage;
import pageobjects.GeneralPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC04(){
        Log.info("TC-04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Click on 'Book ticket' tab");
        homePage.gotoPage("Book ticket");

        String actualMsg = loginPage.displayLoginPageTitle();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "Login page do not display when un-logged User clicks on 'Book ticket' tab");
    }

    @Test
    public void TC14(){
        Log.info("TC-14 - User can book 1 ticket at a time");
        String DEPART_DATE = String.valueOf((int) (Math.random() * 27+4));
        String DepartFrom = "Sài Gòn";
        String ArriveAt = "Nha Trang";
        String SeatType ="Soft bed with air conditioner";
        String TicketAmount ="1";
        Log.info("TC-14 - User can book 1 ticket at a time");
        Log.info("1. Navigate to QA Railway Website");
        homePage.gotoPage("Login");
        Log.info("2. Login with a valid account ");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        Log.info("3. Click on 'Book ticket' tab");
        loginPage.gotoPage("Book ticket");
        Log.info("4. Select a 'Depart date' from the list");
        Log.info("5. Select 'Sài Gòn' for 'Depart from' and 'Nha Trang' for 'Arrive at'.");
        Log.info("6. Select 'Soft bed with air conditioner' for 'Seat type'");
        Log.info("7. Select '1' for 'Ticket amount'");
        bookTicketPage.fillDataBookTicket(DEPART_DATE,DepartFrom,ArriveAt, SeatType, TicketAmount );
        //get list Data Booking
        List<String> listDataBooking = bookTicketPage.getInfoBooking();
        Log.info("8. Click on 'Book ticket' button");
        bookTicketPage.clickBookTicket();
        //get list Data Ticket
        List<String> listDataTicket = bookTicketPage.getInfoTicket();

        String actualMsg = bookTicketPage.getBookSuccessfullyMessage();
        String expectedMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "User can not book 1 ticket at a time");
        for(int i = 0;i<listDataBooking.size();i++){
            Assert.assertEquals(listDataBooking.get(i),listDataTicket.get(i),"Ticket information display incorrectly");
        }
    }
}
