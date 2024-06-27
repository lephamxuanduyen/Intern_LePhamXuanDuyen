import enums.SeatType;
import enums.Station;
import enums.TabName;
import models.Ticket;
import models.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BookTicketsPage;
import pages.LoginPage;
import pages.MyTicketPage;
import utils.DateUtils;

public class CancelBooking extends TestBase {
    private LoginPage loginPage = new LoginPage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    String departDate = DateUtils.nextDate(12);
    Station departStation = Station.NHATRANG;
    Station arriveStation = Station.HUE;
    SeatType seatType = SeatType.SSC;
    String ticketAmount = "1";
    Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User can cancel a ticket")
    void CancelTicket() {
        loginPage.login(validUser);
        bookTicketsPage.selectTab(TabName.BOOKTICKET);
        bookTicketsPage.bookTicket(ticket);
        myTicketPage.cancelTicket(ticket);
        SoftAssert softAsserttion = new SoftAssert();
        myTicketPage.verifyTicketNoDisplay(softAsserttion, ticket);
    }
}
