package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.DriverManagement;
import utils.SeleniumHelper;

public class TimeTablePage extends PageBase {
    protected static String xpath_checkPriceBtn = "//table//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[(text()='check price')]";
    protected static String xpath_bookTicketBtn = "//table//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[(text()='book ticket')]";

    public static void checkTicket(String departStation, String arriveStation){
        selectTab("Timetable");
        SeleniumHelper.scrollToElement(DriverManagement.driver.findElement(By.xpath(String.format(xpath_checkPriceBtn, departStation, arriveStation))));
        SeleniumHelper.click(By.xpath(String.format(xpath_checkPriceBtn, departStation, arriveStation)));
    }

    public static void bookTicket(String departStation, String arriveStation){
        selectTab("Timetable");
        SeleniumHelper.scrollToElement(DriverManagement.driver.findElement(By.xpath(String.format(xpath_bookTicketBtn, departStation, arriveStation))));
        SeleniumHelper.click(By.xpath(String.format(xpath_bookTicketBtn, departStation, arriveStation)));
    }
}
