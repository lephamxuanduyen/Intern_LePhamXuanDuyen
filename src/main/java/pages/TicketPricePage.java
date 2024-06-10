package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.SeluniumHelper;

import java.time.Duration;

public class TicketPricePage extends BasePage {
    protected static String xpath_bookTicketBtn = "//table//tr[td[text()='%s']]//a[text()='Book ticket']";

    public static void bookTicket(String seatType){
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath_bookTicketBtn, seatType))));
        SeluniumHelper.scrollToElement(btn);
        btn.click();
    }
}
