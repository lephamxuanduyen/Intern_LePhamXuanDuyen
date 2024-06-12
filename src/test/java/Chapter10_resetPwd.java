import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MailPage;
import pages.ResetPasswordPage;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.util.Set;

public class Chapter10_resetPwd extends TestBase{
    private ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    private MailPage mailPage = new MailPage();

    @Test
    void TC010(){
        resetPasswordPage.selectTab("Login");
        resetPasswordPage.submitPwdResetForm(validEmail);

        mailPage.openMailPage();
        mailPage.selectMailbox(mailName, mailDomain);
        mailPage.confirmAccount(emailConfirmInstruction);

        Set<String> allTabs = DriverManagement.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mailPage.tempMailWindow) && !tab.equals(resetPasswordPage.RailwayWindow)) {
                DriverManagement.driver.switchTo().window(tab);
                break;
            }
        }

        By xpath_resetTokenTxb = By.xpath("//div[@id='content']//form//input[@id='resetToken']");
        Assert.assertNotNull(SeleniumHelper.getText(xpath_resetTokenTxb));

        resetPasswordPage.resetPwd(validPwd, validPwd);
        String actualMessage = SeleniumHelper.getText(resetPasswordPage.xpath_message);
        String expectedMessage = "The new password cannot be the same with the current password";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void TC011(){
        resetPasswordPage.selectTab("Login");
        resetPasswordPage.submitPwdResetForm(validEmail);

        mailPage.openMailPage();
        mailPage.selectMailbox(mailName, mailDomain);
        mailPage.confirmAccount(emailConfirmInstruction);

        Set<String> allTabs = DriverManagement.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mailPage.tempMailWindow) && !tab.equals(resetPasswordPage.RailwayWindow)) {
                DriverManagement.driver.switchTo().window(tab);
                break;
            }
        }

        By xpath_resetTokenTxb = By.xpath("//div[@id='content']//form//input[@id='resetToken']");
        Assert.assertNotNull(SeleniumHelper.getText(xpath_resetTokenTxb));

        String newPassword = "789456123";
        String confirmPassword = "123456789";

        resetPasswordPage.resetPwd(newPassword, confirmPassword);
        String actualMessage = SeleniumHelper.getText(resetPasswordPage.xpath_message);
        String expectedMessage = "Could not reset password. Please correct the errors and try again.";
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualErrorConfirmPwd = SeleniumHelper.getText(resetPasswordPage.xpath_mesErrorConfirmPwd);
        String expectedErrorConfirmPwd = "The password confirmation did not match the new password.";

        Assert.assertEquals(actualErrorConfirmPwd, expectedErrorConfirmPwd);
    }
}
