package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.Action;

public class ResetPasswordPage extends PageBase {
    By xpath_resetPwdLink = By.xpath("//div[@id=\"content\"]//a[text()='Forgot Password page']");
    By xpath_mailTxb = By.xpath("//div[@id='content']//form//input[@id='email']");
    By xpath_submitFormBtn = By.xpath("//div[@id='content']//form//input[@type='submit']");
    By xpath_newPwdTxb = By.xpath("//div[@id='content']//form//input[@id='newPassword']");
    By xpath_confirmPwdTxb = By.xpath("//div[@id='content']//form//input[@id='confirmPassword']");
    By xpath_resetPwdBtn = By.xpath("//div[@id='content']//form//input[@type='submit']");
    public By xpath_message = By.xpath("//div[@id='content']/p[following-sibling::form]");
    public By xpath_mesErrorConfirmPwd = By.xpath("//div[@id='content']//label[preceding-sibling::input[@id='confirmPassword']]");
    public By xpath_resetTokenTxb = By.xpath("//div[@id='content']//form//input[@id='resetToken']");

    public void submitPwdResetForm(String email){
        selectTab("Login");
        Action.click(xpath_resetPwdLink);

        Action.enter(xpath_mailTxb, email);
        Action.scrollToElement(xpath_submitFormBtn);
        Action.click(xpath_submitFormBtn);
    }

    public void resetPwd(String newPwd, String confirmPwd){
        Action.enter(xpath_newPwdTxb, newPwd);
        Action.enter(xpath_confirmPwdTxb, confirmPwd);
        Action.scrollToElement(xpath_resetPwdBtn);
        Action.click(xpath_resetPwdBtn);
    }
}
