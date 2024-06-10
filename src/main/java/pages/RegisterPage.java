package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.SeluniumHelper;

import java.time.Instant;
import java.util.Properties;

import java.time.Duration;

public class RegisterPage extends BasePage {
    protected static By xpath_email = By.xpath("//form[@id='RegisterForm']//li//input[@id='email']");
    protected static By xpath_passwword = By.xpath("//form[@id='RegisterForm']//li//input[@id='password']");
    protected static By xpath_confirmPwd = By.xpath("//form[@id='RegisterForm']//li//input[@id='confirmPassword']");
    protected static By xpath_pid = By.xpath("//form[@id='RegisterForm']//li//input[@id='pid']");
    protected static By xpath_registerBtn = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");

    public static void submitRegisterForm(String email, String pwd, String pid){
        SeluniumHelper.enter(xpath_email, email);
        SeluniumHelper.enter(xpath_passwword, pwd);
        SeluniumHelper.enter(xpath_confirmPwd, pwd);
        SeluniumHelper.enter(xpath_pid, pid);
        SeluniumHelper.click(xpath_registerBtn);
    }

    public static void register(String email, String pwd, String pid){
        selectTab("Register");
        submitRegisterForm(email, pwd, pid);
    }

    public static void registerWithNoActiveMail(String pwd, String pid, String emailConfirmInstruction){
        MailPage mailPage = new MailPage();
        mailPage.openMailPage();
        String email = mailPage.getFreeMail();

        switchToRailway();
        register(email, pwd, pid);

        mailPage.switchToMailPage();
        mailPage.confirmAccRegistered(emailConfirmInstruction);
    }
}
