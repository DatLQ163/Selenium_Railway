package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By titleLoginPage = By.xpath("//h1[.='Login Page']");
    private final By msgErrLogin = By.xpath("//p[@class = 'message error LoginForm']");
    private final By msgErrUserName = By.xpath("//label[@class ='validation-error'][contains(text(),'You must specify a username')]");

    // Elements
    private WebElement getTxtUsername(){

        return Constant.WEBDRIVER.findElement(txtUsername);
    }
    private WebElement getTxtPassword(){

        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    private WebElement getBtnLogin(){

        return Constant.WEBDRIVER.findElement(btnLogin);
    }
    private WebElement getTitleLoginPage(){
        return Constant.WEBDRIVER.findElement(titleLoginPage);
    }
    private WebElement getMsgErrUserName(){

        return Constant.WEBDRIVER.findElement(msgErrUserName);
    }
    private WebElement getMsgErrorLogin(){
        return Constant.WEBDRIVER.findElement(msgErrLogin);
    }

    // Method
    public void fillDataLogin(String username, String password){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
    }
    public void clickLogin(){
        getBtnLogin().click();
    }
    public String getLoginErrorMessage(){
        return getMsgErrorLogin().getText();
    }
    public String displayLoginPageTitle(){
        return getTitleLoginPage().getText();
    }
}
