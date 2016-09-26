import helpers.Account;
import helpers.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 9/23/2016.
 */
public class Testwith2account {
    protected WebDriver driver;
    String Subject = Random.getRandomSubject();

    @Test
    public void run3() {
        String emailto = "neman2016@tut.by";
        String passwordto = "avtotest_2016";
        final String emailfrom = "ncremo01@tut.by";
        final String passwordfrom = "avtotest_2016";


        WebDriver driver = new FirefoxDriver();

        driver.get("https://mail.tut.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage.login(driver, emailfrom, passwordfrom);
        Account acc1 = new Account(emailfrom, passwordfrom);
        Account acc2 = new Account(emailto, passwordto);

        SendLetter.send(Subject, acc1, acc2);
        AssertSendPage.checkSent(driver, Subject, acc1);
        LogOutPage.exitstatus(driver);
        driver.quit();

        WebDriver driver2 = new FirefoxDriver();
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver2.get("http://mail.tut.by/");
        LoginPage.login(driver2, emailto, passwordto);
        AssertInboxPage.checkInbox(driver2, Subject, acc2);

        driver.quit();
    }
}
