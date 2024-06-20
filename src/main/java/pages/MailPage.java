package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.Action;

import java.time.Duration;

public class MailPage extends PageBase {
    By cbxScrambleAddress = By.xpath("//label[text()=' Scramble Address']");
    By email = By.xpath("//span[@id='email-widget']");
    String emailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]";
    By linkConfirm = By.xpath("//div[@class='email_body']//a");
    By mailNameBtn = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']");
    By mailNameTxb = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']/input[@type='text']");
    By setBtn = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']/button[text()='Set']");
    By mailDomainSelect = By.xpath("//div[@id='guerrilla_mail']//select");
    String cbxMailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]//input";
    By deleteMailBtn = By.xpath("//input[@value='Delete']");
    By linkBackToInbox = By.xpath("//div[@class='email_page']//a[@id='back_to_inbox_link']");

    public String getFreeMail(){
        Action.click(cbxScrambleAddress);
        return Action.getText(email);
    }

    public void confirmAccount(String mailConfirm){
        DriverManagement.driver.navigate().refresh();
        DriverManagement.waitElementToBeClickable(By.xpath(String.format(emailConfirm,mailConfirm)), 20).click();
        Action.scrollY(200);
        DriverManagement.waitElementToBeClickable(linkConfirm, 5).click();
    }

    public void deleteMail(String mailConfirm){
        switchToMailPage();
        DriverManagement.driver.navigate().refresh();
        Action.click(linkBackToInbox);
        Action.click(By.xpath(String.format(cbxMailConfirm, mailConfirm)));
        Action.click(deleteMailBtn);
    }

    public void selectMailbox(String mailName, String mailDomain){
        Action.select(mailDomainSelect, mailDomain);
        Action.click(mailNameBtn);
        Action.enter(mailNameTxb, mailName);
        Action.click(setBtn);
    }
}