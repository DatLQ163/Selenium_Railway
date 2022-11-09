package PageObjects.Railway;

import Common.Utilities;
import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    // Locators
    private final By selDepartDate = By.xpath("//select[@name ='Date']");
    private final By selDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By selArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private final By selSeatType = By.xpath("//select[@name ='SeatType']");
    private final By selTicketAmount = By.xpath("//select[@name ='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By msgBookSuccessfully = By.xpath("//div/h1");
    private final By infoTicketDepart = By.xpath("//table//td[count(//th[.='Depart Station']/preceding-sibling::th)+1]");
    private final By infoTicketArrive = By.xpath("//table//td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]");
    private final By infoTicketSeatType = By.xpath("//table//td[count(//th[.='Seat Type']/preceding-sibling::th)+1]");
    private final By infoTicketDepartDate = By.xpath("//table//td[count(//th[.='Depart Date']/preceding-sibling::th)+1]");
    private final By infoTicketAmount = By.xpath("//table//td[count(//th[.='Amount']/preceding-sibling::th)+1]");

    // Elements
    private WebElement getSelDepartDate() {

        return Constant.WEBDRIVER.findElement(selDepartDate);
    }

    private WebElement getSelDepartFrom() {

        return Constant.WEBDRIVER.findElement(selDepartFrom);
    }

    private WebElement getSelArriveAt() {

        return Constant.WEBDRIVER.findElement(selArriveAt);
    }

    private WebElement getMsgBookSuccessfully() {

        return Constant.WEBDRIVER.findElement(msgBookSuccessfully);
    }

    private WebElement getSelSeatType() {
        return Constant.WEBDRIVER.findElement(selSeatType);
    }

    private WebElement getSelTicketAmount() {
        return Constant.WEBDRIVER.findElement(selTicketAmount);
    }

    private WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    private WebElement getInfoTicketDepart() {
        return Constant.WEBDRIVER.findElement(infoTicketDepart);
    }

    private WebElement getInfoTicketArrive() {
        return Constant.WEBDRIVER.findElement(infoTicketArrive);
    }

    private WebElement getInfoTicketSeatType() {
        return Constant.WEBDRIVER.findElement(infoTicketSeatType);
    }

    private WebElement getInfoTicketDepartDate() {
        return Constant.WEBDRIVER.findElement(infoTicketDepartDate);
    }

    private WebElement getInfoTicketAmount() {
        return Constant.WEBDRIVER.findElement(infoTicketAmount);
    }

    // Methods

    public void bookTicket() {

        Utilities.scrollToFindElement();
        String[] optionBooking = new String[5];
        Select dropDepartDate = new Select(getSelDepartDate());
        Select dropDepartFrom = new Select(getSelDepartFrom());
        Select dropArriveAt = new Select(getSelArriveAt());
        Select dropSeatType = new Select(getSelSeatType());
        Select dropTicketAmount = new Select(getSelTicketAmount());
        dropDepartDate.selectByIndex(3);
        dropDepartFrom.selectByIndex(3);
        dropArriveAt.selectByIndex(3);
        dropSeatType.selectByIndex(3);
        dropTicketAmount.selectByIndex(1);
        this.getBtnBookTicket().click();
    }

    public String getMsgBook() {
        return this.getMsgBookSuccessfully().getText();
    }

    public void verifyBooking() {
//        System.out.println(dropDepartFrom.getOptions().get(3).getText());

//        Select dropDepartDate = new Select(getSelDepartDate());
//        Select dropDepartFrom = new Select(getSelDepartFrom());
//        Select dropArriveAt = new Select(getSelArriveAt());
//        Select dropSeatType = new Select(getSelSeatType());
//        Select dropTicketAmount = new Select(getSelTicketAmount());
//        String[] optionBooking = new String[5];
//        optionBooking[0] = dropDepartFrom.getOptions().get(3).getText();
//        optionBooking[1] = dropArriveAt.getOptions().get(3).getText();
//        optionBooking[2] = dropSeatType.getOptions().get(3).getText();
//        optionBooking[3] = dropTicketAmount.getOptions().get(3).getText();
//        optionBooking[4] = dropDepartDate.getOptions().get(3).getText();
//        String[] optionTicket = new String[5];
//        optionTicket[0] = getInfoTicketDepart().getText();
//        optionTicket[1] = getInfoTicketArrive().getText();
//        optionTicket[2] = getInfoTicketSeatType().getText();
//        optionTicket[3] = getInfoTicketAmount().getText();
//        optionTicket[4] = getInfoTicketDepartDate().getText();
//
//        System.out.println(optionTicket[0]);
//        for (int i =0; i <5;i++){
//            Assert.assertEquals(optionBooking[i],optionTicket[i]);
//        }
    }
}
