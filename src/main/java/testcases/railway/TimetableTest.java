package testcases.railway;

import common.Constant;
import pageobjects.BookTicketPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimetableTest extends GeneralTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimetablePage timetablePage = new TimetablePage();
    @Test
    public void TC15(){
        System.out.println("TC15-User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();
        loginPage.gotoPage("Timetable");
        timetablePage.clickBookTicketLink();

        String actualMsg = bookTicketPage.getTitleBookTicketPage().getText();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg, "Test case failed");
    }
}
