import base.PageBase;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MailPage;
import pages.RegisterPage;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.util.Set;

public class CreateAccount extends TestBase{
    private PageBase pageBase = new PageBase();
    private RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();

    @Test(description = "User can't create account with an already in-use email")
    void TC007(){
        User user = new User(validEmail, validPwd, validPid);
        registerPage.register(user);

        String expectedResult = "This email address is already in use.";
        String actualResult = SeleniumHelper.getText(registerPage.xpath_MessageProblemAccount);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    void TC008(){
        MailPage mailPage = new MailPage();
        mailPage.openMailPage();
        String email = mailPage.getFreeMail();

        User user = new User(email, "", "");

        pageBase.switchToRailway();
        registerPage.register(user);

        String expectedMesProblem = "There're errors in the form. Please correct the errors and try again.";
        String expectedMesInvalidPwd = "Invalid password length.";
        String expectedMesInvalidPid = "Invalid ID length.";

        String actualMesProblem = SeleniumHelper.getText(registerPage.xpath_MessageProblemAccount);
        String actualMesInvalidPwd = SeleniumHelper.getText(registerPage.xpath_messageInvalidPwd);
        String actualMesInvalidPid = SeleniumHelper.getText(registerPage.xpath_messageInvalidPid);

        SoftAssert softAssertions = new SoftAssert();

        softAssertions.assertEquals(expectedMesProblem, actualMesProblem);
        softAssertions.assertEquals(expectedMesInvalidPwd, actualMesInvalidPwd);
        softAssertions.assertEquals(expectedMesInvalidPid, actualMesInvalidPid);

        softAssertions.assertAll();
    }

    @Test(description = "User create and activate account")
    void TC009(){
        mailPage.openMailPage();
        String thisEmail = mailPage.getFreeMail();
        User user = new User(thisEmail, validPwd, validPid);

        registerPage.switchToRailway();
        registerPage.register(user);
        mailPage.switchToMailPage();
        mailPage.confirmAccount(emailConfirmInstruction);
        mailPage.deleteMail(emailConfirmInstruction);

        SeleniumHelper.switchOtherTab(mailPage, pageBase);

        String actualResult = SeleniumHelper.getText(registerPage.xpath_messageRegisterSucc);
        String expextedResult = "Registration Confirmed! You can now log in to the site";
        Assert.assertEquals(actualResult, expextedResult);
    }
}
