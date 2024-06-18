package pages;
import base.PageBase;
import models.User;
import org.openqa.selenium.By;
import utils.Action;

public class RegisterPage extends PageBase {
    By xpath_email = By.xpath("//form[@id='RegisterForm']//li//input[@id='email']");
    By xpath_passwword = By.xpath("//form[@id='RegisterForm']//li//input[@id='password']");
    By xpath_confirmPwd = By.xpath("//form[@id='RegisterForm']//li//input[@id='confirmPassword']");
    By xpath_pid = By.xpath("//form[@id='RegisterForm']//li//input[@id='pid']");
    By xpath_registerBtn = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    public By xpath_messageInvalidPwd = By.xpath("//form//label[preceding-sibling::input[@id='password']]");
    public By xpath_messageInvalidPid = By.xpath("//form//label[preceding-sibling::input[@id='pid']]");
    public By xpath_messageRegisterSucc = By.xpath("//div[@id='content']/p");

    public void submitRegisterForm(User user){
        Action.enter(xpath_email, user.getEmail());
        Action.enter(xpath_passwword, user.getPassword());
        Action.enter(xpath_confirmPwd,user.getPassword());
        Action.enter(xpath_pid, user.getPid());
        Action.click(xpath_registerBtn);
    }

    public void register(User user){
        selectTab("Register");
        submitRegisterForm(user);
    }

    public void registerWithTempMail(String pwd, String pid){

    }
}
