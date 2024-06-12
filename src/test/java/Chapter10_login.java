import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utils.DriverManagement;
import utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Chapter10_login extends TestBase{
    private LoginPage loginPage = new LoginPage();

    private String invalidPwd = "123456";
    private String noActiveEmail = "duyen123@gmail.com";

    @Test
    void TC001(){
        loginPage.login(validEmail, validPwd);

        String expectedResult = "Welcome " + validEmail;
        String actualResult = SeleniumHelper.getText(loginPage.xpath_WelcomeUserMessage);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void TC002(){
        loginPage.login("", validPwd);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        String actualResult = SeleniumHelper.getText(loginPage.xpath_MessageProblemAccount);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void TC003(){
        loginPage.login(validEmail, invalidPwd);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        String actualResult = SeleniumHelper.getText(loginPage.xpath_MessageProblemAccount);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void TC004(){
        loginPage.login(validEmail, invalidPwd);

        String expectedResult = "Invalid username or password. Please try again.";
        String actualResult = SeleniumHelper.getText(loginPage.xpath_MessageProblemAccount);

        Assert.assertEquals(actualResult, expectedResult);

        for (int i=0; i<4; i++){
            loginPage.submitLoginForm(validEmail, "123");
            actualResult = SeleniumHelper.getText(loginPage.xpath_MessageProblemAccount);
            Assert.assertEquals(actualResult, expectedResult);
        }

        try {
            DriverManagement.driver.findElement(By.xpath("//p[contains(text(),'You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.')]")).isDisplayed();
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            Assert.fail("Message don\'t display.");
        }

    }

    @Test
    void TC005(){
        loginPage.login(noActiveEmail, validPwd);

        String expectedResult = "Invalid username or password. Please try again.";
        String actualResult = SeleniumHelper.getText(loginPage.xpath_MessageProblemAccount);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
