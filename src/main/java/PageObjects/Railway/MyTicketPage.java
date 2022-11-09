package PageObjects.Railway;

import Common.Utilities;
import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    // Locators
    private final By btnDeleteCancel = By.xpath("//input[@value='Delete' or @value = 'Cancel']");
    private final By lblRow = By.xpath("//table[@class = 'MyTable']//following::tr[@class!='TableSmallHeader']");
    private final By fltDepart = By.xpath("//div[@class = 'Filter']//select[@name ='FilterDpStation']");
    private final By fltArrive = By.xpath("//div[@class = 'Filter']//select[@name ='FilterArStation']");
    private final By fltDate = By.xpath("//div[@class = 'Filter']//input[@name ='FilterDpDate']");
    private final By fltStatus = By.xpath("//div[@class = 'Filter']//select[@name ='FilterStatus']");
    private final By btnFilter = By.xpath("//div[@class = 'Filter']//input[@type='submit']");

    // Elements
    private WebElement getBtnDeleteCancel(){

        return Constant.WEBDRIVER.findElement(btnDeleteCancel);
    }
    private WebElement getLblRow() {

        return Constant.WEBDRIVER.findElement(lblRow);
    }
    private WebElement getFltDepart(){
        return Constant.WEBDRIVER.findElement(fltDepart);
    }
    private WebElement getFltArrive(){
        return Constant.WEBDRIVER.findElement(fltArrive);
    }
    private WebElement getFltDate(){
        return Constant.WEBDRIVER.findElement(fltDate);
    }
    private WebElement getFltStatus(){
        return Constant.WEBDRIVER.findElement(fltStatus);
    }
    private WebElement getBtnFilter(){
        return Constant.WEBDRIVER.findElement(btnFilter);
    }

    // Methods
    // Filter
    Select dropFilterDepart = new Select(getFltDepart());
    Select dropFilterArrive = new Select(getFltArrive());
    Select dropFilterStatus = new Select(getFltStatus());
    public void filter(String date){
        Utilities.scrollToFindElement();
        dropFilterDepart.selectByIndex(1);
        dropFilterArrive.selectByIndex(2);
        getFltDate().sendKeys(date);
        dropFilterStatus.selectByIndex(2);
        getBtnFilter().click();
    }
    // get value
    String[] filterValue = new String[4];
    public void getFilterValue (String date){
        filterValue[0] = dropFilterDepart.getOptions().get(1).getText();
        filterValue[1] = dropFilterArrive.getOptions().get(2).getText();
        filterValue[2] = date;
        filterValue[3] = dropFilterStatus.getOptions().get(2).getText();
    }
}
