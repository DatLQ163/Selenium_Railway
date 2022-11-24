package pageobjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class BookTicketPage extends GeneralPage{
    // Locators
    private final By ddlDepartDate = By.name("Date");
    private final By ddlDepartFrom = By.name("DepartStation");
    private final By ddlArriveAt = By.name("ArriveStation");
    private final By ddlSeatType = By.name("SeatType");
    private final By ddlTicketAmount = By.name("TicketAmount");
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

    private WebElement getLblBookSuccessfullyMessage() {
        return Constant.WEBDRIVER.findElement(lblBookSuccessfullyMessage);
    }

    private WebElement getLblTicketDepartData() {
        return Constant.WEBDRIVER.findElement(lblTicketDepartData);
    }

    private WebElement getLblTicketArriveData() {
        return Constant.WEBDRIVER.findElement(lblTicketArriveData);
    }

    private WebElement getLblTicketSeatTypeData() {
        return Constant.WEBDRIVER.findElement(lblTicketSeatTypeData);
    }

    private WebElement getLblTicketDepartDateData() {
        return Constant.WEBDRIVER.findElement(lblTicketDepartDateData);
    }

    private WebElement getLblTicketAmountData() {
        return Constant.WEBDRIVER.findElement(lblTicketAmountData);
    }

    private WebElement getLblBookTicketPageTitle(){
        return Constant.WEBDRIVER.findElement(lblBookTicketPageTitle);
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

    public List<String> getInfoBooking(){
        Select dropDepartDate = new Select(getDdlDepartDate());
        Select dropDepartFrom = new Select(getDdlDepartFrom());
        Select dropArriveAt = new Select(getDdlArriveAt());
        Select dropSeatType = new Select(getDdlSeatType());
        Select dropTicketAmount = new Select(getDdlTicketAmount());
        List<String> listInfoBooking = new ArrayList<>();
        listInfoBooking.add(dropDepartDate.getFirstSelectedOption().getText());
        listInfoBooking.add(dropDepartFrom.getFirstSelectedOption().getText());
        listInfoBooking.add(dropArriveAt.getFirstSelectedOption().getText());
        listInfoBooking.add(dropSeatType.getFirstSelectedOption().getText());
        listInfoBooking.add(dropTicketAmount.getFirstSelectedOption().getText());
        return listInfoBooking;
    }

    public List<String> getDataDisplay(){
        List<String> listDataBooking = new ArrayList<>();
        Select dropDepartFrom = new Select(getDdlDepartFrom());
        Select dropArriveAt = new Select(getDdlArriveAt());
        listDataBooking.add(dropDepartFrom.getFirstSelectedOption().getText());
        listDataBooking.add(dropArriveAt.getFirstSelectedOption().getText());
        return listDataBooking;
    }

    public void clickBookTicket(){
        getBtnBookTicket().click();
    }

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount){
        fillDataBookTicket( departDate, departFrom, arriveAt, seatType, ticketAmount);
        clickBookTicket();
    }

    public List<String> getInfoTicket(){
        List<String> listDataTicket = new ArrayList<>();
        listDataTicket.add(getLblTicketDepartDateData().getText());
        listDataTicket.add(getLblTicketDepartData().getText());
        listDataTicket.add(getLblTicketArriveData().getText());
        listDataTicket.add(getLblTicketSeatTypeData().getText());
        listDataTicket.add(getLblTicketAmountData().getText());
        return listDataTicket;
    }

    public String getBookSuccessfullyMessage(){
        return getLblBookSuccessfullyMessage().getText();
    }

    public String getBookTicketPageTitle(){
        return getLblBookTicketPageTitle().getText();
    }
}
