package pageobjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{
    // Locators
    private String btnCancelWithRow = "//td[.='%s']/..//input[@value='Delete' or @value='Cancel']";
    private String rowSelected = "//input[@onclick='%s']/../..";
    private final By ddlDepart = By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']");
    private final By ddlArrive = By.xpath("//div[@class='Filter']//select[@name='FilterArStation']");
    private final By textDate = By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']");
    private final By ddlStatus = By.xpath("//div[@class='Filter']//select[@name='FilterStatus']");
    private final By btnFilter = By.xpath("//div[@class='Filter']//input[@type='submit']");
    private final By titleMyTicketPage = By.xpath("//h1[.='Manage Tickets']");

    // Elements

    // Methods
}
