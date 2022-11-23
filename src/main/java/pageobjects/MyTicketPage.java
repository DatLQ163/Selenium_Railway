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
    private WebElement getBtnCancelWithRow(String rowNumber){
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

    private WebElement getTextDate(){
        return Constant.WEBDRIVER.findElement(textDate);
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
    public void cancelTicket(String rowNumber){
        Utilities.scrollToFindElement(getLink());
        getBtnCancelWithRow(rowNumber).click();
    }

    public void clickOkAlert(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public String getCancelId(String rowNumber){
        return getBtnCancelWithRow(rowNumber).getAttribute("onclick");
    }

    private WebElement selectRowWillBeCanceled(String cancelId){
        return getRowSelected(cancelId);
    }

    public Boolean checkRowBeCanceled (String cancelId){
        try{
            selectRowWillBeCanceled(cancelId);
            return false;
        }
        catch(Exception e){
            return true;
        }
    }

    public boolean displayMyTicketTitle(){
        return getTitleMyTicketPage().isDisplayed();
    }
}
