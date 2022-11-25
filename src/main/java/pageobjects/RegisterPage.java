package pageobjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    // Locators
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPassport = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@type='submit']");
    private final By lblErrMessage = By.xpath("//p[@class='message error']");
    private final By lblRegisterSuccessfullyMessage = By.xpath("//div[@id='content']/p");
    private By lblValidationMessage(String label){
      return By.xpath("//label[@class='validation-error'][@for='"+label+"']");
    }

    // Elements

    //Methods
}
