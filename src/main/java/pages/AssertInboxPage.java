package pages;

import helpers.Account;
import helpers.Locators;
import helpers.Screenshot;
import helpers.Waiters;
import helpers.reporting.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

import static org.openqa.selenium.OutputType.*;

/**
 * Created by Lenovo on 9/22/2016.
 */
public class AssertInboxPage {


    private static Logger log = Logger.getLogger("testLog");
    public static final By ENTRANCE_LINK = Locators.get("entrance");
    public static final By CONFIRMATION_INPUT_LETTER = Locators.get("inputLettersSubjects");


    public static void checkInbox(WebDriver driver, String expectedSubject, Account account) {
        try {
            log.info(">checkInbox expectedSubject:" + expectedSubject);
            Waiters.waitForPageLoaded();
            WebElement entranceButton = driver.findElement(ENTRANCE_LINK);
            entranceButton.click();

            Waiters.waitForPageLoaded();

            Assert.assertEquals(driver.findElements(CONFIRMATION_INPUT_LETTER).get(0).getText(), expectedSubject);

            //new Screenshot(driver, expectedSubject, "inbox");
            Reporter.pass(account.email);
        } catch (Throwable e) {
            new Screenshot(driver, expectedSubject, "inbox_FAILED");
            log.warning("FAILED: test check folder inbox: " + e.getMessage());
            Reporter.fail(account.email, "check folder inbox:" + e.getMessage());
        }

    }
}
