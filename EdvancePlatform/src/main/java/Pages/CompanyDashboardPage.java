package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyDashboardPage {

    public WebDriver driver;

    // Locators
    public By totalJobs = By.xpath("//div[@class='dashboard-stat total-jobs']");
    public By activeJobs = By.xpath("//div[@class='CompanyDashboard-module__taIlIW__activeJobs']");
    public By totalApplications = By.xpath("//div[@class='CompanyDashboard-module__taIlIW__totalApplications']");
    public By newApplications = By.xpath("//div[@class='CompanyDashboard-module__taIlIW__newApplications']");
    public By shortlisted = By.xpath("//div[@class='CompanyDashboard-module__taIlIW__shortlisted']");
    public By interviewsScheduled = By.xpath("//div[@class='CompanyDashboard-module__taIlIW__interviewsScheduled']");
    public By postanewjob = By.xpath("//a[@class='CompanyDashboard-module__taIlIW__newJobButton']");
    // Constructor
    public CompanyDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to get stats
    public String getTotalJobs() {
        return driver.findElement(totalJobs).getText();
    }

    public String getActiveJobs() {
        return driver.findElement(activeJobs).getText();
    }

    // Similarly add getters for other stats...
}

