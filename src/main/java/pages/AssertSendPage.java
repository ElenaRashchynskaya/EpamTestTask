package pages;

import helpers.Account;
import helpers.Locators;
import helpers.Screenshot;
import helpers.Waiters;
import helpers.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/22/2016.
 */
public class AssertSendPage {

    private static Logger log = Logger.getLogger("testLog");

    public static final By SEND_LINK = Locators.get("SendLink");

    public static final By CONFIRMATION_SEND_LETTER = Locators.get("ConfirmationSendLetter");

    public static void checkSent(WebDriver driver, String expectedSubject, Account account) {
        try {
            log.info(">checkSent expectedSubject:" + expectedSubject);
            Waiters.waitForPageLoaded();
            WebElement sentButton = driver.findElement(SEND_LINK);
            sentButton.click();
            Waiters.waitForPageLoaded();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Waiters.waitForJquery();
            Assert.assertEquals(driver.findElements(CONFIRMATION_SEND_LETTER).get(0).getText(), expectedSubject);

            //new Screenshot(driver, expectedSubject, "sent");
            Reporter.pass(account.email);
        } catch (Throwable e) {
            new Screenshot(driver, expectedSubject, "sent_FAILED");
            log.warning("FAILED: test check folder sent: " + e.getMessage());
            Reporter.fail(account.email, "check folder sent: " + e.getMessage());
            //ex.printStackTrace();
        }
    }
}
