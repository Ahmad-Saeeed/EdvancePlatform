package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class StudentSignUpPage {

    // 1. Locators and variables
    By platformLogoInSignUpPageLocator=By.xpath("//a[contains(@class,'logo')]");
    By loginLinkFromHeaderLocator=By.xpath("(//a[contains(@href,'/login')])[1]");
    By studentCardLocator = By.xpath("//h3[contains(@class,'userTypeTitle')][1]");
    By loginLinkInFormContainerLocator=By.xpath("(//a[contains(@href,'/login')])[2]");
    By firstNameFieldLocator=By.xpath("//input[@id='firstName']");
    By lastNameFieldLocator=By.xpath("//input[@id='lastName']");
    By emailFieldLocator=By.xpath("//input[@id='email']");
    By phoneNumberFieldLocator=By.xpath("//input[@autocomplete='tel']");
    By gradeSelectionMenuLocator=By.xpath("//select[@id='grade']");
    By dateOfBirthFieldLocator=By.xpath("//input[@id='birthDate']");
    By passwordFieldLocator=By.xpath("//input[@id='password']");
    By confirmPasswordFieldLocator=By.xpath("//input[@id='confirmPassword']");
    By nextButtonLocator =By.xpath("//button[contains(@class,'nextButton')]");
    By backButtonLocator=By.xpath("//button[@type='button']");
    By subject_1CheckBoxLocator =By.xpath("(//input[@type='checkbox'])[1]");
    By subject_2CheckBoxLocator =By.xpath("(//input[@type='checkbox'])[2]");
    By goalSelectDropDownMenuLocator=By.xpath("//select[contains(@class,'goalSelect')]");
    By acceptTermsCheckBoxLocator=By.xpath("//input[@name='acceptTerms']");
    By createProfileButtonLocator=By.xpath("//button[contains(@class,'submitButton')]");
    By welcomeEdvanceLocator=By.xpath("//p[contains(@class,'success')][1]");
    By loginButtonSuccessLocator=By.xpath("(//a[@href='/login'])[2]");

    //This error msg locator valid if only one filed is missing or has an error msg.
    By errorMsgLocator= By.xpath("(//span[contains(@class,'errorMessage')])");



    String edvanceSignUpURL = "https://edvance-ace.vercel.app/signup";
    String validEmail="Tester@tests.com";

    Bot sigUpBot;

    // 2. Constructor

    public StudentSignUpPage(Bot bot)
    {
        sigUpBot = bot;
    }

    //3. Methods and Actions

    public void navigateToSignUpPage() {
        sigUpBot.navigateTo(edvanceSignUpURL);
    }

    public void clickOnPlatformIcon()
    {
        sigUpBot.clickOn(platformLogoInSignUpPageLocator);
    }

    public void clickOnLoginLinkFromHeader()
    {
        sigUpBot.clickOn(loginLinkFromHeaderLocator);
    }

    public void clickOnLoginLinkFromForm()
    {
        sigUpBot.clickOn(loginLinkInFormContainerLocator);
    }

    public void clickOnStudentCard()
    {
        sigUpBot.clickOn(studentCardLocator);
    }

    public void enterValidFirstName()
    {
        sigUpBot.typeInto(firstNameFieldLocator,"Ahmed");
    }

    public void enterInvalidFirstNameLength()
    {
        sigUpBot.typeInto(firstNameFieldLocator,"a");
    }

    public void enterValidLastName()
    {
        sigUpBot.typeInto(lastNameFieldLocator,"Tester");
    }

    public void enterInvalidLastNameLength()
    {
        sigUpBot.typeInto(lastNameFieldLocator,"k");
    }

    public void enterValidEmail()
    {
        sigUpBot.typeInto(emailFieldLocator,validEmail);
    }


    public void enterInvalidEmailFormat()
    {
        sigUpBot.typeInto(emailFieldLocator,"ads");
    }

    public void enterValidPhoneNumber()
    {
        sigUpBot.typeInto(phoneNumberFieldLocator,"1234567890");
    }

    public void enterInvalidPhoneNumber()
    {
        sigUpBot.typeInto(phoneNumberFieldLocator,"1234578");
    }

    public void selectGrade()
    {
        sigUpBot.selectFromList(gradeSelectionMenuLocator,"primary-4");
    }

    public void enterValidDateOfBirth()
    {
        sigUpBot.typeInto(dateOfBirthFieldLocator,"02152015");
    }

    public void enterInvalidDateOfBirth()
    {
        sigUpBot.typeInto(dateOfBirthFieldLocator,"02151999");
    }


    public void enterValidPassword()
    {
    sigUpBot.typeInto(passwordFieldLocator,"A1234567");
    }

    public void enterInvalidPasswordLength()
    {
        sigUpBot.typeInto(passwordFieldLocator,"A123456");
    }

    public void enterInvalidPasswordFormat()
    {
        //password length is correct but doesn't have capital char.
        sigUpBot.typeInto(passwordFieldLocator,"12345678");
    }

    public void confirmWithValidPassword()
    {
        sigUpBot.typeInto(confirmPasswordFieldLocator,"A1234567");
    }

    public void confirmWithInvalidPassword()
    {
        sigUpBot.typeInto(confirmPasswordFieldLocator,"WrongPass123");
    }

    public void clickOnNextButton()
    {
        sigUpBot.clickOn(nextButtonLocator);
    }

    public void clickOnBackButton()
    {
        sigUpBot.clickOn(backButtonLocator);
    }

    public void selectFavoriteSubjects()
    {
        sigUpBot.clickOn(subject_1CheckBoxLocator);
        sigUpBot.clickOn(subject_2CheckBoxLocator);
    }

    public void selectYourGoal()
    {
        sigUpBot.selectFromList(goalSelectDropDownMenuLocator,"improve");
    }

    public void checkTheTermsAndConditionsBox()
    {
        sigUpBot.clickOn(acceptTermsCheckBoxLocator);
    }

    public void clickOnCreateAccount()
    {
        sigUpBot.clickOn(createProfileButtonLocator);
    }

    public boolean successfulSignupWelcomeMsgDisplayed()
    {
        return sigUpBot.displayedText(welcomeEdvanceLocator).contains("Success");
    }

    public boolean loginButtonInSuccessfulSignupDisplayed()
    {
        return sigUpBot.checkObjectDisplay(loginButtonSuccessLocator);
    }

    public String errorMessageDisplayedText()
    {
        return sigUpBot.displayedText(errorMsgLocator);
    }

    public String popUpMsgContent()
    {
        return  sigUpBot.popUpMessageDisplayedText();
    }
}






