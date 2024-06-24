package pages;

import base.PageBase;
import enums.TabName;
import models.Ticket;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DriverManagement;
import utils.Action;

public class MyTicketPage extends PageBase {
    String cancelBtn = "//table[@class='MyTable']//tr[td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s']]]]]]//input[contains(@onclick, 'Delete')]";

    public void CancelTicket(Ticket ticket){
        By xpathCancelBtn = By.xpath(String.format(cancelBtn, ticket.getDepartStation().getStationValue(), ticket.getArriveStation().getStationValue(), ticket.getSeatType().getSeatTypeValue(), ticket.getDepartDate(), ticket.getTicketAmount()));
        selectTab(TabName.MYTICKET);
        Action.scrollToElement(xpathCancelBtn);
        Action.click(xpathCancelBtn);

        DriverManagement.driver.switchTo().alert().accept();
    }

    public void verifyTicketNoDisplay(Ticket ticket){
        By xpathCancelBtn = By.xpath(String.format(cancelBtn, ticket.getDepartStation().getStationValue(), ticket.getArriveStation().getStationValue(), ticket.getSeatType().getSeatTypeValue(), ticket.getDepartDate(), ticket.getTicketAmount()));
        Boolean isDisplay = Action.isDisplay(xpathCancelBtn);
        Assert.assertFalse(isDisplay);
    }
}
