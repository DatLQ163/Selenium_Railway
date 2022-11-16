package common;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railwayb2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "quocdat@gmail.com";
    public static final String INVALID_PASSWORD = "abc";
    public static String REGISTER_USERNAME = "Dat" + (int) (Math.random() * 1000) + "@gmail.com";
    public static final String PASSWORD = "123456789";
    public static final String PASSPORT_NUMBER = "abcd1234";
    public static String DEPART_DATE = String.valueOf((int) (Math.random() * 27+4));
}
