package Pages;

import Engine.Bot;
import org.openqa.selenium.By;

public class TeacherDashBoardPage {
    //Locators
    By studentsLocator = By.xpath("//a[@href='/teacher/students']");
    By sessionScheduleLocator = By.xpath("//a[@href='/teacher/schedule']");
    By statisticsLocator = By.xpath("//a[@href='/teacher/analytics']");
    By themeToggleLocator = By.xpath("//button[@class='ThemeToggle-module__M80vaq__button']");
    By languageToggleLocator = By.xpath("//button[@class='LanguageSwitcher-module__CeKvmG__languageSwitcher']");
    By notificationLocator = By.xpath("//button[@class='NotificationDropdown-module__V6trHW__notificationButton']");
    By menuButtonLocator = By.xpath("//button[@class='TeacherNav-module__X_bpXW__profileButton']");
    By profileLocator = By.xpath("//a[@class='TeacherNav-module__X_bpXW__dropdownItem'][1]");
    By earningsLocator = By.xpath("//a[@class='TeacherNav-module__X_bpXW__dropdownItem'][2]");
    By logOutLocator = By.xpath("//button[@class='TeacherNav-module__X_bpXW__dropdownItem']");
    By createNewCourseLocator = By.xpath("//*[normalize-space(text())='Create New Course' or normalize-space(text())='إنشاء دورة جديدة']");
    By lectureScheduleLocator = By.xpath("//*[normalize-space(text())='Create New Course']");
    By manageStudentsLocators = By.xpath("//*[normalize-space(text())='Manage Students']");
    By togglestatusLocator = By.xpath("//*[name()='svg' and contains(@class, 'ThemeToggle')]");
    By languageContentLocator = By.xpath("//span[@class='LanguageSwitcher-module__CeKvmG__languageText']");
    By notificationSectionLocator = By.xpath("//div[@class='NotificationDropdown-module__V6trHW__dropdown']");
    By editProfileLocator = By.xpath("//button[@class='TeacherProfile-module__bKMAXG__editButton']");
    By specializationLocator = By.xpath("//input[@placeholder='Specialization (e.g. Mathematics, Science, Arabic...)' or @placeholder='التخصص (مثال: رياضيات، علوم، لغة عربية...)']");
    By yearsOfExperienceLocator = By.xpath("//input[@placeholder='Number of years of experience' or @placeholder='عدد سنوات الخبرة']");
    By saveChangesLocator = By.xpath("//button[@class='TeacherProfile-module__bKMAXG__saveButton']");
    By courseTitleLocator = By.xpath("//input[@id='title']");
    By courseDescriptionLocator = By.xpath("//textarea[@id='description']");
    By subjectLocator = By.xpath("//button[@class='CreateCourse-module__m3N4xW__categoryButton '][3]");
    By selectLocator = By.xpath("//select[@id='grade']");
    By selectOptionLocator = By.xpath("//option[@value='primary_1']");
    By nextButtonLocator = By.xpath("//*[normalize-space(text())='Next' or normalize-space(text())='التالي']");
    By coursePriceLocator = By.xpath("//input[@id='price']");
    By courseDurationLocator = By.xpath("//input[@id='duration']");
    By courseNumofLessons = By.xpath("//input[@id='lessons_count']");
    By createCourseLocator = By.xpath("//*[normalize-space(text())='إنشاء الكورس']");
    By courseNumbersinHome = By.xpath("//*[normalize-space(text())='All' or normalize-space(text())='الكل']");
    By deleteButtonofTheAddedCourse = By.xpath("(//button[contains(@class,'deleteButton')])[16]");



    String loginUrl = "https://edvance-ace.vercel.app/login";
    String dashBoardUrl = "https://edvance-ace.vercel.app/teacher/dashboard";
    String specilizationFieldValue = "Science";
    String yearsOfExFieldValue = "10";
    String valueToChoose = "الصف الأول الابتدائي";

    Bot dashBoardBot;

    public TeacherDashBoardPage(Bot bot) {
        dashBoardBot = bot;
    }

    public boolean verifyDashBoardPageLanding() {
        return dashBoardBot.getURLWhenItChanges(loginUrl).contains("dashboard");
    }

    public void clickOnStudentsField() {
        dashBoardBot.clickOn(studentsLocator);
    }

    public boolean checkStudentsPageLanding() {
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("students");
    }

    public void clickOnSessionScheduleField() {
        dashBoardBot.clickOn(sessionScheduleLocator);
    }

    public boolean checkSessionSchedulePageLanding() {
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("schedule");
    }

    public void clickOnStatisticsField() {
        dashBoardBot.clickOn(statisticsLocator);
    }

