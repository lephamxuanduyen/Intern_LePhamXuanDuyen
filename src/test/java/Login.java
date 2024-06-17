import models.User;
import utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Login extends TestBase{
    LoginPage loginPage = new LoginPage();

    String invalidPwd = "123456";
    String noActiveEmail = "duyen123@gmail.com";

    User validUser = new User(validEmail, validPwd);
    User UserBlankEmail = new User("", validPwd);
    User UserInvalidPwd = new User(validEmail, invalidPwd);
    User UserNoActive = new User(noActiveEmail, validPwd);

    @Test(description = "User can log into Railway with valid username and password")
    void TC001(){
        loginPage.login(validUser);

        String expectedResult = "Welcome " + validEmail;
        loginPage.verifyWelcomeMes(expectedResult);
    }

    @Test(description = "User cannot login with blank \"Username\" textbox")
    void TC002(){
        loginPage.login(UserBlankEmail);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        loginPage.verifyErrorMes(expectedResult);

    }

    @Test(description = "User cannot log into Railway with invalid password")
    void TC003(){
        loginPage.login(UserInvalidPwd);

        String expectedResult = "There was a problem with your login and/or errors exist in your form.";
        loginPage.verifyErrorMes(expectedResult);
    }

    @Test(description = "System shows message when user enters wrong password many times")
    void TC004(){
        loginPage.login(UserInvalidPwd);

        String expectedResult = "Invalid username or password. Please try again.";
        loginPage.verifyErrorMes(expectedResult);
        loginPage.loopVerifyErrorMes(4, expectedResult);

        SeleniumHelper.verifyEleDisplay(By.xpath("//p[contains(text(),'You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.')]"));
    }

    @Test(description = "User can't login with an account hasn't been activated")
    void TC005(){
        loginPage.login(UserNoActive);

        String expectedResult = "Invalid username or password. Please try again.";
        loginPage.verifyErrorMes(expectedResult);
    }
}
