/**
 * Created by Lenovo on 9/26/2016.
 */

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    //define a WebDriver named driver
    private WebDriver driver;
    //create a new instance of Test Result Xml Utility Object
    TestResultXmlUtility testResultXmlUtility = new TestResultXmlUtility();
    //create a list object that will contain number of test cases
    List<TestCases> testcases = new ArrayList<TestCases>();

    //login test

    @Test
    public void SeleniumMasterLoginTest() {
        {
            //open login page
            driver.navigate().to("http://www.seleniummaster.com/seleniummastertestapp/index.php");
            //maximize the window
            driver.manage().window().maximize();
            //type in user name
            driver.findElement(By.id("login_login_username")).sendKeys("test");
            //type in user password
            driver.findElement(By.id("login_login_password")).sendKeys("XXXX"); //here password is omitted
            //click on the submit button
            driver.findElement(By.id("login_submit")).click();
            //within 60 seconds try asserting that user logged on
            for (int second = 0; ; second++) {
                if (second >= 60) Assert.fail("timeout");
                try {
                    assertEquals("Online users", driver.findElement(By.cssSelector("#sb-onlineusers > h3")).getText());
                    //add test case to the testcases list as pass
                    testcases.add(new TestCases("002", "Login Test", "Pass"));
                    break;
                } catch (Exception e) {
                    //add test case to the testcases list as Fail
                    testcases.add(new TestCases("002", "Login Test", "Fail"));
                }
            }

        }
    }

    @BeforeMethod
    public void Setup() {
//add test result header information to the resultList
        try {
            //initialize Firefox driver
            driver = new FirefoxDriver();
            //obtain windows handler name
            String windowsHandle = driver.getWindowHandle();
            //assert that a window has been launched
            assertEquals(true, windowsHandle.length() > 0);
            //add a test case to the testcases list as pass
            testcases.add(new TestCases("001", "Test Setup ", "Pass"));
        } catch (Exception e) {
            ////add a test case to the testcases list as Fail
            testcases.add(new TestCases("001", "Test Setup ", "Fail"));
        }

    }

    @AfterMethod
    public void TearDown() throws IOException, ParserConfigurationException {
        //close the driver
        driver.close();
        //write the test result to xml file with file name TestResult
        testResultXmlUtility.WriteTestResultToXml("TestResult.xml", testcases);
        //quit the driver
        driver.quit();
    }

}
