package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private By loginAsBankManagerBtn = By.cssSelector("button[ng-click='manager()']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public BankManagerPage loginAsBankManager() {
        driver.findElement(loginAsBankManagerBtn).click();
        return new BankManagerPage(driver);
    }
}
