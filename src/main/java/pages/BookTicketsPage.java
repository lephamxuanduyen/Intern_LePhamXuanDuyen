package pages;

import base.PageBase;
import models.Ticket;
import org.openqa.selenium.By;
import utils.Action;

public class BookTicketsPage extends PageBase {
    By xpath_DepartDateTxb = By.xpath("//form//select[@name='Date']");
    By xpath_DepartStationTxb = By.xpath("//form//select[@name='DepartStation']");
    By xpath_arriveStationTxb = By.xpath("//form//select[@name='ArriveStation']");
    By xpath_seatTypeTxb = By.xpath("//form//select[@name='SeatType']");
    By xpath_ticketAmountTxb = By.xpath("//form//select[@name='TicketAmount']");
    By xpath_submitFormBtn = By.xpath("//form//input[@type='submit']");
    String xpath_infoBookTicketSucc = "//table//td[count(//th[text()='%s']/preceding-sibling::th) + 1]";
    public By xpath_Message = By.xpath("//div[@id='content']/h1");

    public By xpath_MesBookTicketSucc = By.xpath("//div[@id='content']/h1");

    public void bookTicket(Ticket ticket){
        if (ticket.getDepartDate()!=null) {Action.enter(xpath_DepartDateTxb, ticket.getDepartDate());}
        if (ticket.getDepartStation()!=null) { Action.enter(xpath_DepartStationTxb, ticket.getDepartStation()); }
        if (ticket.getSeatType()!=null) { Action.enter(xpath_seatTypeTxb, ticket.getSeatType()); }
        if (ticket.getTicketAmount()!=null) { Action.select(xpath_ticketAmountTxb, ticket.getTicketAmount()); }
        if (ticket.getArriveStation()!=null) { Action.enter(xpath_arriveStationTxb, ticket.getArriveStation()); }
        Action.click(xpath_submitFormBtn);
    }

    public String getInfoBookTicketSucc(String info){
        return Action.getText(By.xpath(String.format(xpath_infoBookTicketSucc, info)));
    }
}
