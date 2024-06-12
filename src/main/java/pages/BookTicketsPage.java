package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManagement;
import utils.SeleniumHelper;

import java.time.Duration;
import java.util.ArrayList;

public class BookTicketsPage extends PageBase {
    protected static String xpath_DepartDateTxb = "//form//select[@name='Date']";
    protected static String xpath_DepartStationTxb = "//form//select[@name='DepartStation']";
    protected static String xpath_arriveStationTxb = "//form//select[@name='ArriveStation']";
    protected static String xpath_seatTypeTxb = "//form//select[@name='SeatType']";
    protected static String xpath_ticketAmountTxb = "//form//select[@name='TicketAmount']";
    protected static By xpath_submitFormBtn = By.xpath("//form//input[@type='submit']");
    protected static String xpath_infoBookTicketSucc = "//table//td[count(//th[text()='%s']/preceding-sibling::th) + 1]";

    public static By xpath_MesBookTicketSucc = By.xpath("//div[@id='content']/h1");

    public static void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount){
        if (departDate!=null) {SeleniumHelper.select(xpath_DepartDateTxb, departDate);}
        if (departStation!=null) { SeleniumHelper.select(xpath_DepartStationTxb, departStation); }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (arriveStation!=null) { SeleniumHelper.select(xpath_arriveStationTxb, arriveStation); }
        if (seatType!=null) { SeleniumHelper.select(xpath_seatTypeTxb, seatType); }
        if (ticketAmount!=null) { SeleniumHelper.select(xpath_ticketAmountTxb, ticketAmount); }
        SeleniumHelper.click(xpath_submitFormBtn);
    }

    public static String getInfoBookTicketSucc(String info){
        return SeleniumHelper.getText(By.xpath(String.format(xpath_infoBookTicketSucc, info)));
    }
}
