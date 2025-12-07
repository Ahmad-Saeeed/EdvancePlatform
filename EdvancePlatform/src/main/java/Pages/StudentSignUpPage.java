package Pages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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
    public String currentURL() {

        return sigUpBot.currentURL();
    }
    public void clickOnPlatformLogo()
    {
        sigUpBot.clickOn(platformLogoInSignUpPageLocator);
    }
    public String currentURLAfterLoading(String oldURL)
    {
        return sigUpBot.getURLWhenItChanges(oldURL);
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
    public void enterFirstName(String firstName)
    {
        sigUpBot.typeInto(firstNameFieldLocator,firstName);

    }
    public void enterLastName(String lastName)
    {
        sigUpBot.typeInto(lastNameFieldLocator,lastName);
    }
    public void enterEmail(String email)
    {
        sigUpBot.typeInto(emailFieldLocator,email);
    }
    public void enterPhoneNumber(String phoneNumber)
    {
        sigUpBot.typeInto(phoneNumberFieldLocator,phoneNumber);
    }
    public void selectGrade(String grade)
    {
        sigUpBot.selectFromList(gradeSelectionMenuLocator,grade);
    }
    public void enterDateOfBirth(String dateOfBirth)
    {
        String firsPart=dateOfBirth.substring(0,4);
        String secondPart=dateOfBirth.substring(4);
        sigUpBot.typeInto(dateOfBirthFieldLocator,firsPart);
        sigUpBot.clickOnTabKey(dateOfBirthFieldLocator);
        sigUpBot.typeInto(dateOfBirthFieldLocator,secondPart);
    }
    public void enterPassword(String password)
    {
        sigUpBot.typeInto(passwordFieldLocator,password);
    }
    public void confirmPassword(String confirmedPassword)
    {
        sigUpBot.typeInto(confirmPasswordFieldLocator,confirmedPassword);
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
    public void validInformationInputInFirstPageAndMoveToNextPage()
    {
        sigUpBot.navigateTo(edvanceSignUpURL);
        sigUpBot.clickOn(studentCardLocator);
        sigUpBot.typeInto(firstNameFieldLocator,"firstName");
        sigUpBot.typeInto(lastNameFieldLocator,"lastName");
        sigUpBot.typeInto(emailFieldLocator,"email@fake.com");
        sigUpBot.typeInto(phoneNumberFieldLocator,"1234567890");
        sigUpBot.selectFromList(gradeSelectionMenuLocator,"primary-4");
        enterDateOfBirth("19032003");
        sigUpBot.typeInto(passwordFieldLocator,"A1111111");
        sigUpBot.typeInto(confirmPasswordFieldLocator,"A1111111");
        sigUpBot.clickOn(nextButtonLocator);
    }

}






