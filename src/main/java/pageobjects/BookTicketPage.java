package pageobjects;

import common.Constant;
import common.DriverManager;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class BookTicketPage extends GeneralPage {
    // Locators
    private final By ddlDepartDate = By.xpath("//select[@name='Date']");
    private final By ddlDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By ddlArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By lblBookSuccessfullyMessage = By.xpath("//div/h1");
    private final By lblTicketDepartData = By.xpath("//table//td[count(//th[.='Depart Station']/preceding-sibling::th)+1]");
    private final By lblTicketArriveData = By.xpath("//table//td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblTicketSeatTypeData = By.xpath("//table//td[count(//th[.='Seat Type']/preceding-sibling::th)+1]");
    private final By lblTicketDepartDateData = By.xpath("//table//td[count(//th[.='Depart Date']/preceding-sibling::th)+1]");
    private final By lblTicketAmountData = By.xpath("//table//td[count(//th[.='Amount']/preceding-sibling::th)+1]");
    private final By lblBookTicketPageTitle = By.xpath("//h1[.='Book ticket']");

    // Elements
    private WebElement getDdlDepartDate() {
        return Constant.WEBDRIVER.findElement(ddlDepartDate);
    }

    private WebElement getDdlDepartFrom() {
        return Constant.WEBDRIVER.findElement(ddlDepartFrom);
    }

    private WebElement getDdlArriveAt() {
        return Constant.WEBDRIVER.findElement(ddlArriveAt);
    }

    private WebElement getDdlSeatType() {
        return Constant.WEBDRIVER.findElement(ddlSeatType);
    }

    private WebElement getDdlTicketAmount() {
        return Constant.WEBDRIVER.findElement(ddlTicketAmount);
    }

    private WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    // Methods
    public void fillDataBookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        Select dropDepartDate = new Select(getDdlDepartDate());
        Select dropDepartFrom = new Select(getDdlDepartFrom());
        Select dropArriveAt = new Select(getDdlArriveAt());
        Select dropSeatType = new Select(getDdlSeatType());
        Select dropTicketAmount = new Select(getDdlTicketAmount());
        Utilities.scrollToFindElement(getLink());
        dropDepartDate.selectByValue(departDate);
        dropDepartFrom.selectByVisibleText(departFrom);
        dropArriveAt.selectByVisibleText(arriveAt);
        dropSeatType.selectByVisibleText(seatType);
        dropTicketAmount.selectByVisibleText(ticketAmount);
    }

//    public void fillDataBookTicket(String departFrom) {
//        Select dropDepartFrom = new Select(getDdlDepartFrom());
//        Utilities.scrollToFindElement(getLink());
//        dropDepartFrom.selectByValue(departFrom);
//    }

    public void clickBookTicket(){
        getBtnBookTicket().click();
    }

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount){
        fillDataBookTicket(departDate,departFrom,arriveAt,seatType,ticketAmount );
        clickBookTicket();
    }

}
