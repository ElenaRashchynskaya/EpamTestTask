package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 9/22/2016.
 */
public class LogOutPage {
    public static final By STATUS_LINK = Locators.get("statusdropbox");
    public static final By EXIT_LINK = Locators.get("exit");
    public static final By POST_LINK = Locators.get("post");


    public static void exitstatus(WebDriver driver){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement emailfield = driver.findElement(STATUS_LINK);
        emailfield.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement passwordfield = driver.findElement(EXIT_LINK);
        passwordfield.click();

//        String mainPageTitle = "Белорусский портал TUT.BY";
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(driver.getTitle(),mainPageTitle,"Error !!! Not Main Page Title !!! ");

//        WebElement postbutton = driver.findElement(POST_LINK);
//        postbutton.click();

    }
}
