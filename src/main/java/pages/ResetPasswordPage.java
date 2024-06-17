package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.SeleniumHelper;

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
        SeleniumHelper.click(xpath_resetPwdLink);

        SeleniumHelper.enter(xpath_mailTxb, email);
        SeleniumHelper.scrollToElement(xpath_submitFormBtn);
        SeleniumHelper.click(xpath_submitFormBtn);
    }

    public void resetPwd(String newPwd, String confirmPwd){
        SeleniumHelper.enter(xpath_newPwdTxb, newPwd);
        SeleniumHelper.enter(xpath_confirmPwdTxb, confirmPwd);
        SeleniumHelper.scrollToElement(xpath_resetPwdBtn);
        SeleniumHelper.click(xpath_resetPwdBtn);
    }
}
