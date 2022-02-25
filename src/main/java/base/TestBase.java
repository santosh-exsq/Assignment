package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.PropertyFileOperation;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected PropertyFileOperation configFile;
    protected WebDriver driver;

    @BeforeClass
    public void initialization() {
        configFile = new PropertyFileOperation(System.getProperty("user.dir") + File.separator+"config.properties");
    }

    @BeforeMethod
    public void setUp() {
        String browserName = configFile.getPropertyValue("BROWSER_NAME");
        launchBrowser(browserName);
        driver.get(configFile.getPropertyValue("URL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    private void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}