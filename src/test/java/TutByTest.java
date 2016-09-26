import helpers.Account;
import helpers.Random;
import helpers.ReadXMLFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Created by Lenovo on 9/23/2016.
 */
public class TutByTest {
    protected WebDriver driver;
    private static Logger log = Logger.getLogger("testLog");

    String Subject = Random.getRandomSubject();

    @Test
    public void run() {
        log.info("----------------------------");
        log.info("Read data from:");

        List<Account> accountList = ReadXMLFile.run();


        //     for (int current = 0; current < 1; current++) {
        for (int current = 0; current < accountList.size(); current++) {

            log.info("=================================");
            String Subject = Random.getRandomSubject();
            int next = current + 1;
            if (next >= accountList.size()) {
                next = 0;
            }
            Account accountFrom = accountList.get(current);
            Account accountTo = accountList.get(next);
            log.info("Sending letter From:#" + current + ": " + accountFrom.toString() + " To:#" + next + ":" + accountTo.toString());
            //Check letter
            driver = new FirefoxDriver();
            driver.get("https://mail.tut.by/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            LoginPage.login(driver, accountFrom.email, accountFrom.password);

            SendLetter.send(Subject, accountFrom, accountTo);
            AssertSendPage.checkSent(driver, Subject, accountFrom);
            LogOutPage.exitstatus(driver);

            driver.get("https://mail.tut.by/");
            LoginPage.login(driver, accountTo.email, accountTo.password);
            AssertInboxPage.checkInbox(driver, Subject, accountTo);
            driver.close();
            log.info("=================================");
        }
    }


}

