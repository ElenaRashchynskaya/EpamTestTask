package helpers;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SendLetter;
import report.TestBase;

/**
 * Created by Lenovo on 9/24/2016.
 */
public class Waiters {
    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").
                                toString().equals("complete");
                    }
                };

        }

    public static void waitForJquery() throws InterruptedException {
        (new WebDriverWait(TestBase.getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor)webDriver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
        Thread.sleep(500);
    }
}






