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

    // Methods
}
