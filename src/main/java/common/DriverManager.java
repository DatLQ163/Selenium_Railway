package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    public static void chooseBrowser(String browser) {
        browser.equalsIgnoreCase(browser);
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "executables/chromedriver.exe");
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "executables/geckodriver.exe");
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", Utilities.getProjectPath() + "executables/msedgedriver.exe");
                Constant.WEBDRIVER = new EdgeDriver();
                break;
            default:
                throw new NullPointerException("no browser type is found");
        }
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void maximizeBrowser(){
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void waitForClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER,3); //20 seconds
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Constant.WEBDRIVER.findElement((By) element).click();
    }

//    public void implicitWait() {
//        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//    }
}
