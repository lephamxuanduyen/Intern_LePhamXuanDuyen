package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.Action;

public class TicketPricePage extends PageBase {
    public By header = By.xpath("//div[@id='content']//h1");
    public By tableHeader = By.xpath("//div[@id='content']//table//tr[@class='TableSmallHeader']/th");
    String infoPriceBySeatType = "//div[@id='content']//table//tr/th[contains(text(), 'Price (VND)')]/following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";

    public String getPriceBySeatType(String info){
        return Action.getText(By.xpath(String.format(infoPriceBySeatType, info)));
    }
}
