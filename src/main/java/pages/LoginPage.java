package pages;

import base.PageBase;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Action;

public class LoginPage extends PageBase {
    By xpath_emailTxb = By.xpath("//form//input[@id='username']");
    By xpath_pwdtxb = By.xpath("//form//input[@id='password']");
    By xpath_loginBtn = By.xpath("//form//input[@type='submit']");

    public void submitLoginForm(User user){
        Action.enter(xpath_emailTxb, user.getEmail());
        Action.enter(xpath_pwdtxb, user.getPassword());
        Action.click(xpath_loginBtn);
    }

    public void login(User user){
        selectTab("Login");
        submitLoginForm(user);
    }

    public void verifyErrorMes(String expectedResult){
        String actualResult = Action.getText(xpath_MessageProblemAccount);
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void loopVerifyErrorMes(int n_loop, String expectedResult){
        for (int i=0; i<=n_loop; i++){
            verifyErrorMes(expectedResult);
        }
    }

    public void verifyWelcomeMes(String expectedResult){
        String actualResult = Action.getText(xpath_WelcomeUserMessage);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
