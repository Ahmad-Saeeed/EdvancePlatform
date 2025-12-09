package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyLoginPage {

        public WebDriver driver;

        // --- PUBLIC Locators ---
        public By EmailField = By.xpath("//input[@id='email']");
        public By PasswordField = By.xpath("//input[@id='password']");
        public By LoginButton = By.xpath("//button[@class='Login-module__qAm00G__submitButton']");
        public By ErrorMessage = By.xpath("//div[@class='Login-module__qAm00G__errorMessage']");

        // --- Constructor ---
        public CompanyLoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // --- Navigate to Login Page ---
        public void navigateToLoginPage() {
            driver.get("https://edvance-ace.vercel.app/login");
        }

        // --- Enter Email ---
        public void enterValidEmail(String email) {
            driver.findElement(EmailField).clear();
            driver.findElement(EmailField).sendKeys(email);
        }

        // --- Enter Password ---
        public void enterValidPassword(String password) {
            driver.findElement(PasswordField).clear();
            driver.findElement(PasswordField).sendKeys(password);
        }

        // --- Click Login ---
        public void clickLogin() {
            driver.findElement(LoginButton).click();
        }

        // --- Shortcut Login Method (optional but useful) ---
        public void login(String email, String password) {
            enterValidEmail(email);
            enterValidPassword(password);
            clickLogin();
        }

        // --- Read Error Message ---
        public String getErrorMessage() {
            return driver.findElement(ErrorMessage).getText();
        }
    }


