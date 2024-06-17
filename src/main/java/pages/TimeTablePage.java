package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.DriverManagement;
import utils.SeleniumHelper;

public class TimeTablePage extends PageBase {
    String xpath_checkPriceBtn = "//table//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[(text()='check price')]";
    String xpath_bookTicketBtn = "//table//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[(text()='book ticket')]";

    public void checkTicket(String departStation, String arriveStation){
        selectTab("Timetable");
        SeleniumHelper.scrollToElement(By.xpath(String.format(xpath_checkPriceBtn, departStation, arriveStation)));
        SeleniumHelper.click(By.xpath(String.format(xpath_checkPriceBtn, departStation, arriveStation)));
    }

    public void bookTicket(String departStation, String arriveStation){
        selectTab("Timetable");
        SeleniumHelper.scrollToElement(By.xpath(String.format(xpath_bookTicketBtn, departStation, arriveStation)));
        SeleniumHelper.click(By.xpath(String.format(xpath_bookTicketBtn, departStation, arriveStation)));
    }
}
