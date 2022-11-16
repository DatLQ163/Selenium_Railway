package testcases.railway;

import common.Constant;
import common.Log;
import common.PropertiesFile;
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
        Log.info("TC15-User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Login with a valid account");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        loginPage.clickLogin();
        Log.info("3. Click on 'Timetable' tab");
        loginPage.gotoPage("Timetable");
        Log.info("4. Click on 'book ticket' link of the route from 'Huế' to 'Sài Gòn'");
        Utilities.scrollToFindElement();
        timetablePage.clickBookTicketLink("Huế","Sài Gòn");

        String actualMsg = bookTicketPage.getBookTicketPageTitle();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg, "Test case failed");

        //        list data trip
        List<String> listDataTrip = timetablePage.getDataChoose("Huế","Sài Gòn");
        List<String> listDataBooking = timetablePage.getDataBooking();
        for(int i = 0;i<listDataTrip.size();i++){
            Assert.assertEquals(listDataTrip.get(i),listDataBooking.get(i),"test case failed");
        }
    }
}
