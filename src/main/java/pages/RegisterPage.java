package pages;
import base.PageBase;
import org.openqa.selenium.By;
import utils.SeleniumHelper;

public class RegisterPage extends PageBase {
    protected static By xpath_email = By.xpath("//form[@id='RegisterForm']//li//input[@id='email']");
    protected static By xpath_passwword = By.xpath("//form[@id='RegisterForm']//li//input[@id='password']");
    protected static By xpath_confirmPwd = By.xpath("//form[@id='RegisterForm']//li//input[@id='confirmPassword']");
    protected static By xpath_pid = By.xpath("//form[@id='RegisterForm']//li//input[@id='pid']");
    protected static By xpath_registerBtn = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    public static By xpath_messageInvalidPwd = By.xpath("//form//label[preceding-sibling::input[@id='password']]");
    public static By xpath_messageInvalidPid = By.xpath("//form//label[preceding-sibling::input[@id='pid']]");
    public static By xpath_messageRegisterSucc = By.xpath("//div[@id='content']/p");

    public static void submitRegisterForm(String email, String pwd, String pid){
        SeleniumHelper.enter(xpath_email, email);
        SeleniumHelper.enter(xpath_passwword, pwd);
        SeleniumHelper.enter(xpath_confirmPwd, pwd);
        SeleniumHelper.enter(xpath_pid, pid);
        SeleniumHelper.click(xpath_registerBtn);
    }

    public static void register(String email, String pwd, String pid){
        selectTab("Register");
        submitRegisterForm(email, pwd, pid);
    }

    public static void registerWithTempMail(String pwd, String pid){
        MailPage mailPage = new MailPage();
        mailPage.openMailPage();
        String email = mailPage.getFreeMail();

        switchToRailway();
        register(email, pwd, pid);
    }
}
