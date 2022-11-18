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
    private WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getTxtPassport(){
        return Constant.WEBDRIVER.findElement(txtPassport);
    }

    private WebElement getLblRegisterSuccessfullyMessage(){
        return Constant.WEBDRIVER.findElement(lblRegisterSuccessfullyMessage);
    }

    private WebElement getLblErrorMessage(){
        return Constant.WEBDRIVER.findElement(lblErrMessage);
    }

    private WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    private WebElement getLblValidationMessage(String label){
        return Constant.WEBDRIVER.findElement(lblValidationMessage(label));
    }

    //Methods
    public void fillDataRegister(String email, String password, String confirmPassword , String passport){
        Utilities.scrollToFindElement(getLink());
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPassport().sendKeys(passport);
    }

    public void clickRegister(){
        this.getBtnRegister().click();
    }

    public void register(String email, String password, String confirmPassword, String passport){
        fillDataRegister( email, password, confirmPassword, passport);
        clickRegister();
    }

    public String getRegisterSuccessfullyMessage(){
        return getLblRegisterSuccessfullyMessage().getText();
    }

    public String displayErrorMessage(){
        return getLblErrorMessage().getText();
    }

    public String displayValidationMessage(String label){
        return getLblValidationMessage(label).getText();
    }
}
