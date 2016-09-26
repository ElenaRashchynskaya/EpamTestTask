package report;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.properties.annotations.Resource;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Lenovo on 9/24/2016.
 */
public class Utils {
    @Attachment(value = "{0}", type = "image/pmg")
    public static byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void makeScreenShotInFolder(String name) throws IOException {
        File scrFile = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\!myown\\Lena\\automatization\\EpamTestTask\\image\\screeName.jpg"));

    }
}
