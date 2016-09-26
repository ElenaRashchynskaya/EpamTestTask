import org.openqa.selenium.WebDriver;
import helpers.Random;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/25/2016.
 */
public class ExampleTest {
    protected WebDriver driver;

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(ExampleTest.class.getResourceAsStream("logging.properties"));
            Logger logger = Logger.getLogger("log1");

            FileHandler fh;



            // This block configure the logger with handler and formatter
            fh = new FileHandler(String.format("C:/tmp/log/log_%s.log", Random.getFormatDate()));
            logger.addHandler(fh);
            // the following statement is used to log any messages

            logger.info(new Date().toString());
            logger.info("My first log");
            logger.warning("Hi How r u?");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}