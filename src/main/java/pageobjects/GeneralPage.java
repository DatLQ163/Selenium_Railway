package pageobjects;

import common.Constant;
import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage {
    // Locators
    String tabName = "//span[.='%s']";
    private static final By link = By.xpath("//a[.='Web hosting by Somee.com']");
    private final By lblWelcomeMessage = By.xpath("//div[@class ='account']//strong");

    //Elements
    private WebElement getTabMenu(String tabMenu){
        return  Constant.WEBDRIVER.findElement(By.xpath(String.format(tabName,tabMenu)));
    }

    protected static WebElement getLink() {
        return Constant.WEBDRIVER.findElement(link);
    }

    //Methods
    public void gotoPage(String tabName){
        getTabMenu(tabName).click();
    }
}
