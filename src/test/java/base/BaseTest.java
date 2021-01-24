package base;

import common.Constants;
import common.DriverType;
import common.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties config;

    @BeforeSuite
    public void setUp() {
        config = TestProperties.readConfigProps();
        if (config.getProperty(Constants.DRIVER).toUpperCase().equals(DriverType.FIREFOX.toString())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void cleanUp() {
//        driver.quit();
    }
}
