package testcases.railway;

import common.Constant;
import common.DriverBrowser;
import common.PropertiesFile;
import common.Utilities;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class GeneralTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser){
        System.out.println("Pre-condition");
        DriverBrowser.chooseBrowser(browser);
        PropertiesFile.setPropertiesFile();
        DOMConfigurator.configure("src/main/Resources/log4j.xml");
        Utilities.open();
        Utilities.maximizeBrowser();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
//        Constant.WEBDRIVER.quit();
    }
}
