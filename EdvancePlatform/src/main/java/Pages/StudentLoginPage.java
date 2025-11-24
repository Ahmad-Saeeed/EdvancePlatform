package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class StudentLoginPage {

        By emailFieldLocator = By.xpath("//input[@id='email']");
        By passwordFieldLocator = By.xpath("//input[@id='password']");
        By loginButtonLocator = By.xpath("//button[@type='submit']");
        By rememberMeCheckBoxLocator = By.xpath("//input[@type='checkbox']");
        By forgetPasswordLinkLocator = By.xpath("//a[@href='/forgot-password']");
        By registerNowLinkLocator = By.xpath("//a[@href='/signup']");
        String edvanceLoginURL = "https://edvance-ace.vercel.app/login";
        String validEmail_1 = "student1@test.com";
        String validEmail_2 = "student2@test.com";
        String validEmail_3 = "student3@test.com";
        String validPassword = "password123";
        String invalidEmail = "tester@test.com";
        String invalidPassword = "TestPassword123";
        Bot loginBot;

        public StudentLoginPage(Bot bot) {
           loginBot = bot;
        }

        public void navigateToLoginPage() {
            loginBot.navigateTo(edvanceLoginURL);
        }

        public void enterFirstValidEmail() {
           loginBot.typeInto(emailFieldLocator, validEmail_1);
        }

        public void enterSecValidEmail() {
            loginBot.typeInto(emailFieldLocator, validEmail_2);
        }

        public void enterThirdValidEmail() {
           loginBot.typeInto(emailFieldLocator, validEmail_3);
        }

        public void enterValidPassword() {
            loginBot.typeInto(passwordFieldLocator, validPassword);
        }

        public void enterInvalidEmail() {
            loginBot.typeInto(emailFieldLocator, invalidEmail);
        }

        public void enterInvalidPassword() {
            loginBot.typeInto(emailFieldLocator, invalidPassword);
        }

        public void clickONLoginButton() {
           loginBot.clickOn(loginButtonLocator);
        }

        public String currentURL() {
            return loginBot.currentURL();
        }


    }


