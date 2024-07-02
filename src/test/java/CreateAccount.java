import base.PageBase;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MailPage;
import pages.RegisterPage;
import utils.Action;
import utils.listeners.ReportListener;

@Listeners(ReportListener.class)
public class CreateAccount extends TestBase {
    private PageBase pageBase = new PageBase();
    private RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();

    @Test(description = "User can't create account with an already in-use email")
    void RegisterWithUsedEmail() {
        User user = new User(validEmail, validPwd, validPid);
        registerPage.register(user);

        String expectedResult = "This email address is already in use.";
        String actualResult = Action.getText(registerPage.messageProblemAccount);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    void RegisterWithEmptyField() {
        MailPage mailPage = new MailPage();
        mailPage.openMailPage();
        String email = mailPage.getFreeMail();

        User user = new User(email, "", "");

        pageBase.switchToRailway();
        registerPage.register(user);

        String expectedMesProblem = "There're errors in the form. Please correct the errors and try again.";
        String expectedMesInvalidPwd = "Invalid password length.";
        String expectedMesInvalidPid = "Invalid ID length.";

        String actualMesProblem = Action.getText(registerPage.messageProblemAccount);
        String actualMesInvalidPwd = Action.getText(registerPage.messageInvalidPwd);
        String actualMesInvalidPid = Action.getText(registerPage.messageInvalidPid);

        SoftAssert softAssertions = new SoftAssert();

        softAssertions.assertEquals(expectedMesProblem, actualMesProblem);
        softAssertions.assertEquals(expectedMesInvalidPwd, actualMesInvalidPwd);
        softAssertions.assertEquals(expectedMesInvalidPid, actualMesInvalidPid);

        softAssertions.assertAll();
    }

    @Test(description = "User create and active account")
    void RegisterWithActiveAccount() {
        mailPage.openMailPage();
        String thisEmail = mailPage.getFreeMail();
        User user = new User(thisEmail, validPwd, validPid);

        registerPage.switchToRailway();
        registerPage.register(user);
        mailPage.switchToMailPage();
        mailPage.confirmAccount(emailConfirmInstruction);
        mailPage.deleteMail(emailConfirmInstruction);

        Action.switchOtherTab(mailPage, pageBase);

        String actualResult = Action.getText(registerPage.messageRegisterSucc);
        String expextedResult = "Registration Confirmed! You can now log in to the site";
        Assert.assertEquals(actualResult, expextedResult);
    }
}
