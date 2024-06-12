package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.SeleniumHelper;

public class LoginPage extends PageBase {
    protected static By xpath_emailTxb = By.xpath("//form//input[@id='username']");
    protected static By xpath_pwdtxb = By.xpath("//form//input[@id='password']");
    protected static By xpath_loginBtn = By.xpath("//form//input[@type='submit']");

    public static void submitLoginForm(String email, String pwd){
        SeleniumHelper.enter(xpath_emailTxb, email);
        SeleniumHelper.enter(xpath_pwdtxb, pwd);
        SeleniumHelper.click(xpath_loginBtn);
    }

    public static void login(String email, String pwd){
        selectTab("Login");
        submitLoginForm(email, pwd);
    }
}
