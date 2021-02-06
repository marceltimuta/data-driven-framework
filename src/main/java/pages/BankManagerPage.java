package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage {
    private WebDriver driver;

    private By firstNameField = By.cssSelector("input[placeholder='First Name']");
    private By lastNameField = By.cssSelector("input[placeholder='Last Name']");
    private By postCodeField = By.cssSelector("input[placeholder='Post Code']");
    private By addCustomerButton = By.cssSelector("button[type='submit']");

    private String alertMessage = "";

    public BankManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public BankManagerPage fillForm(String firstName, String lastName, String postCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postCodeField).sendKeys(postCode);
        driver.findElement(addCustomerButton).click();
        return this;
    }

    public BankManagerPage saveAlertText() {
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        return this;
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}
