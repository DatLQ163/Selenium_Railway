package testcases.railway;

import common.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;

public class GeneralTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser){
        Log.info("Pre-condition");
        DriverManager.chooseBrowser(browser);
        PropertiesFile.setPropertiesFile();
        DOMConfigurator.configure("src/main/Resources/log4j.xml");
        DriverManager.maximizeBrowser();
    }

    @AfterMethod
    public void afterMethod(){
        Log.info("Post-condition");
//        Constant.WEBDRIVER.quit();
    }
}
