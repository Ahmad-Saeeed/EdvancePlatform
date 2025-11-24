
package Engine;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
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

    public String displayedText(By displayedTextLocator) {
        return wait.until(f->
        {
            return f.findElement(displayedTextLocator).getText();
        });
    }

    public void sessionTearDown() {
        driver.quit();
    }
}
