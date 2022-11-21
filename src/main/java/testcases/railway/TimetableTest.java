package testcases.railway;

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
        String Depart = "Huế";
        String Arrive ="Sài Gòn";
        Log.info("TC15-User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Login with a valid account");
        homePage.gotoPage("Login");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        Log.info("3. Click on 'Timetable' tab");
        loginPage.gotoPage("Timetable");
        Log.info("4. Click on 'book ticket' link of the route from 'Huế' to 'Sài Gòn'");
        timetablePage.clickBookTicketLink(Depart,Arrive);

        String actualMsg = bookTicketPage.getBookTicketPageTitle();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg);

        //list data trip
        List<String> listDataTrip = timetablePage.getDataChoose(Depart,Arrive);
        List<String> listDataBooking = bookTicketPage.getDataDisplay();
        for(int i = 0;i<listDataTrip.size();i++){
            Assert.assertEquals(listDataTrip.get(i),listDataBooking.get(i));
        }
    }
}
