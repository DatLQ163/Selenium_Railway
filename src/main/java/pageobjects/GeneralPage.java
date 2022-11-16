package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    // Locators
    String tabName = "//span[.= '%s']";

    private final By lblWelcomeMessage = By.xpath("//div[@class ='account']//strong");

    //Elements
    public WebElement getTabMenu(String tabMenu){
        return  Constant.WEBDRIVER.findElement(By.xpath(String.format(tabName,tabMenu)));
    }
    public WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    //Methods
    public void gotoPage(String tabName){
        getTabMenu(tabName).click();
    }
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
}
