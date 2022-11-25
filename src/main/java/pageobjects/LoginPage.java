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

    // Method
}
