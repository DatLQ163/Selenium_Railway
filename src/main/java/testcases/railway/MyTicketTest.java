package testcases.railway;

import common.Constant;
import common.Log;
import common.PropertiesFile;
import common.Utilities;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.*;
import org.testng.annotations.Test;

public class MyTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC16 (){
        String DEPART_DATE = String.valueOf((int) (Math.random() * 27+4));
        String rowNumber ="5";
        Log.info("TC-16 - User can cancel a ticket");
        Log.info("1. Navigate to QA Railway Website");
        Log.info("2. Login with a valid account");
        homePage.gotoPage("Login");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        Log.info("3. Book a ticket");
        loginPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Sài Gòn","Nha Trang","Soft bed with air conditioner", "1" );
        Log.info("4. Click on 'My ticket' tab");
        bookTicketPage.gotoPage("My ticket");

        //determined cancel button id
        String cancelID = myTicketPage.getCancelId(rowNumber);

        Log.info("5. Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.cancelTicket(rowNumber);
        Log.info("6. Click on 'OK' button on Confirmation message 'Are you sure?'");
        myTicketPage.clickOkAlert();

        //check display row be canceled
        Log.info("Verify that a ticket canceled is disappear");
        Boolean actualResult = myTicketPage.checkRowBeCanceled(cancelID);
        Assert.assertTrue(actualResult, "User can not cancel a ticket");
    }
}
