package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static Utilities.GlobalWait.*;

public class ElementInteractions {

    // I will use the driver that used in the global wait, so I just need to make the passed one
    // to be the used one in the class.
    public ElementInteractions(WebDriver driver)
    {
       Utilities.GlobalWait wait = new GlobalWait(driver);
    }

    public static void clickON(By elementToClickOnLocator)
    {
       waitToBeClickable(elementToClickOnLocator).click();
    }

    public static void typeTextInto(By fieldLocator, String textToType)
    {
        waitToBeAbleToType(fieldLocator).sendKeys(textToType);
    }

    public static  String displayedTextOf(By locator)
    {
       return waitToBeVisible(locator).getText();
    }

    public static String getElementAttribute(By elementLocator,String attributeName)
    {
       return waitToGetAttribute(elementLocator).getAttribute(attributeName);
    }

    public static void apiActionTabKey(By elementLocator)
    {
        waitDriver.findElement(elementLocator).sendKeys(Keys.TAB);
    }
    public static void apiActionEnterKey(By elementLocator)
    {
        waitDriver.findElement(elementLocator).sendKeys(Keys.ENTER);
    }
}
