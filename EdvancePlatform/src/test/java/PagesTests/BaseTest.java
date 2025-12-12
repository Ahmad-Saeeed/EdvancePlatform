package PagesTests;

import Engine.Bot;
import Utilities.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    Bot bot;

    @BeforeMethod
    public void startUp() {
        bot = new Bot(ConfigReader.getProperty("browser.properties","browser.type"));
    }

    @AfterMethod
    public void tearDown() {
        bot.sessionTearDown();
    }
}
