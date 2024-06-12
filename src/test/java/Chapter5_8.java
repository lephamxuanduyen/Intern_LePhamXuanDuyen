import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Date;
import utils.SeleniumHelper;

public class Chapter5_8 extends TestBase
{
    private String email;
    private String departDate = Date.nextDate(7);
    private String departStation = "Sài Gòn";
    private String arriveStation = "Đà Nẵng";
    private String seatType = "Soft seat";
    private String ticketAmount = "2";

    private  RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();
    private LoginPage loginPage = new LoginPage();
    private TimeTablePage timeTablePage = new TimeTablePage();
    private TicketPricePage ticketPricePage = new TicketPricePage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();

    @Test
    void BookTicket(){
        mailPage.openMailPage();
        email = mailPage.getFreeMail();

        registerPage.switchToRailway();
        registerPage.register(email,validPwd, validPid);

        mailPage.switchToMailPage();
        mailPage.confirmAccount(emailConfirmInstruction);

        loginPage.switchToRailway();
        loginPage.login(email, validPwd);

        timeTablePage.checkTicket(departStation, arriveStation);

        ticketPricePage.bookTicket(seatType);

        bookTicketsPage.bookTicket(departDate, null, null, null, ticketAmount);

        String expectedResult = "Ticket booked successfully!";
        By xpath_Message = By.xpath("//div[@id='content']/h1");
        String actualResult = SeleniumHelper.getText(xpath_Message);

        Assert.assertEquals(actualResult, expectedResult);
    }

}
