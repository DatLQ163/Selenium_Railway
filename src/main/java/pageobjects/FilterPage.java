package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends GeneralPage{
    // locators
    private final By ddlDepart = By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']");
    private final By ddlArrive = By.xpath("//div[@class='Filter']//select[@name='FilterArStation']");
    private final By textDate = By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']");
    private final By ddlStatus = By.xpath("//div[@class='Filter']//select[@name='FilterStatus']");
    private final By btnFilter = By.xpath("//div[@class='Filter']//input[@type='submit']");
    String dblFilter = "//td[.='%s']//following-sibling::td[.='%s']//following-sibling::td[.='%s']//following-sibling::td[.='%s']";


    // elements
    private WebElement getDblFilter(String departStation, String arriveStation, String departDate, String status){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblFilter,departStation,arriveStation,departDate,status)));
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

    // methods

    public void fillFilterData(String departStation, String arriveStation, String departDate, String status){
        Select dropDepartStation = new Select(getDdlDepart());
        Select dropArriveStation = new Select(getDdlArrive());
        Select dropStatus = new Select(getDdlStatus());
        dropDepartStation.selectByVisibleText(departStation);
        dropArriveStation.selectByVisibleText(arriveStation);
        getTextDate().sendKeys(departDate);
        dropStatus.selectByVisibleText(status);
    }

    public List<String> getInfoFilter(){
        Select dropDepartStation = new Select(getDdlDepart());
        Select dropArriveStation = new Select(getDdlArrive());
        Select dropStatus = new Select(getDdlStatus());
        List<String> listInfoFilter = new ArrayList<>();
        listInfoFilter.add(dropDepartStation.getFirstSelectedOption().getText());
        listInfoFilter.add(dropArriveStation.getFirstSelectedOption().getText());
        listInfoFilter.add(getTextDate().getText());
        listInfoFilter.add(dropStatus.getFirstSelectedOption().getText());
        return listInfoFilter;
    }

    public void clickFilterButton(){
        getBtnFilter().click();
    }
}
