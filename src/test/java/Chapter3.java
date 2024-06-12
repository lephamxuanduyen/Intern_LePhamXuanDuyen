import org.testng.annotations.Test;
import pages.*;

public class Chapter3 extends TestBase{
    private String email;
    private String arriveStation = "Phan Thiết";
    private String ticketAmount = "2";

    private RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();

    @Test
    void Register(){
        mailPage.openMailPage();
        email = mailPage.getFreeMail();

        registerPage.switchToRailway();
        registerPage.register(email, validPwd, validPid);

        mailPage.switchToMailPage();
        mailPage.confirmAccount(emailConfirmInstruction);

        loginPage.switchToRailway();
        loginPage.login(email, validPid);

        bookTicketsPage.selectTab("Book ticket");
        bookTicketsPage.bookTicket(null, null, arriveStation, null, ticketAmount);
    }
}
