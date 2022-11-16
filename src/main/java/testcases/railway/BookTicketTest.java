package testcases.railway;

import common.Constant;
import common.Utilities;
import pageobjects.BookTicketPage;
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
        System.out.println("TC-04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        homePage.gotoPage("Book ticket");

        String actualMsg = loginPage.getTitleLoginPage().getText();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
    }
    @Test
    public void TC14(){
        System.out.println("TC-14 - User can book ticket successfully");
        homePage.gotoPage("Login");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickLogin();
        loginPage.gotoPage("Book ticket");
        Utilities.scrollToFindElement();
        bookTicketPage.fillDataBookTicket(1,"Sài Gòn","Nha Trang",  "Soft bed with air conditioner", "1" );
        List<String> listDataBooking = bookTicketPage.getInfoBooking();
        bookTicketPage.clickBookTicket();
        List<String> listDataTicket = bookTicketPage.getInfoTicket();

        String actualMsg = bookTicketPage.getMsgBookSuccessfully().getText();
        String expectedMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "test case failed");
        for(int i = 0;i<listDataBooking.size();i++){
            Assert.assertEquals(listDataBooking.get(i),listDataTicket.get(i),"test case failed");
        }
    }
}
