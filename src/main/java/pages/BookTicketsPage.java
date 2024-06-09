package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class BookTicketsPage extends BasePage {
    protected static By xpath_DepartDateTxb = By.xpath("//form//select[@name='Date']");
    protected static By xpath_DepartStationTxb = By.xpath("//form//select[@name='DepartStation']");
    protected static By xpath_arriveStationTxb = By.xpath("//form//select[@name='ArriveStation']");
    protected static By xpath_seatTypeTxb = By.xpath("//form//select[@name='SeatType']");
    protected static By xpath_ticketAmountTxb = By.xpath("//form//select[@name='TicketAmount']");
    protected static By xpath_submitFormBtn = By.xpath("//form//input[@type='submit']");

    public static void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount){
        if (departDate!=null) {enterTxt(xpath_DepartDateTxb, departDate);}
        if (departStation!=null) { enterTxt(xpath_DepartStationTxb, departStation); }
        if (arriveStation!=null) { enterTxt(xpath_arriveStationTxb, arriveStation); }
        if (seatType!=null) { enterTxt(xpath_seatTypeTxb, seatType); }
        if (ticketAmount!=null) { enterTxt(xpath_ticketAmountTxb, ticketAmount); }
        clickElement(xpath_submitFormBtn);
    }
}
