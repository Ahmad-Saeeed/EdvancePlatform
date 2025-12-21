package Engine;



import Utilities.BrowserActions;
import Utilities.ElementInteractions;
import Utilities.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static Utilities.BrowserActions.*;
import static Utilities.ElementInteractions.*;
import static Utilities.GlobalWait.*;


public class Bot {
    ChromeOptions options;
    public WebDriver driver;

  /*  public Bot() {

        options = new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");

        //Suggested edit 1
        //options= new ChromeOptions().addArguments("--start-maximized --incognito ");

        driver = new ChromeDriver(options);
        new BrowserActions(driver);
        new ElementInteractions(driver);

       // wait = waitType();
    *//* new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);*//*
    }*/

    public WebDriver setUpBrowserOptions(String targetBrowserName)
    {
        switch (targetBrowserName.toLowerCase())
        {
            case "firefox":
                FirefoxOptions fOptions= new FirefoxOptions();
                fOptions.addArguments("-private");
                System.setProperty("webdriver.gecko.driver", "D:\\DEPI\\firefox\\geckodriver-v0.36.0-win32\\geckodriver.exe");
                FirefoxDriver fDriver=new FirefoxDriver(fOptions);
                fDriver.manage().window().maximize();
                return fDriver;

            case "edge" :
                EdgeOptions eOptions= new EdgeOptions();
                eOptions.addArguments("--start-maximized");
                eOptions.addArguments("--inprivate");
                EdgeDriver eDriver=new EdgeDriver(eOptions);
                return eDriver;

            default:
                ChromeOptions cOptions=new ChromeOptions();
                cOptions.addArguments("--start-maximized").addArguments("--incognito");
                ChromeDriver cDriver = new ChromeDriver(cOptions);
                return cDriver;

        }
    }

    public Bot(String targetBrowserName) {

        this.driver=setUpBrowserOptions(targetBrowserName);
        new BrowserActions(driver);
        new ElementInteractions(driver);
    }

    public void navigateTo(String URL) {
        BrowserActions.navigateToURL(URL);
        LoggerFactory.logInfo("Navigated to: "+URL);
    }

    public void clickOn(By objectLocator) {
        /*wait.until((f) -> {
            f.findElement(objectLocator).click();
            //  LoggerFactory.logInfo("Clicked on ", objectLocator.toString());
            return true;
        });*/
        ElementInteractions.clickON(objectLocator);
    }

    public void typeInto(By fieldLocator, String text) {
       /* wait.until((f) -> {
            f.findElement(fieldLocator).clear();
            f.findElement(fieldLocator).sendKeys(text);
            LoggerFactory.logInfo("Typed \"",text,"\""," into the field");

            return true;
        });*/
        ElementInteractions.typeTextInto(fieldLocator,text);
    }

