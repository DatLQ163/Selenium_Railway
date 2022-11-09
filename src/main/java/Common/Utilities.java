package Common;

import org.openqa.selenium.By;
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

    public static void scrollToFindElement() {
        Actions actions = new Actions(Constant.WEBDRIVER);
        actions.moveToElement(getLink());
        actions.perform();
    }
}
