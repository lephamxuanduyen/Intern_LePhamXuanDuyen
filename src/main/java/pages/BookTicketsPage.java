package pages;

import base.BasePage;
import org.openqa.selenium.By;
import utils.SeluniumHelper;

public class BookTicketsPage extends BasePage {
    protected static By xpath_DepartDateTxb = By.xpath("//form//select[@name='Date']");
    protected static By xpath_DepartStationTxb = By.xpath("//form//select[@name='DepartStation']");
    protected static By xpath_arriveStationTxb = By.xpath("//form//select[@name='ArriveStation']");
    protected static By xpath_seatTypeTxb = By.xpath("//form//select[@name='SeatType']");
    protected static By xpath_ticketAmountTxb = By.xpath("//form//select[@name='TicketAmount']");
    protected static By xpath_submitFormBtn = By.xpath("//form//input[@type='submit']");

    public static void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount){
        if (departDate!=null) {
            SeluniumHelper.enter(xpath_DepartDateTxb, departDate);}
        if (departStation!=null) { SeluniumHelper.enter(xpath_DepartStationTxb, departStation); }
        if (arriveStation!=null) { SeluniumHelper.enter(xpath_arriveStationTxb, arriveStation); }
        if (seatType!=null) { SeluniumHelper.enter(xpath_seatTypeTxb, seatType); }
        if (ticketAmount!=null) { SeluniumHelper.enter(xpath_ticketAmountTxb, ticketAmount); }
        SeluniumHelper.click(xpath_submitFormBtn);
    }
}
