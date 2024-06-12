package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.time.Duration;

public class TicketPricePage extends PageBase {
    protected static String xpath_bookTicketBtn = "//table//tr[td[text()='%s']]//a[text()='Book ticket']";
    public static By xpath_header = By.xpath("//div[@id='content']//h1");
    public static By xpath_tableHeader = By.xpath("//div[@id='content']//table//tr[@class='TableSmallHeader']/th");
    protected static String xpath_infoPriceBySeatType = "//div[@id='content']//table//tr/th[contains(text(), 'Price (VND)')]/following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";

    public static void bookTicket(String seatType){
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath_bookTicketBtn, seatType))));
        SeleniumHelper.scrollToElement(btn);
        btn.click();
    }

    public static String getPriceBySeatType(String info){
        return SeleniumHelper.getText(By.xpath(String.format(xpath_infoPriceBySeatType, info)));
    }
}
