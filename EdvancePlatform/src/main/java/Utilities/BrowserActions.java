package Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    public static WebDriver browserActionDriver;

    public BrowserActions(WebDriver driver)
    {
        browserActionDriver=driver;
    }

    public static void navigateToURL(String URL)
    {
        browserActionDriver.navigate().to(URL);
    }

    public static String currentURL()
    {
        return browserActionDriver.getCurrentUrl();
    }

   public static String currentPageTitle()
   {
       return browserActionDriver.getTitle();
   }

   public static Alert switchToAlert()
   {
       LoggerFactory.logInfo("Moving to the poppedUp Alert");
       return browserActionDriver.switchTo().alert();
   }

   public static void closeBrowser()
   {
       browserActionDriver.quit();
   }


}
