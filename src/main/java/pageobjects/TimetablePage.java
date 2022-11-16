package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TimetablePage extends GeneralPage{
    // Locators
    private final By ddlDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By ddlArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private final By rowTicketInfo = By.cssSelector(".MyTable tr:not(.TableSmallHeader)");
    String lnkCheckPrice = "//td[count(//th[.='Depart Station'])+1][.='%s']/../td[count(//th[.='Arrive Station'])+2][.='%s']/..//a[.='check price']";
    String lnkBookTicket = "//td[count(//th[.='Depart Station'])+1][.='%s']/../td[count(//th[.='Arrive Station'])+2][.='%s']/..//a[.='book ticket']";

    // Elements
    private WebElement getDdlDepartFrom() { return Constant.WEBDRIVER.findElement(ddlDepartFrom);}
    private WebElement getDdlArriveAt() { return Constant.WEBDRIVER.findElement(ddlArriveAt);}
    private WebElement getRowTicketInfo(){

        return Constant.WEBDRIVER.findElement(rowTicketInfo);
    }
    private WebElement getLnkCheckPrice(String depart, String arrive){

        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice,depart,arrive)));
    }
    private WebElement getLnkBookTicket(String depart, String arrive){

        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkBookTicket,depart,arrive)));
    }

    // Methods
    public void clickBookTicketLink(String depart, String arrive){
        getLnkBookTicket(depart,arrive).click();
    }
    public void clickCheckPriceLink(String depart, String arrive){
        getLnkCheckPrice(depart,arrive).click();
    }
    public List<String> getDataChoose(String depart, String arrive){
        List<String> listDataChoose = new ArrayList<>();
        listDataChoose.add(depart);
        listDataChoose.add(arrive);
        return listDataChoose;
    }
    public List<String> getDataBooking(){
        List<String> listDataBooking = new ArrayList<>();
        Select dropDepartFrom = new Select(getDdlDepartFrom());
        Select dropArriveAt = new Select(getDdlArriveAt());
        listDataBooking.add(dropDepartFrom.getFirstSelectedOption().getText());
        listDataBooking.add(dropArriveAt.getFirstSelectedOption().getText());
        return listDataBooking;
    }
}
