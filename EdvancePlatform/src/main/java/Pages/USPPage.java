package Pages;

import Engine.Bot;
import org.openqa.selenium.By;
public class USPPage {
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
    String[] numberOfCourses = {
            "7 courses",
            "2 courses",
            "0 courses",
            "1 courses",
            "1 courses",
            "1 courses",
            "1 courses",
            "1 courses",
    };
    String[] emails = {
            "yasmin.ahmed@university.com",
            "ahmed.khaled@university.com",
            "mariam.hussein@university.com",
            "omar.salem@university.com",
            "nour.mahmoud@university.com",
    };
    String[] usernames = {
            "ياسمين أحمد",
            "أحمد خالد",
            "مريم حسين",
            "عمر سالم",
            "نور محمود",
    };
    int categoryIndex = 0;
    By viewProfileUsp = By.xpath("//*[@class='UniversityDashboard-module__XZ3nra__primaryButton']");
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
    String url = "https://edvance-ace.vercel.app/login";
    String password = "password123";
    public String expectedUsernameDisplayed;
    public String actualUsername;
    public String expectedCourseNumber;
    public String actualCourseNumber;
    Bot uspBot;

    public void navigate(int neededUsers) {
        for (int userIndex = 0; userIndex < neededUsers; userIndex++) {
            uspBot = new Bot();
            String email = emails[userIndex];
            uspBot.navigateTo(url);
            uspBot.typeInto(loginEmail, email);
            uspBot.typeInto(loginPassword, password);
            uspBot.clickOn(loginSubmit);
            expectedUsernameDisplayed = usernames[userIndex];
            actualUsername = uspBot.displayedText(username);
        }
    }
    public void goToProfile() {
        navigate(1);
        uspBot.clickOn(viewProfileUsp);
    }
    // TODO : CHECK API
    public void ensureCategoryNameAndNumeberOfCourses() {
        navigate(1);
        uspBot.clickOn(switchLanguage);
        for (categoryIndex=0; categoryIndex < categories.length; categoryIndex++) {
            By filterCoursesSelectCategory = By.xpath(String.format(
                    "//button[contains(@class, 'UniversityDashboard-module__XZ3nra__categoryButton ')]/span[. = '%s']",
                    categories[categoryIndex]
            ));
            uspBot.clickOn(filterCoursesSelectCategory);
            expectedCourseNumber = numberOfCourses[categoryIndex];
            actualCourseNumber = uspBot.displayedText(CoursesNumberUsp);
        }
    }
}
