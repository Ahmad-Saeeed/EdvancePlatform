package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class TeacherLoginPage {
    //login locator
    By loginEmailLocator = By.id("email");
    By loginPasswordLocator = By.id("password");
    By rememberMeLocator = By.xpath("//input[@type='checkbox']");
    By forgotPasswordLocator = By.xpath("//a[@class='Login-module__qAm00G__forgotPassword']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By loginErrorMesLocator = By.xpath("//div[@class='Login-module__qAm00G__errorMessage']");
    By themeToggleLocator = By.xpath("//button[@class='ThemeToggle-module__M80vaq__button']");
    By languageToggleLocator = By.xpath("//button[@class='LanguageSwitcher-module__CeKvmG__languageSwitcher']");
    By welcomeMessageLocator = By.xpath("//main//h1");
    By registerNowLocator = By.xpath("//a[@class='Login-module__qAm00G__signupLink']");
    By featuresLocator = By.xpath("//a[@href='/features']");
    By aboutLocator = By.xpath("//a[@href='/about']");
    By contactUsLocator = By.xpath("//a[@href='/contact']");
    By joinFreeLocator = By.xpath("//a[@class='Nav-module__WvC1Nq__signUp']");
    By togglestatusLocator = By.xpath("//*[name()='svg' and contains(@class, 'ThemeToggle')]");
    By languageContentLocator = By.xpath("//span[@class='LanguageSwitcher-module__CeKvmG__languageText']");

    String edvanceURL = "https://edvance-ace.vercel.app/login";
    String edvanceForrgotPasswordURL = "https://edvance-ace.vercel.app/forgot-passw";
    public static String validEmail1 = "ahmed.mohamed@teacher.com";
    public static String validEmail2 = "fatma.ali@teacher.com";
    public static String validEmail3 = "mahmoud.hassan@teacher.com";
    public static String validEmail4 = "karim.youssef@teacher.com";
    public static String invalidEmail = "abcd@teacher.com";
    public static String validPassword = "password123";
    public static String invalidPassword = "password321";
    Bot loginBot;

    public TeacherLoginPage(Bot bot) {
        loginBot = bot;
    }

    public void navigateToLoginPage() {
        loginBot.navigateTo(edvanceURL);
    }

    public void enterEmail(String email){
        loginBot.typeInto(loginEmailLocator,email);
    }
    public void enterPassword(String password){
        loginBot.typeInto(loginPasswordLocator,password);
    }

    //General valid navigate and login method to use in the rest of the teacher pages
    public void navigateandValidLogin(){
        loginBot.navigateTo(edvanceURL);
        loginBot.typeInto(loginEmailLocator,validEmail1);
        loginBot.typeInto(loginPasswordLocator,validPassword);
        loginBot.clickOn(loginButtonLocator);
    }

    public void clickOnLoginButton() {
        loginBot.clickOn(loginButtonLocator);
    }

    public boolean checkWelcomeMessage() {
        return (loginBot.displayedText(welcomeMessageLocator).contains("Welcome")) || (loginBot.displayedText(welcomeMessageLocator).contains("أهلاً"));
    }

    public boolean loginErrorMesDisplayed() {
        return (loginBot.displayedText(loginErrorMesLocator).contains("Login failed. Check your credentials")) || loginBot.displayedText(loginErrorMesLocator).contains("فشل تسجيل الدخول. تحقق من بياناتك");
    }

    public void forggotPasswordClick() {
        loginBot.clickOn(forgotPasswordLocator);
    }

    public boolean checkForggotPassPagelanding() {
        return loginBot.getURLWhenItChanges(edvanceURL).contains("forgot-password");
    }

    public void registerNowClick() {
        loginBot.clickOn(registerNowLocator);
    }

    public boolean checkRegisterPageLanding() {
        return loginBot.getURLWhenItChanges(edvanceURL).contains("signup");
    }

    public void featureClick() {
        loginBot.clickOn(featuresLocator);
    }

    public boolean checkFeaturePageLanding() {
        return loginBot.getURLWhenItChanges(edvanceURL).contains("features");
    }

    public void aboutUsClick() {
        loginBot.clickOn(aboutLocator);
    }

    public boolean checkAboutUsPageLanding() {
        return loginBot.getURLWhenItChanges(edvanceURL).contains("about");
    }

    public void contactUsClick() {
        loginBot.clickOn(contactUsLocator);
    }

    public boolean checkContactUsPageLanding() {
        return loginBot.getURLWhenItChanges(edvanceURL).contains("contact");
    }

    public void themeToggleLClick() {
        loginBot.clickOn(themeToggleLocator);
    }

    public boolean checkThemeToggleFunction() {
        return loginBot.getClassAttribute(togglestatusLocator).contains("module__M80vaq__sun") || loginBot.getClassAttribute(togglestatusLocator).contains("module__M80vaq__moon");
    }

    public void languageButtonLClick() {
        loginBot.clickOn(languageToggleLocator);
    }

    public String checkLanguageIcon() {
        return loginBot.displayedText(languageContentLocator);
    }

    public void joinFreeClick() {
        loginBot.clickOn(joinFreeLocator);
    }

    public boolean checkJoinFreePageLanding() {
        return loginBot.getURLWhenItChanges(edvanceURL).contains("signup");
    }


}
