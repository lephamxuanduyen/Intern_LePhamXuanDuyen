package pages;

import base.PageBase;
import models.Ticket;
import org.openqa.selenium.By;
import utils.Action;

public class BookTicketsPage extends PageBase {
    String txb = "//select[@name='%s']";
    By submitFormBtn = By.xpath("//input[@type='submit']");
    String infoBookTicketSucc = "//table//td[count(//th[text()='%s']/preceding-sibling::th) + 1]";
    public By message = By.xpath("//div[@id='content']/h1");
    public By mesBookTicketSucc = By.xpath("//div[@id='content']/h1");

    public void bookTicket(Ticket ticket){
        selectValue("DepartStation", ticket.getDepartStation());
        selectValue("Date", ticket.getDepartDate());
        selectValue("SeatType", ticket.getSeatType());
        selectValue("TicketAmount", ticket.getTicketAmount());
        selectValue("ArriveStation", ticket.getArriveStation());
        submitForm();
    }

    public void selectValue(String field, String value){
        Action.select(By.xpath(String.format(txb, field)), value);
    }

    public void submitForm(){
        Action.click(submitFormBtn);
    }

    public String getInfoBookTicketSucc(String info){
        return Action.getText(By.xpath(String.format(infoBookTicketSucc, info)));
    }
}
