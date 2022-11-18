package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                System.out.println("no browser type be found");
        }
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void maximizeBrowser(){
        Constant.WEBDRIVER.manage().window().maximize();
    }
}
