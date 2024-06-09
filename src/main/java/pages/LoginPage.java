package pages;

import base.BasePage;
import org.openqa.selenium.By;
import utils.DriverManagement;

public class LoginPage extends BasePage {
    protected static By xpath_emailTxb = By.xpath("//form//input[@id='username']");
    protected static By xpath_pwdtxb = By.xpath("//form//input[@id='password']");
    protected static By xpath_loginBtn = By.xpath("//form//input[@type='submit']");

    public static void login(String email, String pwd){
        selectTab("Login");
        enterTxt(xpath_emailTxb, email);
        enterTxt(xpath_pwdtxb, pwd);
        clickElement(xpath_loginBtn);
    }
}
