package pages;

import com.sun.mail.imap.protocol.FLAGS;
import helpers.Account;
import helpers.Random;
import helpers.reporting.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Created by Lenovo on 9/22/2016.
 */
public class SendLetter {
    private static Logger log = Logger.getLogger("testLog");

    public static void send(String expectedSubject, final Account accountFrom, Account accountTo) {


        final String host = "smtp.yandex.ru";
        log.fine("SMTP server");
        int port = 465;
        log.fine("get session");
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        log.fine("debug");
        //props.put("mail.debug", "true");
        log.fine("avtorization");
        javax.mail.Session session = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountFrom.email, accountFrom.password);
            }
        });
        try {
            log.info("Letter send - Start");
            log.fine("create message");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(accountFrom.email));
            InternetAddress[] address = {new InternetAddress(accountTo.email)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(expectedSubject);
            message.setSentDate(new Date());


            //msg.setFlag(FLAGS.Flag.RECENT, true);

            message.setText(new Date().toString() + ": this test letter emailfrom " + accountFrom.email + " to " + accountTo.email + " UUID " + UUID.randomUUID().toString());
            log.info("Subject: [" + message.getSubject() + "]:: " + message.getContent().toString());
            log.fine("Sending letter");
            javax.mail.Transport.send(message);
            log.info("Letter send - PASS");


            //   Copy message to "Sent Items" folder as read
            /*
            log.info("----------------------------");
            log.fine("Copy message to \"Sent Items\" folder as read");
            log.info("Letter copy to INBOX - Start");
            Properties propsImap = new Properties();
            //    propsImap.put("mail.debug", "true");
            log.fine("IMAP с SSL protocol");
            propsImap.put("mail.store.protocol", "imaps");
            javax.mail.Session sessionIMAP = javax.mail.Session.getInstance(propsImap, null);
            Store store = sessionIMAP.getStore();
            log.fine("connect with post server");
            store.connect("imap.yandex.ru", accountFrom.email, accountFrom.password);
            log.fine("STARTS Copy message to \"Sent Items\" folder as read");
            Folder folder = (Folder) store.getFolder("Отправленные");
            if (!folder.exists()) {
                folder.create(Folder.HOLDS_MESSAGES);
            }
            folder.open(Folder.READ_WRITE);
            log.info("appending...");
            try {

                folder.appendMessages(new Message[]{message});
                message.setFlag(FLAGS.Flag.RECENT, true);
                log.info("Letter copy to INBOX - PASS");
            } catch (Exception e) {
                log.info("error processing message " + e.getMessage());
                Reporter.report(accountFrom.email, false, e.getMessage());
            } finally {
                store.close();
            }
            */

            log.info("Letter send and saved ....");
            log.fine("END Copy message to \"Sent Items\" folder as read");

            Reporter.pass(accountFrom.email);
        } catch (MessagingException e) {
            log.warning("Sending letter Error: " + e.getMessage());
            Reporter.fail(accountFrom.email, "Sending letter Error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            log.info("");
        }
    }

    public static void LettersSend(List<Account> accountList) {
        log.info("----------------------------");
        log.info("LettersSend - Start");
        log.info("[accountList:]");
        log.info(accountList.toString());
        log.info("----------------------------");

        Reporter.initialize();
        int size = accountList.size();
        try {
            for (int current = 0; current < size; current++) {
                log.info("=================================");
                String Subject = Random.getRandomSubject();
                int next = current + 1;
                if (next >= size) {
                    next = 0;
                }

                Account accountFrom = accountList.get(current);
                Account accountTo = accountList.get(next);

                log.info(String.format("Sending letter From:#%d: %s To:#%d: %s- %s]", current, accountFrom.toString(), next, accountTo.toString(), Subject));


                SendLetter.send(Subject, accountFrom, accountTo);

                log.info("----------------------------");
                log.fine("Check letter");
                WebDriver driver = new FirefoxDriver();
                driver.get("https://mail.tut.by/");
                log.fine("driver.save_screenshot(\"screenshot.png\")");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                log.info("----------------------------");
                LoginPage.login(driver, accountFrom.email, accountFrom.password);
                AssertSendPage.checkSent(driver, Subject, accountFrom);
                LogOutPage.exitstatus(driver);
                driver.quit();


                WebDriver driver2 = new FirefoxDriver();
                driver2.manage().window().maximize();
                driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver2.get("http://mail.tut.by/");

                LoginPage.login(driver2, accountTo.email, accountTo.password);
                AssertInboxPage.checkInbox(driver2, Subject, accountTo);
                driver2.quit();

                log.info("=================================");
                log.info("");
            }
        } catch (Throwable e) {
            log.warning("FAILED: test check folder sent: " + e.getMessage());
        }
        Reporter.writeResults();
    }


}
