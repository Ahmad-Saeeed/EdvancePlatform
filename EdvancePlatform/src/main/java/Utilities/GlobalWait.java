package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class GlobalWait
{
    public static WebDriver waitDriver;

        public GlobalWait(WebDriver driver)
        {
            waitDriver=driver;
        }

        //To return the type of wait used.
        public static FluentWait<WebDriver> waitType()
        {
            return new FluentWait<>(waitDriver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotInteractableException.class);

        }

        //Just to reuse not repeat the same steps
        public  static boolean elementChecking(By elementLocator)
        {
            if( waitDriver.findElement(elementLocator).isEnabled() &&
                waitDriver.findElement(elementLocator).isDisplayed())
            {
               return  true;
            }
            return false;
        }

        public static WebElement waitToBeVisible(By elementToBeDisplayed)
        {
            return waitType().until(d->{
                if ( elementChecking(elementToBeDisplayed) )
                {
                    return d.findElement(elementToBeDisplayed);
                }
                return null;
            });
        }

    public static WebElement waitToBeClickable(By elementToClickOn)
    {
        return waitType().until(waitDriver->{
            if ( elementChecking(elementToClickOn) )
            {
                return waitDriver.findElement(elementToClickOn);
            }
            return null;
        });
    }

    public static WebElement waitToBeAbleToType(By elementToTypeInto)
    {
       return waitType().until(d->{
           if ( elementChecking(elementToTypeInto))
           {
               return d.findElement(elementToTypeInto);
           }
           return null;
       });
    }


    public static WebElement waitToGetAttribute(By elementToGetAttribute)
    {
       return waitType().until( d -> {
            if (elementChecking(elementToGetAttribute))
            {
                return d.findElement(elementToGetAttribute);
            }
            return null;
        });

    }









    public WebElement waitUntilTextDisplayed(By elementToGetItsText)
    {
        return waitType().until(d->{
            return d.findElement(elementToGetItsText);
        });
    }

}
