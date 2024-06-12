import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MailPage;
import pages.RegisterPage;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.util.Set;

public class Chapter10_createAccount extends TestBase{
    private RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();

    private String activeEmail = "lephamxuanduyen@gmail.com";

    @Test
    void TC007(){
        registerPage.register(activeEmail, validPwd, validPid);

        String expectedResult = "This email address is already in use.";
        String actualResult = SeleniumHelper.getText(registerPage.xpath_MessageProblemAccount);

        Assert.assertEquals(actualResult, expectedResult,"aaa");
    }

    @Test
    void TC008(){
        registerPage.registerWithTempMail("", "");

        String actualMesProblem = SeleniumHelper.getText(registerPage.xpath_MessageProblemAccount);
        String actualMesInvalidPwd = SeleniumHelper.getText(registerPage.xpath_messageInvalidPwd);
        String actualMesInvalidPid = SeleniumHelper.getText(registerPage.xpath_messageInvalidPid);

        String expectedMesProblem = "There're errors in the form. Please correct the errors and try again.";
        String expectedMesInvalidPwd = "Invalid password length.";
        String expectedMesInvalidPid = "Invalid ID length.";

        SoftAssert softAssertions = new SoftAssert();

        softAssertions.assertEquals(expectedMesProblem, actualMesProblem);
        softAssertions.assertEquals(expectedMesInvalidPwd, actualMesInvalidPwd);
        softAssertions.assertEquals(expectedMesInvalidPid, actualMesInvalidPid);

        softAssertions.assertAll();
    }

    @Test
    void TC009(){
        mailPage.openMailPage();
        String thisEmail = mailPage.getFreeMail();

        registerPage.switchToRailway();
        registerPage.register(thisEmail, validPwd, validPid);
        mailPage.switchToMailPage();
        mailPage.confirmAccount(emailConfirmInstruction);

        Set<String> allTabs = DriverManagement.driver.getWindowHandles();

        for (String tab : allTabs) {
            if (!tab.equals(mailPage.tempMailWindow) && !tab.equals(registerPage.RailwayWindow)) {
                DriverManagement.driver.switchTo().window(tab);
                break;
            }
        }

        String actualResult = SeleniumHelper.getText(registerPage.xpath_messageRegisterSucc);
        String expextedResult = "Registration Confirmed! You can now log in to the site";
        Assert.assertEquals(actualResult, expextedResult);
    }
}
