package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimetablePage {
    WebDriver driver = new ChromeDriver();
    // Locators
    private final By rowTicketInfo = By.cssSelector(".MyTable tr:not(.TableSmallHeader)");
    private final By lkCheckPrice = By.xpath("//a[.= 'check price']");
    private final By lkBookTicket = By.xpath("//a[.= 'book ticket']");

    // Elements
    private WebElement getRowTicketInfo(){

        return Constant.WEBDRIVER.findElement(rowTicketInfo);
    }
    private WebElement getLkCheckPrice(){

        return Constant.WEBDRIVER.findElement(lkCheckPrice);
    }
    private WebElement getLkBookTicket(){

        return Constant.WEBDRIVER.findElement(lkBookTicket);
    }

    // Methods
    public void checkLink(){

    }
}
