import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Chapter3 extends TestBase
{
    private String email;
    private String password = "123456789";
    private String pid = "12345678";
    private String emailConfirmInstruction = "thanhletraining03@gmail.com ";
    private String departDate = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
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
    void Register(){
        RegisterPage.openRailway();

        mailPage.openMailPage();
        email = mailPage.getFreeMail();

        registerPage.switchToRailway();
        registerPage.register(email, password, pid);

        mailPage.switchToMailPage();
        mailPage.confirmAccRegistered(emailConfirmInstruction);

        loginPage.switchToRailway();
        loginPage.login(email, password);

        timeTablePage.checkTicket(departStation, arriveStation);

        ticketPricePage.bookTicket(seatType);

        bookTicketsPage.bookTicket(departDate, null, null, null, ticketAmount);

        String expectedResult = "Ticket booked successfully!";
        String actualResult = DriverManagement.driver.findElement(By.xpath("//div[@id='content']/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

}
