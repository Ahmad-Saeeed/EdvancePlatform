
package Engine;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Bot {
    ChromeOptions options ;
    WebDriver driver;
    Wait<WebDriver> wait;

    public Bot() {
        options = new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public void clickOn(By objectLocator) {
        wait.until((f) -> {
            f.findElement(objectLocator).click();
            return true;
        });
    }

    public void typeInto(By fieldLocator, String text) {
        wait.until((f) -> {
            f.findElement(fieldLocator).click();
            f.findElement(fieldLocator).clear();
            f.findElement(fieldLocator).sendKeys(text);
            return true;
        });
    }

    public String currentURL() {

        return wait.until(f ->
        {
            return f.getCurrentUrl();
        });
    }
    /*==================================================================================================
       * Description:
            The following method handles changing in the URL while maintaining waiting times out period
             i.e. if the url doesn't change it will give times out exception

       * How does it work:
           the wait.until() applies the fluent wait concept by trying to get the current url and compare it
            with the old one within the times out period set in the initialization of the wait (2 sec).
              if the expression inside the wait.until returns true (i.e. url changed) it will move to
               the next line which will get the changed url and return it to the method
              else it will loop trying to get the url during the times out period, until it gives false and
              times out exception

       * Reason:
            in the normal geturl it waits until it can get url which is always true, but in our situation
             the loading takes some time, so it is needed to wait until url changes
             but at the same time url may not change at all for any reason, and handling this by do while
             loop for example will make the test stuck if the url doesn't change
             that why it should be handled using the times out period of the fluent wait
              that's why this method is better to handle this
     ==================================================================================================*/
    public String getURLWhenItChanges(String oldURL)
    {
        String crrnturl="randomText";
        wait.until(d->!(d.getCurrentUrl().equals(oldURL)));
        return driver.getCurrentUrl();
    }

    /*====================================================================================================*/

    public String displayedText(By displayedTextLocator) {
        return wait.until(f->
        {
            return f.findElement(displayedTextLocator).getText();
        });
    }

    public void selectFromList(By listLocator, String textToSelect)
    {
        wait.until(f->{
            Select select =new Select(f.findElement(listLocator));
            select.selectByValue(textToSelect);
            return true;
        });

    }

    public void popUpMessageOK()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean checkObjectDisplay(By objectLocator)
    {
        return wait.until(f->{
            return f.findElement(objectLocator).isDisplayed();
        });
    }

    public void sessionTearDown() {
        driver.quit();
    }
}
