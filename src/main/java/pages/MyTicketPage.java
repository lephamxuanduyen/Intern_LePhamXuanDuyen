package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.DriverManagement;
import utils.SeleniumHelper;

public class MyTicketPage extends PageBase {
    public static String xpathCancelBtn = "//div[@id='content']//table[@class='MyTable']//input[@onclick='DeleteTicket(%s);']";

    public static void CancelTicket(String id){
        By xpath_cancelBtn = By.xpath(String.format(xpathCancelBtn, id));
        selectTab("My ticket");
        SeleniumHelper.scrollToElement(DriverManagement.driver.findElement(xpath_cancelBtn));
        SeleniumHelper.click(xpath_cancelBtn);

        DriverManagement.driver.switchTo().alert().accept();
    }
}
