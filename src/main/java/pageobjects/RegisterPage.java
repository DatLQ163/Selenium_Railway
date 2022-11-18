package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    // Locators
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPassport = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@type='submit']");
    private final By errMessage = By.xpath("//p[@class ='message error']");
    private final By msgRegisterSuccessfully = By.xpath("//div[@id='content']/p");
    private By lblValidation(String label){
      return By.xpath("//label[@class = 'validation-error'][@for ='"+label+"']");
    }

    // Elements
    private WebElement getTxtEmail(){

        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    private WebElement getTxtPassword(){ return Constant.WEBDRIVER.findElement(txtPassword);}
    private WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(txtConfirmPassword);}
    private WebElement getTxtPassport(){ return Constant.WEBDRIVER.findElement(txtPassport);}
    public WebElement getMsgRegisterSuccessfully(){ return Constant.WEBDRIVER.findElement(msgRegisterSuccessfully);}
    public WebElement getLblErrormessage(){ return Constant.WEBDRIVER.findElement(errMessage);}
    private WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(btnRegister);
    }
    public WebElement getLblValidation(String label){return Constant.WEBDRIVER.findElement(lblValidation(label));}

    //Methods
    public void fillDataRegister(String email, String password, String confirmpassword , String passport){
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getTxtPassport().sendKeys(passport);
    }
    public void clickRegister(){
        this.getBtnRegister().click();
    }
}
