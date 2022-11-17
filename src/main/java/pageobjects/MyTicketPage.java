package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyTicketPage {
    // Locators
//    private String btnCancelWithRow = "//input[@onclick ='DeleteTicket(%s);']";
    private String btnCancelWithRow = "//td[.='%s']/..//input[@value='Delete' or @value = 'Cancel']";
    private String rowSelected = "//input[@onclick ='%s']/../..";
    private final By ddlDepart = By.xpath("//div[@class = 'Filter']//select[@name ='FilterDpStation']");
    private final By ddlArrive = By.xpath("//div[@class = 'Filter']//select[@name ='FilterArStation']");
    private final By ddlDate = By.xpath("//div[@class = 'Filter']//input[@name ='FilterDpDate']");
    private final By ddlStatus = By.xpath("//div[@class = 'Filter']//select[@name ='FilterStatus']");
    private final By btnFilter = By.xpath("//div[@class = 'Filter']//input[@type='submit']");
    private final By titleMyTicketPage = By.xpath("//h1[.='Manage Tickets']");

    // Elements
    public WebElement getBtnCancelWithRow(String rowNumber){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelWithRow,rowNumber)));
    }
    private WebElement getRowSelected(String cancelId) {

        return Constant.WEBDRIVER.findElement(By.xpath(String.format(rowSelected,cancelId)));
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

    //Cancel
    public void cancelTicket(String rowNumber){
        getBtnCancelWithRow(rowNumber).click();
    }
    public void clickOkAlert(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public String getCancelId(String rowNumber){
        return getBtnCancelWithRow(rowNumber).getAttribute("onclick");
    }
    public WebElement selectRowWillBeCanceled(String cancelId){
        return getRowSelected(cancelId);
    }
    public Boolean checkRowBeCanceled (WebElement element){
            try{
                element.isDisplayed();
                return false;
            }
            catch(Exception e){
                return true;
            }
    }
    public boolean displayMyTicketTitle(){
        return getTitleMyTicketPage().isDisplayed();
    }
//    public void waitForVisible(){
//    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
//    WebElement element = wait.until(
//            ExpectedConditions.visibilityOfElementLocated(By.id("someid")));
//    }
}
