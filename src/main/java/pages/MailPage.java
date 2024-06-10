package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constant;
import utils.DriverManagement;
import utils.SeluniumHelper;

import java.time.Duration;

public class MailPage {
    protected static By xpath_CbxScrambleAddress = By.xpath("//label[text()=' Scramble Address']");
    protected static By xpath_Email = By.xpath("//span[@id='email-widget']");
    protected static String mailPage;
    protected static String xpath_emailConfirm = "//tbody[@id='email_list']//tr[td[text()='%s']]";
    protected static By xpath_linkConfirm = By.xpath("//div[@class='email_body']//a");

    public static void openMailPage(){
        DriverManagement.driver.switchTo().newWindow(WindowType.TAB);
        DriverManagement.driver.get(Constant.TempMail);
        mailPage = DriverManagement.driver.getWindowHandle();
    }

    public static void switchToMailPage(){
        DriverManagement.driver.switchTo().window(mailPage);
    }

    public static String getFreeMail(){
        DriverManagement.driver.findElement(xpath_CbxScrambleAddress).click();
        return SeluniumHelper.getText(xpath_Email);
    }

    public static void confirmAccRegistered(String mailConfirm){
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath_emailConfirm,mailConfirm)))).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpath_linkConfirm)).click();
    }
}