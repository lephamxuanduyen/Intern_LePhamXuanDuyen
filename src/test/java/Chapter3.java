import org.testng.annotations.Test;
import pages.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Chapter3 extends TestBase{
    private String email;
    private String password = "123456789";
    private String pid = "12345678";
    private String emailConfirmInstruction = "thanhletraining03@gmail.com ";
    private String arriveStation = "Phan Thiết";
    private String ticketAmount = "2";

    private RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();
    private LoginPage loginPage = new LoginPage();
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

        bookTicketsPage.selectTab("Book ticket");
        bookTicketsPage.bookTicket(null, null, arriveStation, null, ticketAmount);
    }
}
