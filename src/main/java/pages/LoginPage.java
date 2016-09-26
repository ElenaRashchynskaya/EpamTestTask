package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/21/2016.
 */
public class LoginPage {

    private static Logger log = Logger.getLogger("testLog");

    public static final By LOGIN_LINK = Locators.get("LoginLink");
    public static final By PASSWORD_LINK = Locators.get("PasswordLink");
    public static final By LOGIN_BUTTON = Locators.get("LoginButton");


    public static void login(WebDriver driver, String email, String password) {
        log.info(">Login account:" + email);
        WebElement emailfield = driver.findElement(LOGIN_LINK);
        emailfield.sendKeys(email);


        WebElement passwordfield = driver.findElement(PASSWORD_LINK);
        passwordfield.sendKeys(password);

        WebElement clickbutton = driver.findElement(LOGIN_BUTTON);
        clickbutton.click();
    }
}
