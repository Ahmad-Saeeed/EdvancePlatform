package CrossBrowsingExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//This abstract class is used to be extended from the test class
public abstract class CrossBrowserBaseTest {
    protected WebDriver driver;

    //This method is used to start before each test method
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        System.out.println("Launching local browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized --guest");
//            options.addArguments("--guest");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized --guest");
//            options.addArguments("--guest");
            driver = new EdgeDriver(options);
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        //Invoke this method here in case any test class override it with different implementation
        overrideSetupMethodWhenNeeded();
    }

    //This method is used to be overridden in each test class that need to add
    // extra setup before test method
    protected void overrideSetupMethodWhenNeeded() {

    }

    //This method is used to start after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
