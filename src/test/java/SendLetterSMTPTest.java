import helpers.*;
import helpers.Random;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 * Created by Lenovo on 9/21/2016.
 */
public class SendLetterSMTPTest {


    private static Logger log = Logger.getLogger("testLog");

    public void initLog() throws IOException {

        LogManager.getLogManager().readConfiguration(ExampleTest.class.getResourceAsStream("logging.properties"));

        // This block configure the logger with handler and formatter
        FileHandler fh = new FileHandler(String.format("tmp/log/log_%s_%s.log", Random.getFormatDate(), Random.getRandomString()));
        log.addHandler(fh);

        log.info("Run test");

    }

    @Test
    public void SendLetterTutByUseXMLFileTest() throws IOException {
        initLog();
        List<Account> accountList = ReadXMLFile.run();
        SendLetter.LettersSend(accountList);
    }

    @Test
    public void SendLetterTutByUseCSVFileTest() throws IOException {
        initLog();
        List<Account> accountList = ReadCSVFile.run();
        SendLetter.LettersSend(accountList);
    }

    @Test
    public void SendLetterTutByUseMysqlTest() throws IOException {
        initLog();
        List<Account> accountList = ReadMysql.run();
        SendLetter.LettersSend(accountList);
    }


}







