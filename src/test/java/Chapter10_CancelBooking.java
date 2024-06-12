import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookTicketsPage;
import pages.LoginPage;
import pages.MyTicketPage;
import utils.Date;
import utils.DriverManagement;
import utils.SeleniumHelper;

public class Chapter10_CancelBooking extends TestBase {
    private LoginPage loginPage = new LoginPage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    private static String departDate = Date.nextDate(12);
    private static String departStation = "Nha Trang";
    private static String arriveStation = "Huế";
    private static String seatType = "Soft bed with air conditioner";
    private static String ticketAmount = "1";

    @Test
    void TC016(){
        loginPage.login(validEmail, validPwd);
        bookTicketsPage.selectTab("Book ticket");
        bookTicketsPage.bookTicket(departDate,departStation, arriveStation, seatType, ticketAmount);

        String ticketID = SeleniumHelper.getUrl().split("id=")[1];
        myTicketPage.CancelTicket(ticketID);

        try {
            DriverManagement.driver.findElement(By.xpath(String.format(myTicketPage.xpathCancelBtn, ticketID))).isDisplayed();
            Assert.fail("Element exists");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e instanceof NoSuchElementException);
        }
    }
}
