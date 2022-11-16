package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities {
    private static final By link = By.xpath("//a[.='Web hosting by Somee.com']");

    private static WebElement getLink() {
        return Constant.WEBDRIVER.findElement(link);
    }

    public static String getProjectPath() {
        return "src/main/java/";
    }

    public static void scrollToFindElement(){
        Actions actions = new Actions(Constant.WEBDRIVER);
        actions.moveToElement(getLink());
        actions.perform();
    }
    public static void scrollByJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");
    }
    public static void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
    public static void maximizeBrowser(){
        Constant.WEBDRIVER.manage().window().maximize();
    }
}
