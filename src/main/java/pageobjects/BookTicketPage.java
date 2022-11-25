package pageobjects;

import common.Constant;
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

    // Methods
}
