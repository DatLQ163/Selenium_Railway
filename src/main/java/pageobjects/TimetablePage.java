package pageobjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TimetablePage extends GeneralPage{
    // Locators
    private final By rowTicketInfo = By.cssSelector(".MyTable tr:not(.TableSmallHeader)");
    String lnkCheckPrice = "//td[count(//th[.='Depart Station'])+1][.='%s']/../td[count(//th[.='Arrive Station'])+2][.='%s']/..//a[.='check price']";
    String lnkBookTicket = "//td[count(//th[.='Depart Station'])+1][.='%s']/../td[count(//th[.='Arrive Station'])+2][.='%s']/..//a[.='book ticket']";

    // Elements

    // Methods
}
