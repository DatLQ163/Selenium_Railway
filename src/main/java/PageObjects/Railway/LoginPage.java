package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    // Locators
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By lblErrormessage = By.xpath("//label[@class='validation-error']");

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
    private WebElement getLblErrormessage(){
        return Constant.WEBDRIVER.findElement(lblErrormessage);
    }

    // Methods dung void
    public void login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }
}
