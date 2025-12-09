package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class StudentDashBoardPage {
    //Variables
    Bot dashBoardPageBot;
    String studentDashboardURL="https://edvance-ace.vercel.app/student/dashboard";

    //Locators
    By edvanceLogoLocator=By.xpath("//a[contains(@class,'logoDesktop')]");
    By studentDashboardOptionLocator=By.xpath("(//span[contains(@class,'navIcon')])[1]");
    By myCoursesNavigationButtonLocator=By.xpath("(//span[contains(@class,'navIcon')])[2]");
    By aiStudyGuideNavigationButtonLocator=By.xpath("(//span[contains(@class,'navIcon')])[3]");
    By myProgressNavigationButtonLocator=By.xpath("(//span[contains(@class,'navIcon')])[4]");
    By languageToggleOptionLocator=By.xpath("(//button[contains(@class,'LanguageSwitcher')])");
    By notificationIconLocator=By.xpath("//button[contains(@class,'Notification')]");
    By studentProfileNameLocator=By.xpath("(//button[contains(@class,'StudentNav')])[2]");
    By studentProfileOptionLocator=By.xpath("(//a[contains(@class,'dropdownItem')])");
    By studentLogoutOptionLocator=By.xpath("(//button[contains(@class,'dropdownItem')])");
    By searchForCourseFieldLocator=By.xpath("(//input[contains(@placeholder,'for a course')])");
    By searchByTeacherNameFieldLocator=By.xpath("(//input[contains(@placeholder,'by teacher name')])");
    By searchButtonOfSearchByTeacherNameFieldLocator=By.xpath("(//button[@type='submit'])");



    //Constructor
    public StudentDashBoardPage (Bot bot)
    {
        dashBoardPageBot = bot;
    }

    //Page Actions
    public void navigateToStudentDashBoard()
    {
        dashBoardPageBot.navigateTo(studentDashboardURL);
    }

    public void clickOnEdvanceLogoFromNavigationBar()
    {
        dashBoardPageBot.clickOn(edvanceLogoLocator);
    }

    public void clickOnDashboardOptionFromNavigationBar()
    {
        dashBoardPageBot.clickOn(studentDashboardOptionLocator);
    }

    public void clickOnMyCoursesOptionFromNavigationBar()
    {
        dashBoardPageBot.clickOn(myCoursesNavigationButtonLocator);
    }

    public void clickOnAIStudyGuideOptionFromNavigationBar()
    {
        dashBoardPageBot.clickOn(aiStudyGuideNavigationButtonLocator);
    }

    public void clickOnMyProgressOptionFromNavigationBar()
    {
        dashBoardPageBot.clickOn(myProgressNavigationButtonLocator);
    }

    public void togglePageLanguage()
    {
        dashBoardPageBot.clickOn(languageToggleOptionLocator);
    }

    public void clickOnNotificationIcon()
    {
        dashBoardPageBot.clickOn(notificationIconLocator);
    }

    public void clickOnStudentNameFromNavigationBar()
    {
        dashBoardPageBot.clickOn(studentProfileNameLocator);
    }

    public void selectProfileOptionFromDropDownMenu()
    {

        dashBoardPageBot.clickOn(studentProfileOptionLocator);
    }

    public void selectLogout()
    {
        dashBoardPageBot.clickOn(studentLogoutOptionLocator);
    }

    public void searchForACourse(String courseName)
    {
        dashBoardPageBot.searchAndClickEnter(searchForCourseFieldLocator,courseName);
    }

    public void searchForATeacher(String teacherName)
    {
        dashBoardPageBot.typeInto(searchByTeacherNameFieldLocator,teacherName);
    }

    public void clickOnSearchByTeacherNameFieldButton()
    {
        dashBoardPageBot.clickOn(searchButtonOfSearchByTeacherNameFieldLocator);
    }

    public String currentURLAfterLoading(String oldURL)
    {
        return dashBoardPageBot.getURLWhenItChanges(oldURL);
    }

}
