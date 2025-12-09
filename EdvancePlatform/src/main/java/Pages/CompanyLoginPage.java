package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyLoginPage {

        public WebDriver driver;

        //   Locators
        public By EmailField = By.xpath("//input[@id='email']");
        public By PasswordField = By.xpath("//input[@id='password']");
        public By LoginButton = By.xpath("//button[@class='Login-module__qAm00G__submitButton']");
        public By ErrorMessage = By.xpath("//div[@class='Login-module__qAm00G__errorMessage']");

        // --- Constructor ---
        public CompanyLoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // Navigate to Login Page
        public void navigateToLoginPage() {
            driver.get("https://edvance-ace.vercel.app/login");
        }

        // Enter Email
        public void enterValidEmail(String email) {
            driver.findElement(EmailField).clear();
            driver.findElement(EmailField).sendKeys(email);
        }

        //  Enter Password
        public void enterValidPassword(String password) {
            driver.findElement(PasswordField).clear();
            driver.findElement(PasswordField).sendKeys(password);
        }

        //  Click Login
        public void clickLogin() {
            driver.findElement(LoginButton).click();
        }


        public void login(String email, String password) {
            enterValidEmail(email);
            enterValidPassword(password);
            clickLogin();
        }


        public String getErrorMessage() {
            return driver.findElement(ErrorMessage).getText();
        }
    }


