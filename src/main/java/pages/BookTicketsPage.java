package pages;

import base.PageBase;
import models.Ticket;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utils.Action;

public class BookTicketsPage extends PageBase {
    String txb = "//select[@name='%s']";
    By submitFormBtn = By.xpath("//input[@type='submit']");
    String infoBookTicketSucc = "//table//td[count(//th[text()='%s']/preceding-sibling::th) + 1]";
    public By message = By.xpath("//div[@id='content']/h1");
    public By mesBookTicketSucc = By.xpath("//div[@id='content']/h1");

    public void bookTicket(Ticket ticket){
        selectValue("DepartStation", ticket.getDepartStation().getStationValue());
        selectValue("Date", ticket.getDepartDate());
        selectValue("SeatType", ticket.getSeatType().getSeatTypeValue());
        selectValue("TicketAmount", ticket.getTicketAmount());
        selectValue("ArriveStation", ticket.getArriveStation().getStationValue());
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

    public void verifyMesBookSuc(SoftAssert softAssertions, String expectedMes){
        String actualMes = Action.getText(mesBookTicketSucc);
        softAssertions.assertEquals(actualMes, expectedMes);
    }

    public void verifyInfoTicket(SoftAssert softAssertions, Ticket ticket){
        String actualDepartDate = getInfoBookTicketSucc("Depart Date");
        String actualDepartStation = getInfoBookTicketSucc("Depart Station");
        String actualArriveStaion = getInfoBookTicketSucc("Arrive Station");
        String actualSeatType = getInfoBookTicketSucc("Seat Type");
        String actualAmount = getInfoBookTicketSucc("Amount");

        softAssertions.assertEquals(actualDepartDate, ticket.getDepartDate());
        softAssertions.assertEquals(actualDepartStation, ticket.getDepartStation().getStationValue());
        softAssertions.assertEquals(actualArriveStaion, ticket.getArriveStation().getStationValue());
        softAssertions.assertEquals(actualSeatType, ticket.getSeatType().getSeatTypeValue());
        softAssertions.assertEquals(actualAmount, ticket.getTicketAmount());
    }
}
