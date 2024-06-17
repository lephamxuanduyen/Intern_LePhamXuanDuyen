package pages;

import base.PageBase;
import models.Ticket;
import org.openqa.selenium.By;
import utils.DriverManagement;
import utils.SeleniumHelper;

public class MyTicketPage extends PageBase {
    String strXpathCancelBtn = "//table[@class='MyTable']//tr[td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' and following-sibling::td[text()='%s']]]]]]//input[contains(@onclick, 'Delete')]";

    public void CancelTicket(Ticket ticket){
        By xpathCancelBtn = By.xpath(String.format(strXpathCancelBtn, ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount()));
        selectTab("My ticket");
        SeleniumHelper.scrollToElement(xpathCancelBtn);
        SeleniumHelper.click(xpathCancelBtn);

        DriverManagement.driver.switchTo().alert().accept();
    }

    public void verifyTicketNoDisplay(Ticket ticket){
        By xpathCancelBtn = By.xpath(String.format(strXpathCancelBtn, ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount()));
        SeleniumHelper.verifyEleNoDiplay(xpathCancelBtn);
    }
}
