
import models.Ticket;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BookTicketsPage;
import pages.LoginPage;
import pages.TicketPricePage;
import pages.TimeTablePage;
import utils.DateUtils;
import utils.Action;

public class BookTicket extends TestBase{
    private LoginPage loginPage = new LoginPage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();
    private TimeTablePage timeTablePage = new TimeTablePage();
    private TicketPricePage ticketPricePage = new TicketPricePage();

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User can book 1 ticket at a time")
    void TC012(){
        loginPage.login(validUser);

        String departDate = DateUtils.nextDate(12);
        String departStation = "Nha Trang";
        String arriveStation = "Huế";
        String seatType = "Soft bed with air conditioner";
        String ticketAmount = "1";

        Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);

        bookTicketsPage.selectTab("Book ticket");
        bookTicketsPage.bookTicket(ticket);

        String actualMes = Action.getText(bookTicketsPage.mesBookTicketSucc);
        String expectedMes = "Ticket booked successfully!";

        SoftAssert softAssertions = new SoftAssert();
        softAssertions.assertEquals(actualMes, expectedMes);

        String actualDepartDate = bookTicketsPage.getInfoBookTicketSucc("Depart Date");
        String actualDepartStation = bookTicketsPage.getInfoBookTicketSucc("Depart Station");
        String actualArriveStaion = bookTicketsPage.getInfoBookTicketSucc("Arrive Station");
        String actualSeatType = bookTicketsPage.getInfoBookTicketSucc("Seat Type");
        String actualAmount = bookTicketsPage.getInfoBookTicketSucc("Amount");

        softAssertions.assertEquals(actualDepartDate, departDate);
        softAssertions.assertEquals(actualDepartStation, departStation);
        softAssertions.assertEquals(actualArriveStaion, arriveStation);
        softAssertions.assertEquals(actualSeatType, seatType);
        softAssertions.assertEquals(actualAmount, ticketAmount);

        softAssertions.assertAll();
    }

    @Test(description = "User can book many tickets at a time")
    void TC013(){
        loginPage.login(validUser);

        String departDate = DateUtils.nextDate(25);
        String departStation = "Nha Trang";
        String arriveStation = "Sài Gòn";
        String seatType = "Soft seat with air conditioner";
        String ticketAmount = "5";
        Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);


        bookTicketsPage.selectTab("Book ticket");
        bookTicketsPage.bookTicket(ticket);

        String actualMes = Action.getText(bookTicketsPage.mesBookTicketSucc);
        String expectedMes = "Ticket booked successfully!";

        SoftAssert softAssertions = new SoftAssert();
        softAssertions.assertEquals(actualMes, expectedMes);

        String actualDepartDate = bookTicketsPage.getInfoBookTicketSucc("Depart Date");
        String actualDepartStation = bookTicketsPage.getInfoBookTicketSucc("Depart Station");
        String actualArriveStaion = bookTicketsPage.getInfoBookTicketSucc("Arrive Station");
        String actualSeatType = bookTicketsPage.getInfoBookTicketSucc("Seat Type");
        String actualAmount = bookTicketsPage.getInfoBookTicketSucc("Amount");

        softAssertions.assertEquals(actualDepartDate, departDate);
        softAssertions.assertEquals(actualDepartStation, departStation);
        softAssertions.assertEquals(actualArriveStaion, arriveStation);
        softAssertions.assertEquals(actualSeatType, seatType);
        softAssertions.assertEquals(actualAmount, ticketAmount);

        softAssertions.assertAll();
    }

    @Test(description = "User can check price of ticket from Timetable")
    void TC014(){
        String departStation = "Đà Nẵng";
        String arriveStation = "Sài Gòn";
        loginPage.login(validUser);
        timeTablePage.checkTicket(departStation, arriveStation);

        String actualHeaderTicketPrice = Action.getText(ticketPricePage.header);
        String actualTableHeader = Action.getText(ticketPricePage.tableHeader);
        String actualHSPrice = ticketPricePage.getPriceBySeatType("HS");
        String actualSSPrice = ticketPricePage.getPriceBySeatType("SS");
        String actualSSCPrice = ticketPricePage.getPriceBySeatType("SSC");
        String actualHBPrice = ticketPricePage.getPriceBySeatType("HB");
        String actualSBPrice = ticketPricePage.getPriceBySeatType("SB");
        String actualSBCPrice = ticketPricePage.getPriceBySeatType("SBC");

        String expectedHeaderTicketPrice = "Ticket Price";
        String expectTableHeader = "Ticket price from Đà Nẵng to Sài Gòn";
        String expectedHSPrice = "310000";
        String expectedSSPrice = "335000";
        String expectedSSCPrice = "360000";
        String expectedHBPrice = "410000";
        String expectedSBPrice = "460000";
        String expectedSBCPrice = "510000";

        SoftAssert softAssertions = new SoftAssert();
        softAssertions.assertEquals(actualHeaderTicketPrice, expectedHeaderTicketPrice);
        softAssertions.assertEquals(actualTableHeader, expectTableHeader);
        softAssertions.assertEquals(actualHSPrice, expectedHSPrice);
        softAssertions.assertEquals(actualSSPrice, expectedSSPrice);
        softAssertions.assertEquals(actualSSCPrice, expectedSSCPrice);
        softAssertions.assertEquals(actualHBPrice, expectedHBPrice);
        softAssertions.assertEquals(actualSBPrice, expectedSBPrice);
        softAssertions.assertEquals(actualSBCPrice, expectedSBCPrice);
        softAssertions.assertAll();
    }

    @Test(description = "User can book ticket from Timetable")
    void TC015(){
        String departDate = DateUtils.nextDate(10);
        String departStation = "Quảng Ngãi";
        String arriveStation = "Huế";
        String ticketAmount = "5";
        Ticket ticket = new Ticket(departDate, null, null, null, ticketAmount);

        loginPage.login(validUser);

        timeTablePage.bookTicket(departStation, arriveStation);

        bookTicketsPage.bookTicket(ticket);

        String expectedResult = "Ticket booked successfully!";
        String actualResult = Action.getText(bookTicketsPage.message);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
