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
    By continueButtonLocator=By.xpath("//button[contains(@class,'backButton')]");
    By backButtonLocator=By.xpath("//button[@type='button']");
    By subjectsCheckBoxsLocator=By.xpath("//div[contains(@class,'subjectsGrid')]");
    By goalSelectDropDownMenuLocator=By.xpath("//select[contains(@class,'goalSelect')]");
    By acceptTermsCheckBoxLocator=By.xpath("//input[@name='acceptTerms']");
    By createProfileButtonLocator=By.xpath("//button[contains(@class,'submitButton')]");
    String edvanceSignUpURL = "https://edvance-ace.vercel.app/signup";

    Bot loginBot;

    // 2. Constructor

    public StudentSignUpPage(Bot bot) {
        loginBot = bot;
    }

    //3. Methods and Actions

    public void navigateToSignUpPage() {
        loginBot.navigateTo(edvanceSignUpURL);
    }

    public void enterFirstName()
    {

    }

    public void enterInvalidFirstNameLength()
    {

    }

    public void enterLastName()
    {

    }

    public void enterInvalidLastNameLength()
    {

    }

    public void enterEmail()
    {

    }


    public void enterInvalidEmailFormat()
    {

    }

    public void enterValidPhoneNumber()
    {

    }

    public void enterInvalidPhoneNumber()
    {

    }

    public void selectGrade()
    {

    }

    public void enterValidDateOfBirth()
    {

    }

    public void enterInvalidDateOfBirth()
    {

    }


    public void enterValidPassword()
    {

    }

    public void enterInvalidPassword()
    {

    }

    public void confirmWithValidPassword()
    {
        enterValidPassword();
    }

    public void confirmWithInvalidPassword()
    {

    }

    public void clickOnNextButton()
    {

    }

    public void clickOnBackButton()
    {

    }

    public void selectFavoriteSubject()
    {

    }

    public void selectYourGoal()
    {

    }

    public void checkTheTermsAndConditionsBox()
    {

    }



}






