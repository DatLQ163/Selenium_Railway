package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    // Locators
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@type='submit']");
    private final By lblChangePasswordSuccessfullyMessage = By.xpath("//p[@class='message success']");
    private final By lblChangePasswordPageTitle = By.xpath("//h1[.='Change password']");

    // Elements
    private WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword(){
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    private WebElement getLblChangePasswordPageTitle(){
        return Constant.WEBDRIVER.findElement(lblChangePasswordPageTitle);
    }

    private WebElement getLblChangePasswordSuccessfullyMessage(){
        return Constant.WEBDRIVER.findElement(lblChangePasswordSuccessfullyMessage);
    }

    // Methods
    public void fillDataChangePassword(String currentPassword, String newPassword, String confirmPassword){
        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(confirmPassword);
    }

    public void clickChangePassword(){
        getBtnChangePassword().click();
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword){
        fillDataChangePassword(currentPassword, newPassword, confirmPassword);
        clickChangePassword();
    }

    public String displayChangePasswordSuccessfullyMessage(){
        return getLblChangePasswordSuccessfullyMessage().getText();
    }

    public boolean displayChangePasswordPageTitle(){
        return getLblChangePasswordPageTitle().isDisplayed();
    }
}
