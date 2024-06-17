import base.PageBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MailPage;
import pages.ResetPasswordPage;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.util.Set;

public class ResetPwd extends TestBase{
    private PageBase pageBase = new PageBase();
    private ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    private MailPage mailPage = new MailPage();

    @Test(description = "Reset password shows error if the new password is same as current")
    void TC010(){
        resetPasswordPage.selectTab("Login");
        resetPasswordPage.submitPwdResetForm(validEmail);

        mailPage.openMailPage();
        mailPage.selectMailbox(mailName, mailDomain);
        mailPage.confirmAccount(emailConfirmInstruction);
        mailPage.deleteMail(emailConfirmInstruction);

        SeleniumHelper.switchOtherTab(mailPage, pageBase);

        Assert.assertNotNull(SeleniumHelper.getText(resetPasswordPage.xpath_resetTokenTxb));

        resetPasswordPage.resetPwd(validPwd, validPwd);
        String actualMessage = SeleniumHelper.getText(resetPasswordPage.xpath_message);
        String expectedMessage = "The new password cannot be the same with the current password";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(description = "Reset password shows error if the new password and confirm password doesn't match")
    void TC011(){
        resetPasswordPage.selectTab("Login");
        resetPasswordPage.submitPwdResetForm(validEmail);

        mailPage.openMailPage();
        mailPage.selectMailbox(mailName, mailDomain);
        mailPage.confirmAccount(emailConfirmInstruction);
        mailPage.deleteMail(emailConfirmInstruction);

        SeleniumHelper.switchOtherTab(mailPage, pageBase);

        Assert.assertNotNull(SeleniumHelper.getText(resetPasswordPage.xpath_resetTokenTxb));

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
