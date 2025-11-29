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
    String validEmail1 = "ahmed.mohamed@teacher.com";
    String validEmail2= "fatma.ali@teacher.com";
    String validEmail3 ="mahmoud.hassan@teacher.com";
    String validEmail4 = "karim.youssef@teacher.com";
    String invalidEmail = "abcd@teacher.com";
    String validPassword = "password123";
    String invalidPassword = "password321";
    Bot loginBot;
    public TeacherLoginPage(Bot bot){
        loginBot = bot;
    }
    public void navigateToLoginPage(){
        loginBot.navigateTo(edvanceURL);
    }
    public void enter1stValidEmail(){
        loginBot.typeInto(loginEmailLocator,validEmail1);
    }
    public void enter2ndtValidEmail(){
        loginBot.typeInto(loginEmailLocator,validEmail2);
    }
    public void enter3rdValidEmail(){
        loginBot.typeInto(loginEmailLocator,validEmail3);
    }
    public void enter4thValidEmail(){
        loginBot.typeInto(loginEmailLocator,validEmail4);
    }
    public void enterValidPassword(){
        loginBot.typeInto(loginPasswordLocator,validPassword);
    }
    public void enterInvalidEmail(){
        loginBot.typeInto(loginEmailLocator,invalidEmail);
    }
    public void enterInvalidPassword(){
        loginBot.typeInto(loginPasswordLocator,invalidPassword);
    }
    public void clickOnLoginButton(){
        loginBot.clickOn(loginButtonLocator);
    }
    public boolean checkWelcomeMessage(){
        return (loginBot.displayedText(welcomeMessageLocator).contains("Welcome"))||(loginBot.displayedText(welcomeMessageLocator).contains("أهلاً"));
    }

    public boolean loginErrorMesDisplayed(){
        return (loginBot.displayedText(loginErrorMesLocator).contains("Login failed. Check your credentials"))||loginBot.displayedText(loginErrorMesLocator).contains("فشل تسجيل الدخول. تحقق من بياناتك");
    }
    public void forggotPasswordClick(){
        loginBot.clickOn(forgotPasswordLocator);
    }
    public boolean checkForggotPassPagelanding(){
        return loginBot.getURLWhenItChanges(edvanceURL).contains("forgot-password");
    }
    public void registerNowClick(){
        loginBot.clickOn(registerNowLocator);
    }
    public boolean checkRegisterPageLanding(){
        return loginBot.getURLWhenItChanges(edvanceURL).contains("signup");
    }
    public void featureClick(){
        loginBot.clickOn(featuresLocator);
    }
    public boolean checkFeaturePageLanding(){
        return loginBot.getURLWhenItChanges(edvanceURL).contains("features");
    }
    public void aboutUsClick(){
        loginBot.clickOn(aboutLocator);
    }
    public boolean checkAboutUsPageLanding(){
        return loginBot.getURLWhenItChanges(edvanceURL).contains("about");
    }
    public void contactUsClick(){
        loginBot.clickOn(contactUsLocator);
    }
    public boolean checkContactUsPageLanding(){
        return loginBot.getURLWhenItChanges(edvanceURL).contains("contact");
    }
    public void themeToggleLClick(){
        loginBot.clickOn(themeToggleLocator);
    }
    public boolean checkThemeToggleFunction(){
        return loginBot.getClassAttribute(togglestatusLocator).contains("module__M80vaq__sun")||loginBot.getClassAttribute(togglestatusLocator).contains("module__M80vaq__moon");
    }
    public void languageButtonLClick(){
        loginBot.clickOn(languageToggleLocator);
    }
    public String checkLanguageIcon(){
        return loginBot.displayedText(languageContentLocator);
    }
    public void joinFreeClick(){
        loginBot.clickOn(joinFreeLocator);
    }
    public boolean checkJoinFreePageLanding(){
        return loginBot.getURLWhenItChanges(edvanceURL).contains("signup");
    }



}
