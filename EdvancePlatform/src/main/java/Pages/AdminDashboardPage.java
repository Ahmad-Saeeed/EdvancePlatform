package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class AdminDashboardPage {
    private Bot bot;

    // Locators - UPDATE THESE WITH ACTUAL IDS/XPATHS FROM INSPECTION
    private final By dashboardTitle = By.xpath("//h1[contains(text(),'Dashboard') or contains(text(),'لوحة التحكم')]");
    private final By userProfileMenu = By.id("userProfile");
    private final By logoutButton = By.xpath("//button[contains(text(),'Logout') or contains(text(),'تسجيل الخروج')]");
    private final By welcomeMessage = By.xpath("//div[contains(@class,'welcome')]");
    private final By navigationMenu = By.xpath("//nav");

    // Constructor
    public AdminDashboardPage(Bot bot) {
        this.bot = bot;
    }

    // Validations
    public boolean isDashboardDisplayed() {
        return bot.checkObjectDisplay(dashboardTitle);
    }

    public String getDashboardTitle() {
        return bot.displayedText(dashboardTitle);
    }


    public boolean isNavigationMenuDisplayed() {
        return bot.checkObjectDisplay(navigationMenu);
    }

    // Actions
    public AdminDashboardPage clickUserProfileMenu() {
        bot.clickOn(userProfileMenu);
        return this;
    }

    public AdminLoginPage logout() {
        bot.clickOn(logoutButton);
        return new AdminLoginPage(bot);
    }

    // Get current URL
    public String getCurrentUrl() {
        return bot.driver.getCurrentUrl();
    }
}