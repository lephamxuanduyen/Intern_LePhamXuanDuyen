import base.DataSets;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.Action;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.listeners.ReportListener;

@Listeners(ReportListener.class)
public class Login extends TestBase {
    LoginPage loginPage = new LoginPage();

    String invalidPwd = "123456";
    String noActiveEmail = "duyen123@gmail.com";

    User UserBlankEmail = new User("", validPwd);
    User UserInvalidPwd = new User(validEmail, invalidPwd);
    User UserNoActive = new User(noActiveEmail, validPwd);

    @Test(description = "User can log into Railway with valid username and password", dataProvider = "ValidUserDataProvider", dataProviderClass = DataSets.class)
    void LoginWithValidInfo(User user) {
        loginPage.login(user);
        String expectedResult = "Welcome " + validEmail;
        loginPage.verifyWelcomeMes(expectedResult);
    }

    @Test(description = "User cannot login with blank \"Username\" textbox")
    void LoginWithBlankEmail() {
        loginPage.login(UserBlankEmail);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        loginPage.verifyErrorMes(expectedResult);

    }

    @Test(description = "User cannot log into Railway with invalid password")
    void LoginWithInvalidPwd() {
        loginPage.login(UserInvalidPwd);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        loginPage.verifyErrorMes(expectedResult);
    }

    @Test(description = "System shows message when user enters wrong password many times")
    void LoginWithWrongPwdManyTime() {
        loginPage.login(UserInvalidPwd);

        String expectedResult = "Invalid username or password. Please try again.";
        loginPage.verifyErrorMes(expectedResult);
        loginPage.loopVerifyErrorMes(4, expectedResult);

        String expectedMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Boolean isDisplay = Action.isDisplay(By.xpath(String.format(loginPage.paragraph, expectedMessage)));
        Assert.assertTrue(isDisplay);
    }

    @Test(description = "User can't login with an account hasn't been activated")
    void LoginWithInactiveEmail() {
        loginPage.login(UserNoActive);

        String expectedResult = "Invalid username or password. Please try again.";
        loginPage.verifyErrorMes(expectedResult);
    }
}
