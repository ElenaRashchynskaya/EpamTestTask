package report;

import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 9/24/2016.
 */
public class TestBase {
    public static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();//driver for each potoc

    public static WebDriver getDriver(){
        return DRIVER.get();
    }
}
