package pages;

import base.BasePage;
import org.openqa.selenium.By;
import utils.SeluniumHelper;

public class LoginPage extends BasePage {
    protected static By xpath_emailTxb = By.xpath("//form//input[@id='username']");
    protected static By xpath_pwdtxb = By.xpath("//form//input[@id='password']");
    protected static By xpath_loginBtn = By.xpath("//form//input[@type='submit']");

    public static void submitLoginForm(String email, String pwd){
        SeluniumHelper.enter(xpath_emailTxb, email);
        SeluniumHelper.enter(xpath_pwdtxb, pwd);
        SeluniumHelper.click(xpath_loginBtn);
    }

    public static void login(String email, String pwd){
        selectTab("Login");
        submitLoginForm(email, pwd);
    }
}
