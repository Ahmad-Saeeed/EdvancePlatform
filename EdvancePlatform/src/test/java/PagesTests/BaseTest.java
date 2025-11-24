package PagesTests;

import Engine.Bot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    Bot bot;

    @BeforeMethod
    public void startUp() {
        bot = new Bot();
    }

    @AfterMethod
    public void tearDown() {
        bot.sessionTearDown();
    }
}
