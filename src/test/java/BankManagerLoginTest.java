import base.BaseTest;
import common.Constants;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends BaseTest {

    private static By loginAsBankManagerBtn = By.cssSelector("button[ng-click='manager()']");
    private static By addCustomerButton = By.xpath("//button[normalize-space()='Add Customer']");

    @BeforeTest
    public void beforeMethod() {
        driver.get(config.getProperty(Constants.BASE_URL));
    }

    @Test(description = "Login successful")
    public void loginAsBankManager() {
        log.debug("Inside login test");
        driver.findElement(loginAsBankManagerBtn).click();

        Assert.assertTrue(isElementPresent(addCustomerButton),"Login failed");

        log.debug("Login executed");
    }

}
