package pages;

import base.PageBase;
import models.Ticket;
import org.openqa.selenium.By;
import utils.Action;

public class BookTicketsPage extends PageBase {
    By departDateTxb = By.xpath("//select[@name='Date']");
    By departStationTxb = By.xpath("//select[@name='DepartStation']");
    By arriveStationTxb = By.xpath("//select[@name='ArriveStation']");
    By seatTypeTxb = By.xpath("//select[@name='SeatType']");
    By ticketAmountSelect = By.xpath("//select[@name='TicketAmount']");
    By submitFormBtn = By.xpath("//input[@type='submit']");
    String infoBookTicketSucc = "//table//td[count(//th[text()='%s']/preceding-sibling::th) + 1]";
    public By message = By.xpath("//div[@id='content']/h1");
    public By mesBookTicketSucc = By.xpath("//div[@id='content']/h1");

    public void bookTicket(Ticket ticket){
        Action.enter(departDateTxb, ticket.getDepartDate());
        Action.enter(departStationTxb, ticket.getDepartStation());
        Action.enter(seatTypeTxb, ticket.getSeatType());
        Action.select(ticketAmountSelect, ticket.getTicketAmount());
        Action.enter(arriveStationTxb, ticket.getArriveStation());
        Action.click(submitFormBtn);
    }

    public String getInfoBookTicketSucc(String info){
        return Action.getText(By.xpath(String.format(infoBookTicketSucc, info)));
    }
}
