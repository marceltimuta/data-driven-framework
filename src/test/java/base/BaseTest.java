package base;

import common.Constants;
import common.DriverType;
import common.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties config;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    @BeforeSuite
    public void setUp() {
        config = TestProperties.readConfigProps();
        BasicConfigurator.configure();
        log.debug("Config file loaded");
        if (config.getProperty(Constants.DRIVER).toUpperCase().equals(DriverType.FIREFOX.toString())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.debug("Driver setup ready");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void cleanUp() {
        if (driver != null)
            driver.quit();
        log.debug("Test execution completed");
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }
}
