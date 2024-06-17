package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.time.Duration;

public class MailPage extends PageBase {
    By xpath_CbxScrambleAddress = By.xpath("//label[text()=' Scramble Address']");
    By xpath_Email = By.xpath("//span[@id='email-widget']");
    String xpath_emailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]";
    By xpath_linkConfirm = By.xpath("//div[@class='email_body']//a");
    By xpath_mailName = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']");
    By xpath_mailNameTxb = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']/input[@type='text']");
    By xpath_setBtn = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']/button[text()='Set']");
    By xpath_mailDomain = By.xpath("//div[@id='guerrilla_mail']//select");
    String xpath_cbxMailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]//input";
    By xpath_deleteMailBtn = By.xpath("//input[@value='Delete']");
    By xpath_linkBackToInbox = By.xpath("//div[@class='email_page']//a[@id='back_to_inbox_link']");

    public String getFreeMail(){
        SeleniumHelper.click(xpath_CbxScrambleAddress);
        return SeleniumHelper.getText(xpath_Email);
    }

    public void confirmAccount(String mailConfirm){
        DriverManagement.driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath_emailConfirm,mailConfirm))));
        SeleniumHelper.click(By.xpath(String.format(xpath_emailConfirm,mailConfirm)));
        wait.until(ExpectedConditions.elementToBeClickable(xpath_linkConfirm));
        SeleniumHelper.scroll(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath_linkConfirm)).click();
    }

    public void deleteMail(String mailConfirm){
        switchToMailPage();
        DriverManagement.driver.navigate().refresh();
        SeleniumHelper.click(xpath_linkBackToInbox);
        SeleniumHelper.click(By.xpath(String.format(xpath_cbxMailConfirm, mailConfirm)));
        SeleniumHelper.click(xpath_deleteMailBtn);
    }

    public void selectMailbox(String mailName, String mailDomain){
        SeleniumHelper.select(xpath_mailDomain, mailDomain);
        SeleniumHelper.click(xpath_mailName);
        SeleniumHelper.enter(xpath_mailNameTxb, mailName);
        SeleniumHelper.click(xpath_setBtn);
    }
}