package testcases.railway;

import common.Constant;
import common.DriverManager;
import common.PropertiesFile;
import common.Utilities;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;

public class GeneralTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser){
        System.out.println("Pre-condition");
        DriverManager.chooseBrowser(browser);
        PropertiesFile.setPropertiesFile();
        DOMConfigurator.configure("src/main/Resources/log4j.xml");
        DriverManager.maximizeBrowser();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
