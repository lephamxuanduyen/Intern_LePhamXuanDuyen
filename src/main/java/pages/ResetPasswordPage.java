package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverManagement;
import utils.SeleniumHelper;

public class ResetPasswordPage extends PageBase {
    protected static By xpath_resetPwdLink = By.xpath("//div[@id=\"content\"]//a[text()='Forgot Password page']");
    protected static By xpath_mailTxb = By.xpath("//div[@id='content']//form//input[@id='email']");
    protected static By xpath_submitFormBtn = By.xpath("//div[@id='content']//form//input[@type='submit']");
    protected static By xpath_newPwdTxb = By.xpath("//div[@id='content']//form//input[@id='newPassword']");
    protected static By xpath_confirmPwdTxb = By.xpath("//div[@id='content']//form//input[@id='confirmPassword']");
    protected static By xpath_resetPwdBtn = By.xpath("//div[@id='content']//form//input[@type='submit']");
    public static By xpath_message = By.xpath("//div[@id='content']/p[following-sibling::form]");
    public static By xpath_mesErrorConfirmPwd = By.xpath("//div[@id='content']//label[preceding-sibling::input[@id='confirmPassword']]");

    public static void submitPwdResetForm(String email){
        selectTab("Login");
        SeleniumHelper.click(xpath_resetPwdLink);

        SeleniumHelper.enter(xpath_mailTxb, email);
        WebElement submitBtn = DriverManagement.driver.findElement(xpath_submitFormBtn);
        SeleniumHelper.scrollToElement(submitBtn);
        SeleniumHelper.click(xpath_submitFormBtn);
    }

    public static void resetPwd(String newPwd, String confirmPwd){
        SeleniumHelper.enter(xpath_newPwdTxb, newPwd);
        SeleniumHelper.enter(xpath_confirmPwdTxb, confirmPwd);
        WebElement submitBtn = DriverManagement.driver.findElement(xpath_resetPwdBtn);
        SeleniumHelper.scrollToElement(submitBtn);
        SeleniumHelper.click(xpath_resetPwdBtn);
    }
}
