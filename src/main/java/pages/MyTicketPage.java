package pages;

import base.PageBase;
import models.Ticket;
import org.openqa.selenium.By;
import utils.DriverManagement;
import utils.Action;

public class MyTicketPage extends PageBase {
    String cancelBtn = "//table[@class='MyTable']//tr[td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s']]]]]]//input[contains(@onclick, 'Delete')]";

    public void CancelTicket(Ticket ticket){
        By xpathCancelBtn = By.xpath(String.format(cancelBtn, ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount()));
        selectTab("My ticket");
        Action.scrollToElement(xpathCancelBtn);
        Action.click(xpathCancelBtn);

        DriverManagement.driver.switchTo().alert().accept();
    }

    public void verifyTicketNoDisplay(Ticket ticket){
        By xpathCancelBtn = By.xpath(String.format(cancelBtn, ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount()));
        Action.verifyEleNoDiplay(xpathCancelBtn);
    }
}
