package pageobjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyTicketPage extends GeneralPage{
    // Locators
    private String btnCancelWithRow = "//td[.='%s']/..//input[@value='Delete' or @value='Cancel']";
    private String rowSelected = "//input[@onclick='%s']/../..";
    private static final By rowTotalDisplayOnFilterTable = By.xpath("//table[@class ='MyTable']//tr[not (contains(@class, 'TableSmallHeader'))]");
    static String rowFilterDisplayOnMyTicketTable = "//td[count(//th[.='Depart Station']//preceding-sibling::th)+1][contains(text(),'%s')]/..";
    static String rowFilterDisplayOnFilterTable = "//td[count(//th[.='Depart Station']//preceding-sibling::th)+1][contains(text(),'%s')]/..";
    private final By ddlDepart = By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']");
    private final By ddlArrive = By.xpath("//div[@class='Filter']//select[@name='FilterArStation']");
    private final By textDate = By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']");
    private final By ddlStatus = By.xpath("//div[@class='Filter']//select[@name='FilterStatus']");
    private final By btnFilter = By.xpath("//div[@class='Filter']//input[@type='submit']");
    private final By lblFilterNotFoundMessage = By.xpath("//div[@class='error message']");

    // Elements
    private static List<WebElement> getRowTotalDisplayOnFilterTable(){
        return Constant.WEBDRIVER.findElements(rowTotalDisplayOnFilterTable);
    }

    private static List<WebElement> getRowFilterDisplayOnMyTicketTable(String departStation){
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(rowFilterDisplayOnMyTicketTable,departStation)));
    }

    private static List<WebElement> getRowFilterDisplayOnFilterTable(String departStation){
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(rowFilterDisplayOnFilterTable,departStation)));
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

    private WebElement getLblFilterNotFoundMessage(){
        return Constant.WEBDRIVER.findElement(lblFilterNotFoundMessage);
    }

    // Methods
    public Integer countRowFilterDisplayOnMyTicketTable(String depart){
        return getRowFilterDisplayOnMyTicketTable(depart).size();
    }

    public Integer countRowFilterDisplayOnFilterTable(String depart){
        return getRowFilterDisplayOnFilterTable(depart).size();
    }

    public Integer countRowTotalDisplayOnFilterTable(){
        return getRowTotalDisplayOnFilterTable().size();
    }

    public void fillFilterDepartStation(String departStation){
        Utilities.scrollByJavaScript();
        Select dropDepartStation = new Select(getDdlDepart());
        dropDepartStation.selectByVisibleText(departStation);
    }

    public void fillFilterStatus(String status){
        Utilities.scrollByJavaScript();
        Select dropDepartStatus = new Select(getDdlStatus());
        dropDepartStatus.selectByVisibleText(status);
    }

    public void clickFilterButton(){
        getBtnFilter().click();
    }

    public void filter(String departStation){
        fillFilterDepartStation(departStation);
        clickFilterButton();
    }

    public boolean checkFilter(int filterMyTicketPage, int filterFilterPage){
        if(filterMyTicketPage == filterFilterPage){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkTotal(int filterFilterPage, int totalFilterPage){
        if(totalFilterPage == filterFilterPage){
            return true;
        }else{
            return false;
        }
    }

    public String displayMessageFilterNotFound(){
        return getLblFilterNotFoundMessage().getText();
    }
}
