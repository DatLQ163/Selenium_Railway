package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    // Locators
    private String btnCancelWithRowNumber = "//td[.='%s']/..//input[@value='Delete' or @value = 'Cancel']";
    private final By row = By.xpath("//table[@class = 'MyTable']//following::tr[@class!='TableSmallHeader']");
    private final By ddlDepart = By.xpath("//div[@class = 'Filter']//select[@name ='FilterDpStation']");
    private final By ddlArrive = By.xpath("//div[@class = 'Filter']//select[@name ='FilterArStation']");
    private final By ddlDate = By.xpath("//div[@class = 'Filter']//input[@name ='FilterDpDate']");
    private final By ddlStatus = By.xpath("//div[@class = 'Filter']//select[@name ='FilterStatus']");
    private final By btnFilter = By.xpath("//div[@class = 'Filter']//input[@type='submit']");
    private final By titleMyTicketPage = By.xpath("//h1[.='Manage Tickets']");

    // Elements
    public WebElement getBtnCancelWithRow(String rowNumber){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelWithRowNumber,rowNumber)));
    }
    private WebElement getRow() {

        return Constant.WEBDRIVER.findElement(row);
    }
    private WebElement getDdlDepart(){

        return Constant.WEBDRIVER.findElement(ddlDepart);
    }
    private WebElement getDdlArrive(){

        return Constant.WEBDRIVER.findElement(ddlArrive);
    }
    private WebElement getDdlDate(){

        return Constant.WEBDRIVER.findElement(ddlDate);
    }
    private WebElement getDdlStatus(){

        return Constant.WEBDRIVER.findElement(ddlStatus);
    }
    private WebElement getBtnFilter(){

        return Constant.WEBDRIVER.findElement(btnFilter);
    }
    private WebElement getTitleMyTicketPage(){

        return Constant.WEBDRIVER.findElement(titleMyTicketPage);
    }

    // Methods
    // Filter

    public void fillDataFilter(String date){
        Select dropFilterDepart = new Select(getDdlDepart());
        Select dropFilterArrive = new Select(getDdlArrive());
        Select dropFilterStatus = new Select(getDdlStatus());
        dropFilterDepart.selectByIndex(1);
        dropFilterArrive.selectByIndex(2);
        getDdlDate().sendKeys(date);
        dropFilterStatus.selectByIndex(2);
    }
    public void clickFilter(){
        getBtnFilter().click();
    }
    public void cancelTicket(String rowNumber){
        getBtnCancelWithRow(rowNumber).click();
    }
    public void clickOkAlert(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public boolean displayMyTicketTitle(){
        return getTitleMyTicketPage().isDisplayed();
    }
}
