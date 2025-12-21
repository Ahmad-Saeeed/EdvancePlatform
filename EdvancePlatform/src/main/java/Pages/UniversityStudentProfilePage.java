package Pages;

import Engine.Bot;

import org.openqa.selenium.By;

public class UniversityStudentProfilePage {

    //Array to store categories needed to filter courses results
    String[] categories = {
            "All Specializations",
            "Programming",
            "Business Management",
            "Design",
            "Marketing",
            "Data Analysis",
            "Languages",
            "Soft Skills",
    };

    //Array to store the number of courses shows by changing category
    String[] numberOfCourses = {
            "8 courses",
            "2 courses",
            "0 courses",
            "1 courses",
            "1 courses",
            "1 courses",
            "1 courses",
            "1 courses",
    };

    //Array to store emails used for sign in
    String[] emails = {
            "yasmin.ahmed@university.com",
            "ahmed.khaled@university.com",
            "mariam.hussein@university.com",
            "omar.salem@university.com",
            "nour.mahmoud@university.com",
    };

    //Array to store usernames appear after sign in to used for assertion after login
    String[] usernames = {
            "ياسمين أحمد",
            "أحمد خالد",
            "مريم حسين",
            "عمر سالم",
            "نور محمود",
    };

    //Index used in for loop that changes with emails looping
    int categoryIndex = 0;

    //Locators
    By viewProfileUsp = By.xpath("//*[@class='UniversityDashboard-module__XZ3nra__primaryButton']");
    By editProfile = By.xpath("//*[@class='UniversityProfile-module__lk0U8W__editButton']");
    By uploadCV = By.xpath("//*[@class='UniversityProfile-module__lk0U8W__replaceButton']");
    By jobOpportunitiesUsp = By.xpath("//*[@class='UniversityDashboard-module__XZ3nra__secondaryButton']");
    By searchBoxDashboardUsp = By.xpath("//*[@class='UniversityDashboard-module__XZ3nra__searchInput __web-inspector-hide-shortcut__']");
    By courseCategoryUsp = By.xpath("//*[@class='UniversityDashboard-module__XZ3nra__categoryButton UniversityDashboard-module__XZ3nra__active']");
    By filterCoursesSelectProgramming = By.xpath("//button[contains(@class, 'UniversityDashboard-module__XZ3nra__categoryButton')]/span[. = 'Programming']]");
    By switchLanguage = By.xpath("//*[@class='LanguageSwitcher-module__CeKvmG__languageSwitcher']");
    By CoursesNumberUsp = By.xpath("//*[@class='UniversityDashboard-module__XZ3nra__coursesHeader']/p");
    By username = By.xpath("//*[@class='UniversityStudentNav-module__ZS8s3W__userName whitespace-nowrap']");

    //Login Locators
    By loginEmail = By.xpath("//*[@id='email']");
    By loginPassword = By.xpath("//*[@id='password']");
    By loginSubmit = By.xpath("//Button[@type='submit']");
    String urlMain = "https://edvance-ace.vercel.app/login";

    //Strings used as its name indicate for
    public String urlDashboard = "https://edvance-ace.vercel.app/university_student/dashboard";
    public String urlProfile = "https://edvance-ace.vercel.app/university_student/profile";
    public String password = "password123";
    public String expectedUsernameDisplayed;
    public String actualUsername;
    public String expectedCourseNumber;
    public String actualCourseNumber;
    public String actualUrl;
    public String expectedUrl;

    //Instance of Bot class
    Bot uspBot;


    //This method is used to test login, its parameter define the number of users needed to test login
    //It can be considered as a data provider alternative
    public void UniversityStudentProfileNavigation(int neededUsers) {
        for (int userIndex = 0; userIndex < neededUsers; userIndex++) {
            uspBot = new Bot("chrome");
            String email = emails[userIndex];
            uspBot.navigateTo(urlMain);
            uspBot.typeInto(loginEmail, email);
            uspBot.typeInto(loginPassword, password);
            uspBot.clickOn(loginSubmit);
            expectedUsernameDisplayed = usernames[userIndex];
            actualUsername = uspBot.displayedText(username);
        }
    }

    //This method used to login then navigates to user profile
    public void goToProfile() {
        UniversityStudentProfileNavigation(1);
        actualUrl = uspBot.currentURL();
        uspBot.clickOn(viewProfileUsp);
        expectedUrl = uspBot.currentURL();
    }

    //This method used to test editing profile after clicking 'Edit' button
    public void setEditProfile() {
        goToProfile();
        uspBot.clickOn(editProfile);
        uspBot.clickOn(uploadCV);
    }

    //    This method use login method, then change language to English; because the default language
//    after login is always Arabic.
//    The remaining code click on each category button then check courses number from array above
//    against category selected.
    public void ensureCategoryNameAndNumeberOfCourses() {
        UniversityStudentProfileNavigation(1);
        uspBot.clickOn(switchLanguage);
        for (categoryIndex = 0; categoryIndex < categories.length; categoryIndex++) {
            By filterCoursesSelectCategory = By.xpath(String.format(
                    "//button[contains(@class, 'UniversityDashboard-module__XZ3nra__categoryButton ')]/span[. = '%s']",
                    categories[categoryIndex]
            ));
            uspBot.clickOn(filterCoursesSelectCategory);
            expectedCourseNumber = numberOfCourses[categoryIndex];
            actualCourseNumber = uspBot.displayedText(CoursesNumberUsp);
        }
    }

    //This method used for login but this time using Excel sheet as a data provider
    public void UniversityStudentLoginUsingExcelData(String username, String password) {
        uspBot = new Bot("chrome");
        uspBot.navigateTo(urlMain);
        uspBot.typeInto(loginEmail, username);
        uspBot.typeInto(loginPassword, password);
        uspBot.clickOn(loginSubmit);
    }
}
