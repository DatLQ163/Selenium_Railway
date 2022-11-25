package testcases.railway;

import common.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.List;

public class MyTicketTest extends GeneralTest{
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimetablePage timetablePage = new TimetablePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void FTTC01 (){
        String DEPART_DATE = String.valueOf((int) (Math.random() * 27+4));
        String SeatType ="Soft bed with air conditioner";
        String TicketAmount ="1";
        Log.info("Create account");
        String REGISTER_USERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
        homePage.gotoPage("Register");
        registerPage.register(REGISTER_USERNAME, PropertiesFile.getPropValue("password"),PropertiesFile.getPropValue("password"),Constant.PASSPORT_NUMBER);
        PropertiesFile.setPropValue("username", REGISTER_USERNAME);

        String filterDepartStation ="Sài Gòn";
        Log.info("FTTC01 - User can filter 'Manager ticket' table with Depart Station");
        Log.info("1. Navigate to QA Railway Website");
        homePage.gotoPage("Login");
        Log.info("2. Login with a valid account ");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
//        Log.info("3. Book more than 6 tickets with different Depart Stations");
//        for(int i =1;i<=6;i++) {
//            bookTicketPage.gotoPage("Book ticket");
//            bookTicketPage.bookTicket(ReadCSVFile.getDepartByLine(String.valueOf(i)));
//        }
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Sài Gòn","Nha Trang",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Đà Nẵng","Huế",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Phan Thiết","Nha Trang",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Nha Trang","Đà Nẵng",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Huế","Nha Trang",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Quảng Ngãi","Đà Nẵng",SeatType,TicketAmount);
        Log.info("4. Click on 'My ticket' tab");
        loginPage.gotoPage("My ticket");
        Log.info("5. Select one of booked Depart Station in 'Depart Station' dropdown list");
        myTicketPage.fillFilterDepartStation(filterDepartStation);

        int rowFilterDisplayOnMyTicketTable = myTicketPage.countRowFilterDisplayOnMyTicketTable(filterDepartStation);
        System.out.println(rowFilterDisplayOnMyTicketTable);

        Log.info("5. 'Click Apply filter' button");
        myTicketPage.clickFilterButton();

        // Dem so row filter tren Filter page
        int rowFilterDisplayOnFilterPage = myTicketPage.countRowFilterDisplayOnFilterTable(filterDepartStation);
        System.out.println(rowFilterDisplayOnFilterPage);

        // Dem tong so row tren Filter page
        int rowTotalDisplayOnFilterPage = myTicketPage.countRowTotalDisplayOnFilterTable();
        System.out.println(rowTotalDisplayOnFilterPage);

        Boolean checkFilter = myTicketPage.checkFilter(rowFilterDisplayOnMyTicketTable,rowFilterDisplayOnFilterPage);
        Boolean checkTotal = myTicketPage.checkTotal(rowFilterDisplayOnFilterPage,rowTotalDisplayOnFilterPage );
        Assert.assertEquals(checkFilter,checkTotal,"User can not filter 'Manager ticket' table with Depart Station");
    }

    @Test
    public void FTTC02 (){
        String DEPART_DATE = String.valueOf((int) (Math.random() * 27+4));
        String SeatType ="Soft bed with air conditioner";
        String TicketAmount ="1";
        Log.info("Create account");
        String REGISTER_USERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
        homePage.gotoPage("Register");
        registerPage.register(REGISTER_USERNAME, PropertiesFile.getPropValue("password"),PropertiesFile.getPropValue("password"),Constant.PASSPORT_NUMBER);
        PropertiesFile.setPropValue("username", REGISTER_USERNAME);
        String filterStatus ="Paid";
        Log.info("FTTC02 - Error displays when user applies filter with un-existed value of 'Status' in 'Manage ticket' table");
        Log.info("1. Navigate to QA Railway Website");
        homePage.gotoPage("Login");
        Log.info("2. Login with a valid account ");
        loginPage.login(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        Log.info("3. Book more than 6 tickets with different Depart Stations");
//        for(int i =1;i<=6;i++) {
//            bookTicketPage.gotoPage("Book ticket");
//            bookTicketPage.bookTicket(ReadCSVFile.getDepartByLine(String.valueOf(i)));
//        }
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Sài Gòn","Nha Trang",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Đà Nẵng","Huế",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Phan Thiết","Nha Trang",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Nha Trang","Đà Nẵng",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Huế","Nha Trang",SeatType,TicketAmount);
        bookTicketPage.gotoPage("Book ticket");
        bookTicketPage.bookTicket(DEPART_DATE,"Quảng Ngãi","Đà Nẵng",SeatType,TicketAmount);
        Log.info("4. Click on 'My ticket' tab");
        loginPage.gotoPage("My ticket");
        Log.info("5. Select 'Paid' for 'Status'");
        myTicketPage.fillFilterStatus(filterStatus);
        Log.info("5. Click filter button");
        myTicketPage.clickFilterButton();

        Log.info("Verify 'filter not found' message");
        String actualMessage = myTicketPage.displayMessageFilterNotFound();
        String expectedMessage = "Sorry, can't find any results that match your filters."+"\n"+
            "Please change the filters and try again.";
        Log.info(actualMessage);
        Log.info(expectedMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Error do not display when filter not found");
    }
}
