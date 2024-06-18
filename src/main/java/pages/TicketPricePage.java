package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.Action;

import java.time.Duration;

public class TicketPricePage extends PageBase {
    String bookTicketBtn = "//table//tr[td[text()='%s']]//a[text()='Book ticket']";
    public By header = By.xpath("//div[@id='content']//h1");
    public By tableHeader = By.xpath("//div[@id='content']//table//tr[@class='TableSmallHeader']/th");
    String infoPriceBySeatType = "//div[@id='content']//table//tr/th[contains(text(), 'Price (VND)')]/following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";

    public void bookTicket(String seatType){
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(bookTicketBtn, seatType))));
        Action.scrollToElement(By.xpath(String.format(bookTicketBtn, seatType)));
        btn.click();
    }

    public String getPriceBySeatType(String info){
        return Action.getText(By.xpath(String.format(infoPriceBySeatType, info)));
    }
}
