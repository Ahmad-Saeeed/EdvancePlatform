package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class StudentLoginPage {


    By emailFieldLocator = By.xpath("//input[@id='email']");
    By passwordFieldLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By rememberMeCheckBoxLocator = By.xpath("//input[@type='checkbox']");
    By forgetPasswordLinkLocator = By.xpath("//a[@href='/forgot-password']");
    By registerNowLinkLocator = By.xpath("(//a[contains(@href,'/signup')])[2]");
    By welcomeLocator=By.xpath("//main//h1");
    By errorMsgLocator= By.xpath("//div[contains(@class,'errorMessage')]");
    By platformLogoInLoginPageLocator =By.xpath("(//a[contains(@class,'logo')])[2]");
    By featureLinkFromHeaderLocator=By.xpath("//a[contains(@href,'feature')]");
    By aboutLinkFromHeaderLocator=By.xpath("//a[contains(@href,'about')]");
    By contactUsLinkFromHeaderLocator=By.xpath("//a[contains(@href,'contact')]");
    By themeIconLocator=By.xpath("//button[contains(@class,'ThemeToggle')]");
    By languageIconLocator=By.xpath("//div[@id='languageIcon']");
    By loginLinkFromHeaderLocator=By.xpath("//a[contains(@href,'/login')]");
    By signUpButtonFromHeaderLocator=By.xpath("(//a[contains(@href,'/signup')])[1]");


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
        loginBot.typeInto(passwordFieldLocator, invalidPassword);
    }

    public void clickONLoginButton() {
        loginBot.clickOn(loginButtonLocator);
    }

    public String currentURL() {

        return loginBot.currentURL();
    }

    public String currentURLAfterLoading(String oldURL)
    {
        return loginBot.getURLWhenItChanges(oldURL);
    }

    public boolean welcomeMessageDisplayed()
    {
        return (loginBot.displayedText(welcomeLocator).contains("مرحبا"))|| (loginBot.displayedText(welcomeLocator).contains("Welcome"));
    }

    public boolean errorMsgDisplayed()
    {
        return  loginBot.displayedText(errorMsgLocator).contains("فشل");
    }

    public  void clickOnForgerPassword()
    {
        loginBot.clickOn(forgetPasswordLinkLocator);
    }

    public  void clickOnRegisterNow()
    {
        loginBot.clickOn(registerNowLinkLocator);
    }

    public void clikOnFeatureLink()
    {
        loginBot.clickOn(featureLinkFromHeaderLocator);
    }

    public void clickOnAboutUs()
    {
        loginBot.clickOn(aboutLinkFromHeaderLocator);
    }

    public void clickOnContactUs()
    {
        loginBot.clickOn(contactUsLinkFromHeaderLocator);
    }

    public void clickOnThemeIcon()
    {
        loginBot.clickOn(themeIconLocator);
    }

    public void clickOnLanguageIcon()
    {
        loginBot.clickOn(languageIconLocator);
    }

    public String checkLanguageIcon()
    {
        return loginBot.displayedText(By.xpath("//span[contains(@class,'LanguageSwitcher')]"));
    }

    public void clickOnLoginLinkFromHeader()
    {
        loginBot.clickOn(loginLinkFromHeaderLocator);
    }

    public void clickOnJoinForFreeButtonFromHeader()
    {
        loginBot.clickOn(signUpButtonFromHeaderLocator);
    }

    public void clickOnPlatformLogo()
    {
        loginBot.clickOn(platformLogoInLoginPageLocator);
    }




}


