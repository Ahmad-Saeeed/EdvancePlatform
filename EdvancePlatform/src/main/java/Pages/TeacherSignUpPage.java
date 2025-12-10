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


    String signUpURL = ConfigReader.getProperty("signUpURL");
    String firstNAme = ConfigReader.getProperty("firstNAme");
    String lastName = ConfigReader.getProperty("lastName");
    String email = ConfigReader.getProperty("email");
    String phoneNumber = ConfigReader.getProperty("phoneNumber");
    String password = ConfigReader.getProperty("password");
    String confirmPassword = ConfigReader.getProperty("confirmPassword");

    Bot signUpBot;

    public TeacherSignUpPage(Bot bot) {
        signUpBot = bot;
    }

    public void navigateToSignUpPage() {
        signUpBot.navigateTo(signUpURL);
    }

    public void selectInstructorField() {
        signUpBot.clickOn(instructorLocator);
    }

    public void enterFirstName() {
        signUpBot.typeInto(firstNameLocator, firstNAme);
    }

    public void enterLastName() {
        signUpBot.typeInto(lastNameLocator, lastName);
    }

    public void enterEmail() {
        signUpBot.typeInto(emailLocator, email);
    }

    public void enterPhone() {
        signUpBot.typeInto(phoneLocator, phoneNumber);
    }

    public void enterPassword() {
        signUpBot.typeInto(passwordLocator, password);
    }

    public void enterConfirmPassword() {
        signUpBot.typeInto(confirmPasswordLocator, confirmPassword);
    }

    public void nextButtonClick() {
        signUpBot.clickOn(nextLocator);
    }

    public void verifyButtonClick() {
        signUpBot.clickOn(verifyButtonLocator);
    }

    public boolean signUpPageLanding() {
        return signUpBot.getURLWhenItChanges(signUpURL).contains("verify.didit.me");

    }

}
