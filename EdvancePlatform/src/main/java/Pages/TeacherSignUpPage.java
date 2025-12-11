package Pages;

import Engine.Bot;
import Utilities.ConfigReader;
import org.openqa.selenium.By;

public class TeacherSignUpPage {
    By instructorLocator = By.xpath("//button[@class='Signup-module__5az0ga__userTypeCard'][2]");
    By firstNameLocator = By.xpath("//input[@id='firstName']");
    By lastNameLocator = By.xpath("//input[@id='lastName']");
    By emailLocator = By.xpath("//input[@id='email']");
    By phoneLocator = By.xpath("//input[@class='PhoneInputInput']");
    By passwordLocator = By.xpath("//input[@id='password']");
    By confirmPasswordLocator = By.xpath("//input[@id='confirmPassword']");
    By nextLocator = By.xpath("//button[@class='Signup-module__5az0ga__nextButton']");
    By verifyButtonLocator = By.xpath("//button[@class='Signup-module__5az0ga__verifyButton']");


    Bot signUpBot;

    public TeacherSignUpPage(Bot bot) {
        signUpBot = bot;
    }

    public void navigateToSignUpPage() {
        signUpBot.navigateTo(ConfigReader.getProperty("signUpURL"));
    }

    public void selectInstructorField() {
        signUpBot.clickOn(instructorLocator);
    }

    public void enterFirstName() {
        signUpBot.typeInto(firstNameLocator, ConfigReader.getProperty("teacher.properties","firstNAme"));
    }

    public void enterLastName() {
        signUpBot.typeInto(lastNameLocator, ConfigReader.getProperty("teacher.properties","lastName"));
    }

    public void enterEmail() {
        signUpBot.typeInto(emailLocator,  ConfigReader.getProperty("teacher.properties","email"));
    }

    public void enterPhone() {
        signUpBot.typeInto(phoneLocator, ConfigReader.getProperty("teacher.properties","phoneNumber"));
    }

    public void enterPassword() {
        signUpBot.typeInto(passwordLocator, ConfigReader.getProperty("teacher.properties","password"));
    }

    public void enterConfirmPassword() {
        signUpBot.typeInto(confirmPasswordLocator, ConfigReader.getProperty("teacher.properties","confirmPassword"));
    }

    public void nextButtonClick() {
        signUpBot.clickOn(nextLocator);
    }

    public void verifyButtonClick() {
        signUpBot.clickOn(verifyButtonLocator);
    }

    public boolean signUpPageLanding() {
        return signUpBot.getURLWhenItChanges(ConfigReader.getProperty("signUpURL")).contains("verify.didit.me");

    }

}
