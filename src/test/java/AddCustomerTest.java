import base.BaseTest;
import common.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BankManagerPage;
import utils.ExcelReader;

public class AddCustomerTest extends BaseTest {
    private static String filePath = "\\src\\test\\resources\\excel\\customers.xlsx";
    private ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + filePath);
    private BankManagerPage bankManagerPage;

    @BeforeTest
    public void beforeMethod() {
        driver.get(config.getProperty(Constants.ADD_CUSTOMER_URL));
    }

    @Test(dataProvider = "getData")
    public void addCustomer(String firstname, String lastname, String postCode) {
        bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.fillForm(firstname,lastname,postCode)
                .saveAlertText();
        Assert.assertTrue(bankManagerPage.getAlertMessage().contains("Customer added successfully"));
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] testObjArray = excelReader.getTableArray();
        return testObjArray;
    }
}
