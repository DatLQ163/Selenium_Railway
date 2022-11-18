package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By lblLoginPageTitle = By.xpath("//h1[.='Login Page']");
    private final By lblErrLoginMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By lblErrUserNameMessage = By.xpath("//label[@class='validation-error'][contains(text(),'You must specify a username')]");

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

    private WebElement getLblLoginPageTitle(){
        return Constant.WEBDRIVER.findElement(lblLoginPageTitle);
    }

    private WebElement getLblErrUserNameMessage(){
        return Constant.WEBDRIVER.findElement(lblErrUserNameMessage);
    }

    private WebElement getMsgErrorLogin(){
        return Constant.WEBDRIVER.findElement(lblErrLoginMessage);
    }

    // Method
    public void fillDataLogin(String username, String password){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
    }

    public void clickLogin(){
        getBtnLogin().click();
    }

    public void login(String username, String password){
        fillDataLogin(username, password);
        clickLogin();
    }

    public String getLoginErrorMessage(){
        return getMsgErrorLogin().getText();
    }

    public String displayLoginPageTitle(){
        return getLblLoginPageTitle().getText();
    }
}