    public boolean checkStatisticsPageLanding() {
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("analytics");
    }

    public void themeToggleLClick() {
        dashBoardBot.clickOn(themeToggleLocator);
    }

    public boolean checkThemeToggleFunction() {
        return dashBoardBot.getClassAttribute(togglestatusLocator).contains("module__M80vaq__sun") || dashBoardBot.getClassAttribute(togglestatusLocator).contains("module__M80vaq__moon");
    }

    public void languageButtonLClick() {
        dashBoardBot.clickOn(languageToggleLocator);
    }

    public String checkLanguageIcon() {
        return dashBoardBot.displayedText(languageContentLocator);
    }

    public void clicOnknotificationButton() {
        dashBoardBot.clickOn(notificationLocator);
    }

    public boolean checknotificationSectionDisplay() {
        return dashBoardBot.checkObjectDisplay(notificationSectionLocator);
    }

    public void clickOnDropDownMenu() {
        dashBoardBot.clickOn(menuButtonLocator);
    }

    public void clickOnProfileInDropDownMenu() {
        dashBoardBot.clickOn(profileLocator);
    }

    public boolean checkProfilePageLanding() {
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("profile");
    }

    public void clickOnEditProfileButton() {
        dashBoardBot.clickOn(editProfileLocator);
    }

    public void enterInSpecializationField() {
        dashBoardBot.clickOn(specializationLocator);
        dashBoardBot.typeInto(specializationLocator, specilizationFieldValue);
    }

    public void enterInSpecializationyearsOfExField() {
        dashBoardBot.typeInto(yearsOfExperienceLocator, yearsOfExFieldValue);
    }

    public void clickOnSaveChangesButton() {
        dashBoardBot.clickOn(saveChangesLocator);
    }

    public boolean checkPopUpMessageContent() {
        return (dashBoardBot.popUpMessageDisplayedText().contains("saved successfully") || dashBoardBot.popUpMessageDisplayedText().contains("حفظ الملف الشخصي بنجاح"));
    }

    public void acceptPopUpMessage() {
        dashBoardBot.popUpMessageOK();
    }

    public boolean checkEnteredDataSaved() {
        return dashBoardBot.checkObjectDisplay(editProfileLocator);
    }

    //no need
//    public boolean waitForEditFieldsToLoad() {
//        return dashBoardBot.checkObjectDisplay(specializationLocator);
//    }
    public void clickOnEarningsButton() {
        dashBoardBot.clickOn(earningsLocator);
    }

    public boolean checkEarningsPageLanding() {
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("earnings");
    }

    public void clickOnLogoutButton() {
        dashBoardBot.clickOn(logOutLocator);
    }

    public boolean checkLogoutSuccessfull() {
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("login");
    }

    public void clickCreateNewCourse() {
        dashBoardBot.clickOn(createNewCourseLocator);
    }

    public boolean checkCreateNewCoursePageLanding(){
        return dashBoardBot.getURLWhenItChanges(dashBoardUrl).contains("create");
    }
    public void enterCourseTittle(){
        dashBoardBot.typeInto(courseTitleLocator,"Software Testing Course");
    }
    public void enterCourseDescription(){
        dashBoardBot.typeInto(courseDescriptionLocator,"Apply now to get the full software testing course");
    }
    public void enterSubject(){
        dashBoardBot.clickOn(subjectLocator);
    }
    public void chooseFromList(){
        dashBoardBot.clickOn(selectLocator);
        dashBoardBot.clickOn(selectOptionLocator);
    }
    public void clickNextButton(){
        dashBoardBot.clickOn(nextButtonLocator);
    }
    public void enterCoursePrice(){
        dashBoardBot.typeInto(coursePriceLocator,"100");
    }
    public void enterCourseDuration(){
        dashBoardBot.typeInto(courseDurationLocator,"10");
    }
    public void enterCourseNumofLessons(){
        dashBoardBot.typeInto(courseNumofLessons,"20");
    }
    public void clickCreateCourseButton(){
        dashBoardBot.clickOn(createCourseLocator);
    }
    public boolean verifyCourseAdded(){
        return dashBoardBot.displayedText(courseNumbersinHome).contains("16");
    }
    public void clickDeleteButtonofTheNewCourse(){
        dashBoardBot.clickOn(deleteButtonofTheAddedCourse);
    }
    public void acceptDeletePopupMessage(){
        dashBoardBot.popUpMessageOK();
    }
    public void verifyPageRelod(){
        dashBoardBot.clickOn(notificationLocator);}
    public boolean verifytheCourseDeleted(){
        return dashBoardBot.displayedText(courseNumbersinHome).contains("15");
    }





}
