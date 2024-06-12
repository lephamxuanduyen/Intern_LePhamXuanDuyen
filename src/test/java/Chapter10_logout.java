import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverManagement;

public class Chapter10_logout extends TestBase{
    private LoginPage loginPage = new LoginPage();

    private String validLoginEmail = TestBase.validEmail;
    private String validPwd = TestBase.validPwd;

    @Test
    void TC6(){
        loginPage.login(validLoginEmail, validPwd);
        loginPage.selectTab("Log out");

        By xpath_logoutTab = By.xpath("//a[span[text()='Log out']]");
        try {
            DriverManagement.driver.findElement(xpath_logoutTab).isDisplayed();
            Assert.fail("Element exists");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e instanceof NoSuchElementException);
        }
    }
}
