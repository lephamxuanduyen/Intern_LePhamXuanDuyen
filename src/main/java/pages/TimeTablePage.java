package pages;

import base.PageBase;
import org.openqa.selenium.By;
import utils.Action;

public class TimeTablePage extends PageBase {
    String Btn = "//table//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[(text()='%s')]";

    public void checkTicket(String departStation, String arriveStation){
        By checkPriceBtn = By.xpath(String.format(Btn, departStation, arriveStation, "check price"));
        selectTab("Timetable");
        Action.scrollToElement(checkPriceBtn);
        Action.click(checkPriceBtn);
    }

    public void bookTicket(String departStation, String arriveStation){
        By bookTicketBtn = By.xpath(String.format(Btn, departStation, arriveStation, "book ticket"));
        selectTab("Timetable");
        Action.scrollToElement(bookTicketBtn);
        Action.click(bookTicketBtn);
    }
}
