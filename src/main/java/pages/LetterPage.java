package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lenovo on 9/21/2016.
 */
public class LetterPage {
    public static final By TEXT_TITLE_LINK = Locators.get("TextTitleLink");

    public static void write(WebDriver driver){

        WebElement emailfield = driver.findElement(TEXT_TITLE_LINK);
        emailfield.click();
    }
}
