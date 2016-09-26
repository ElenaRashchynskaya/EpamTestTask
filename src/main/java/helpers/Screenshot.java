package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/25/2016.
 */
public class Screenshot {

    private static Logger log = Logger.getLogger("testLog");

    public String folder = "tmp\\screenshot\\";

    public Screenshot(WebDriver driver, String expectedSubject, String mailFolder) {

        //  File screenShot = ((TakesScreenshot)driver).getScreenshotAs(FILE);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            //FileUtils.copyFile(screenShot, new File("C:\\!myown\\Lena\\automatization\\EpamTestTask"));

            String fileName = folder + String.format("%s_[%s]_(%s).png", expectedSubject, mailFolder, UUID.randomUUID());
            log.info("Save Screenshot with name:" + fileName);
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
