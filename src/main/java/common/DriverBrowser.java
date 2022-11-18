package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverBrowser {
    public static void chooseBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "executables/chromedriver.exe");
            Constant.WEBDRIVER = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "executables/geckodriver.exe");
            Constant.WEBDRIVER = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", Utilities.getProjectPath() + "executables/msedgedriver.exe");
            Constant.WEBDRIVER = new EdgeDriver();
        }
    }
}
