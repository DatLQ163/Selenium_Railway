package testcases.railway;

import common.Log;
import common.PropertiesFile;
import common.ReadCSVFile;
import common.Utilities;
import pageobjects.BookTicketPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TimetableTest extends GeneralTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimetablePage timetablePage = new TimetablePage();

    @Test
    public void TC15(){
        // TC15 with using CSV file
        String rowNumber = "9";
        Log.info("TC15_1 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Login with a valid account");
        homePage.gotoPage("Login");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        Log.info("3. Click on 'Timetable' tab");
        loginPage.gotoPage("Timetable");
        Log.info("4. Click on 'book ticket' link of the route from 'Huế' to 'Sài Gòn'");
        timetablePage.clickBookTicketLink(ReadCSVFile.getDepartByLine(rowNumber),ReadCSVFile.getArriveByLine(rowNumber));

        String actualMsg = bookTicketPage.getBookTicketPageTitle();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg,"can not navigate to 'Book ticket' page ");

        //list data trip
        List<String> listDataTrip = timetablePage.getDataChoose(ReadCSVFile.getDepartByLine(rowNumber),ReadCSVFile.getArriveByLine(rowNumber));
        List<String> listDataBooking = bookTicketPage.getDataDisplay();
        Log.info("5. Verify that 'Book ticket' page is loaded with correct 'Depart from', 'Arrive at' ");
        for(int i = 0;i<listDataTrip.size();i++){
            Assert.assertEquals(listDataTrip.get(i),listDataBooking.get(i),"'Book ticket' page is loaded with incorrect 'Depart from' and 'Arrive at' values.");
        }
    }
}
