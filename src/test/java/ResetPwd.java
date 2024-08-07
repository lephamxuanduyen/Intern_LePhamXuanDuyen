import base.PageBase;
import enums.TabName;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MailPage;
import pages.ResetPasswordPage;
import utils.Action;
import utils.listeners.ReportListener;

@Listeners(ReportListener.class)
public class ResetPwd extends TestBase {
    private PageBase pageBase = new PageBase();
    private ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    private MailPage mailPage = new MailPage();

    @Test(description = "Reset password shows error if the new password is same as current")
    void ResetPwd() {
        resetPasswordPage.selectTab(TabName.LOGIN);
        resetPasswordPage.submitPwdResetForm(validEmail);

        mailPage.openMailPage();
        mailPage.selectMailbox(mailName, mailDomain);
        mailPage.confirmAccount(emailConfirmInstruction);
        mailPage.deleteMail(emailConfirmInstruction);

        Action.switchOtherTab(mailPage, pageBase);

        Assert.assertNotNull(Action.getText(resetPasswordPage.resetTokenTxb));

        resetPasswordPage.resetPwd(validPwd, validPwd);
        String actualMessage = Action.getText(resetPasswordPage.message);
        String expectedMessage = "The new password cannot be the same with the current password";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(description = "Reset password shows error if the new password and confirm password doesn't match")
    void ResetPwdDoesNotMatch() {
        resetPasswordPage.selectTab(TabName.LOGIN);
        resetPasswordPage.submitPwdResetForm(validEmail);

        mailPage.openMailPage();
        mailPage.selectMailbox(mailName, mailDomain);
        mailPage.confirmAccount(emailConfirmInstruction);
        mailPage.deleteMail(emailConfirmInstruction);

        Action.switchOtherTab(mailPage, pageBase);

        Assert.assertNotNull(Action.getText(resetPasswordPage.resetTokenTxb));

        String newPassword = "789456123";
        String confirmPassword = "123456789";

        resetPasswordPage.resetPwd(newPassword, confirmPassword);
        String actualMessage = Action.getText(resetPasswordPage.message);
        String expectedMessage = "Could not reset password. Please correct the errors and try again.";
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualErrorConfirmPwd = Action.getText(resetPasswordPage.mesErrorConfirmPwd);
        String expectedErrorConfirmPwd = "The password confirmation did not match the new password.";

        Assert.assertEquals(actualErrorConfirmPwd, expectedErrorConfirmPwd);
    }
}
