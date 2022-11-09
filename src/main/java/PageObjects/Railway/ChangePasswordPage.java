package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    // Locators
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@type='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@type='submit']");

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

    // Methods
}
