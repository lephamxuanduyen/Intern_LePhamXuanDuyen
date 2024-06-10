import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utils.DriverManagement;
import utils.SeluniumHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Chapter10_login extends TestBase{
    private LoginPage loginPage = new LoginPage();

    private String validLoginEmail = TestBase.validEmail;
    private String validPwd = TestBase.validPwd;
    private String invalidPwd = "123456";
    private String noActiveEmail = "duyen123@gmail.com";

    @Test
    void TC001(){
        System.out.println("TC001 - User can log into Railway with valid username and password");
        loginPage.login(validLoginEmail, validPwd);

        String expectedResult = "Welcome " + validLoginEmail;
        String actualResult = SeluniumHelper.getText(loginPage.xpath_WelcomeUserMessage);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void TC002(){
        System.out.println("TC002 - User cannot login with blank \"Username\" textbox");
        loginPage.login("", validPwd);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        String actualResult = SeluniumHelper.getText(loginPage.xpath_MessageProblemLogin);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void TC003(){
        System.out.println("TC003 - User cannot log into Railway with invalid password");
        loginPage.login(validLoginEmail, invalidPwd);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        String actualResult = SeluniumHelper.getText(loginPage.xpath_MessageProblemLogin);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void TC004(){
        System.out.println("TC004 - System shows message when user enters wrong password many times");
        loginPage.login(validLoginEmail, invalidPwd);

        String expectedResult = "Invalid username or password. Please try again.";
        String actualResult = SeluniumHelper.getText(loginPage.xpath_MessageProblemLogin);

        Assert.assertEquals(actualResult, expectedResult);

        for (int i=0; i<4; i++){
            loginPage.submitLoginForm(validLoginEmail, "123");
            actualResult = SeluniumHelper.getText(loginPage.xpath_MessageProblemLogin);
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
        System.out.println("TC005 - User can't login with an account hasn't been activated");
        loginPage.login(noActiveEmail, validPwd);

        String expectedResult = "Invalid username or password. Please try again.";
        String actualResult = SeluniumHelper.getText(loginPage.xpath_MessageProblemLogin);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