    public String currentURL() {

       /* return wait.until(f ->
        {
            return f.getCurrentUrl();
        });*/
        return BrowserActions.currentURL();
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
    public String getURLWhenItChanges(String oldURL) {
        String crrnturl = "randomText";
        waitType().until(d -> !(d.getCurrentUrl().equals(oldURL)));
        return driver.getCurrentUrl();
    }

    /*====================================================================================================*/

    public String displayedText(By displayedTextLocator) {
//        return waitType().until(f ->
//        {
//            return f.findElement(displayedTextLocator).getText();
//        });
        return ElementInteractions.displayedTextOf(displayedTextLocator);
    }

    public void selectFromList(By listLocator, String textToSelect) {
        waitType().until(f -> {
            Select select = new Select(f.findElement(listLocator));
            select.selectByValue(textToSelect);
            LoggerFactory.logInfo("Option Selected: ",textToSelect);
            return true;
        });

    }



    public void popUpMessageOK() {
        /*Alert alert = driver.switchTo().alert();
        alert.accept();*/
        switchToAlert().accept();
    }

    public String popUpMessageDisplayedText() {
        /*Alert alert = driver.switchTo().alert();
        return alert.getText();*/
        return switchToAlert().getText();
    }

    public boolean checkObjectDisplay(By objectLocator) {
        /*return wait.until(f -> {
            return f.findElement(objectLocator).isDisplayed();
        });*/
        return elementChecking(objectLocator);
    }

    public String getSpecificClassAttribute(By locator,String className) {
     /* return wait.until(d -> {
            return d.findElement(locator).getAttribute("class");
        });*/

        return getElementAttribute(locator,className);
    }
    public String getClassAttribute(By locator) {
        return waitType().until(d -> {
            return d.findElement(locator).getAttribute("class");
        });
    }

    public void sessionTearDown() {
        LoggerFactory.logInfo("Closing the Session");
        // driver.quit();
        closeBrowser();
    }

    public void clickOnTabKey(By elementLocator) {
        // driver.findElement(elementLocator).sendKeys(Keys.TAB);
        apiActionTabKey(elementLocator);
        LoggerFactory.logInfo("TAB key is clicked");
    }

    public void clickOnEnterKey(By elementLocator) {
        //driver.findElement(elementLocator).sendKeys(Keys.ENTER);
        apiActionEnterKey(elementLocator);
        LoggerFactory.logInfo("Enter key is clicked");
    }

    public void searchAndClickEnter(By elementLocator, String searchedText) {
       /* driver.findElement(elementLocator).sendKeys(searchedText);
        driver.findElement(elementLocator).sendKeys(Keys.ENTER);*/
        typeInto(elementLocator,searchedText);
        clickOnEnterKey(elementLocator);
    }
}
/*

package Engine;

import java.time.Duration;

import Utilities.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Bot {
    ChromeOptions options;
    public WebDriver driver;
    public Wait<WebDriver> wait;
//bot
    public Bot() {

        options = new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");

        //Suggested edit 1
        //options= new ChromeOptions().addArguments("--start-maximized --incognito ");

        driver = new ChromeDriver(options);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public void navigateTo(String URL) {
        driver.navigate().to(URL);
        LoggerFactory.logInfo("Navigated to: "+URL);
    }

    public void clickOn(By objectLocator) {
        wait.until((f) -> {
            f.findElement(objectLocator).click();
          //  LoggerFactory.logInfo("Clicked on ", objectLocator.toString());
            return true;
        });
    }

    public void typeInto(By fieldLocator, String text) {
        wait.until((f) -> {
            f.findElement(fieldLocator).clear();
            f.findElement(fieldLocator).sendKeys(text);
            LoggerFactory.logInfo("Typed \"",text,"\""," into the field");

            return true;
        });
    }

    public String currentURL() {

        return wait.until(f ->
        {
            return f.getCurrentUrl();
        });
    }
*/
/*
==================================================================================================
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
     ==================================================================================================*//*


    public String getURLWhenItChanges(String oldURL) {
        String crrnturl = "randomText";
        wait.until(d -> !(d.getCurrentUrl().equals(oldURL)));
        return driver.getCurrentUrl();
    }

*/
/*====================================================================================================*//*



    public String displayedText(By displayedTextLocator) {
        return wait.until(f ->
        {
            return f.findElement(displayedTextLocator).getText();
        });
    }

    public void selectFromList(By listLocator, String textToSelect) {
        wait.until(f -> {
            Select select = new Select(f.findElement(listLocator));
            select.selectByValue(textToSelect);
            LoggerFactory.logInfo("Option Selected: ",textToSelect);
            return true;
        });

    }

    public void popUpMessageOK() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String popUpMessageDisplayedText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public boolean checkObjectDisplay(By objectLocator) {
        return wait.until(f -> {
            return f.findElement(objectLocator).isDisplayed();
        });
    }

    public String getClassAttribute(By locator) {
        return wait.until(d -> {
            return d.findElement(locator).getAttribute("class");
        });
    }

    public void sessionTearDown() {
        LoggerFactory.logInfo("Closing the Session");
        driver.quit();
    }

    public void clickOnTabKey(By elementLocator) {
        driver.findElement(elementLocator).sendKeys(Keys.TAB);
        LoggerFactory.logInfo("TAB key is clicked");
    }

    public void clickOnEnterKey(By elementLocator) {
        driver.findElement(elementLocator).sendKeys(Keys.ENTER);
        LoggerFactory.logInfo("Enter key is clicked");
    }

    public void searchAndClickEnter(By elementLocator, String searchedText) {
        driver.findElement(elementLocator).sendKeys(searchedText);
        driver.findElement(elementLocator).sendKeys(Keys.ENTER);
    }
}

*/
