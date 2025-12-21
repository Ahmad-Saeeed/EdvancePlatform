package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class AdminLoginPage {
    private Bot bot;

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("loginBtn");
    private final By errorMessage = By.xpath("//div[@class='error-message']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password?']");

    // Constructor
    public AdminLoginPage(Bot bot) {
        this.bot = bot;
    }

    // Navigation
    public AdminLoginPage navigateToLoginPage(String url) {
        bot.driver.get(url);
        return this;
    }

    // Actions (Fluent)
    public AdminLoginPage enterUsername(String username) {
        bot.typeInto(usernameField, username);
        return this;
    }

    public AdminLoginPage enterPassword(String password) {
        bot.typeInto(passwordField, password);
        return this;
    }

    public AdminLoginPage clickLoginButton() {
        bot.clickOn(loginButton);
        return this;
    }

    // Validations
    public String getErrorMessage() {
        return bot.displayedText(errorMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return bot.checkObjectDisplay(errorMessage);
    }

    public boolean isLoginButtonDisplayed() {
        return bot.checkObjectDisplay(loginButton);
    }

    // Forgot password
    public AdminLoginPage clickForgotPassword() {
        bot.clickOn(forgotPasswordLink);
        return this;
    }
}