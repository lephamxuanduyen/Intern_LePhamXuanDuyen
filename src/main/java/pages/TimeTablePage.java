package pages;

import base.BasePage;
import org.openqa.selenium.By;
import utils.SeluniumHelper;

public class TimeTablePage extends BasePage {
    protected static String xpath_checkPriceBtn = "//table//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[(text()='check price')]";

    public static void checkTicket(String departStation, String arriveStation){
        selectTab("Timetable");
        SeluniumHelper.click(By.xpath(String.format(xpath_checkPriceBtn, departStation, arriveStation)));
    }
}
