import models.Ticket;
import models.User;
import org.testng.annotations.Test;
import pages.BookTicketsPage;
import pages.LoginPage;
import pages.MyTicketPage;
import utils.DateUtils;

public class CancelBooking extends TestBase {
    private LoginPage loginPage = new LoginPage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    String departDate = DateUtils.nextDate(12);
    String departStation = "Nha Trang";
    String arriveStation = "Huế";
    String seatType = "Soft bed with air conditioner";
    String ticketAmount = "1";
    Ticket ticket = new Ticket(departDate,departStation, arriveStation, seatType, ticketAmount);

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User can cancel a ticket")
    void TC016(){
        loginPage.login(validUser);
        bookTicketsPage.selectTab("Book ticket");
        bookTicketsPage.bookTicket(ticket);

        myTicketPage.CancelTicket(ticket);
        myTicketPage.verifyTicketNoDisplay(ticket);
    }
}
