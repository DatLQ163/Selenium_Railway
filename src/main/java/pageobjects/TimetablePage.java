package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage{
    // Locators
    private final By rowTicketInfo = By.cssSelector(".MyTable tr:not(.TableSmallHeader)");
    private final By lnkCheckPrice = By.xpath("//a[.= 'check price']");
    private final By lnkBookTicket = By.xpath("//a[.= 'book ticket']");

    // Elements
    private WebElement getRowTicketInfo(){

        return Constant.WEBDRIVER.findElement(rowTicketInfo);
    }
    private WebElement getLnkCheckPrice(){

        return Constant.WEBDRIVER.findElement(lnkCheckPrice);
    }
    private WebElement getLnkBookTicket(){

        return Constant.WEBDRIVER.findElement(lnkBookTicket);
    }

    // Methods
    public void clickBookTicketLink(){
        getLnkBookTicket().click();
    }
}
