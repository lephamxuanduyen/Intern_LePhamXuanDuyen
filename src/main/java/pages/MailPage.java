package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constant;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.time.Duration;

public class MailPage {
    public static String tempMailWindow;
    protected static By xpath_CbxScrambleAddress = By.xpath("//label[text()=' Scramble Address']");
    protected static By xpath_Email = By.xpath("//span[@id='email-widget']");
    protected static String xpath_emailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]";
    protected static By xpath_linkConfirm = By.xpath("//div[@class='email_body']//a");
    protected static By xpath_mailName = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']");
    protected static By xpath_mailNameTxb = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']/input[@type='text']");
    protected static By xpath_setBtn = By.xpath("//div[@id='guerrilla_mail']//span[@id='inbox-id']/button[text()='Set']");
    protected static String xpath_mailDomain = "//div[@id='guerrilla_mail']//select";
    protected static String xpath_cbxMailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]//input";
    protected static By xpath_deleteMailBtn = By.xpath("//input[@value='Delete']");
    protected static By xpath_linkBackToInbox = By.xpath("//div[@class='email_page']//a[@id='back_to_inbox_link']");


    public static void openMailPage(){
        DriverManagement.driver.switchTo().newWindow(WindowType.TAB);
        DriverManagement.driver.get(Constant.TempMail);
        tempMailWindow = DriverManagement.driver.getWindowHandle();
    }

    public static void switchToMailPage(){
        DriverManagement.driver.switchTo().window(tempMailWindow);
    }

    public static String getFreeMail(){
        SeleniumHelper.click(xpath_CbxScrambleAddress);
        return SeleniumHelper.getText(xpath_Email);
    }

    public static void confirmAccount(String mailConfirm){
        DriverManagement.driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath_emailConfirm,mailConfirm))));
        try {
            Thread.sleep(2500); // Ngủ 2 giây (2000 mili giây)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SeleniumHelper.click(By.xpath(String.format(xpath_emailConfirm,mailConfirm)));
        SeleniumHelper.scrollToElement(wait.until(ExpectedConditions.elementToBeClickable(xpath_linkConfirm)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath_linkConfirm)).click();
        switchToMailPage();
        DriverManagement.driver.navigate().refresh();
        SeleniumHelper.click(xpath_linkBackToInbox);
        SeleniumHelper.click(By.xpath(String.format(xpath_cbxMailConfirm, mailConfirm)));
        SeleniumHelper.click(xpath_deleteMailBtn);
    }

    public static void selectMailbox(String mailName, String mailDomain){
        SeleniumHelper.select(xpath_mailDomain, mailDomain);
        try {
            Thread.sleep(3000); // Ngủ 2 giây (2000 mili giây)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SeleniumHelper.click(xpath_mailName);
        SeleniumHelper.enter(xpath_mailNameTxb, mailName);
        SeleniumHelper.click(xpath_setBtn);
    }
}