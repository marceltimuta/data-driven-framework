import base.BaseTest;
import common.Constants;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private By loginAsBankManagerBtn = By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button");

    @BeforeTest
    public void beforeMethod() {
        driver.get(config.getProperty(Constants.BASE_URL));
    }

    @Test
    public void loginAsBankManager() {
        driver.findElement(loginAsBankManagerBtn).click();
    }
}
