package Common;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAYURL = "http://railwayb2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "quocdat@gmail.com";
    public static final String INVALIDUSERNAME = "abc";
    public static final String REGISTERUSERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
    public static final String PASSWORD = "123456789";
    public static final String CONFIRMPASSWORD = "123456789";
    public static final String PASSPORTNUMBER = "abcd1234";
    public static final int DEPART_DATE = (int) (Math.random() * 31 + 27);
}
