
import base.DataSets;
import enums.SeatType;
import enums.Station;
import enums.TabName;
import models.Ticket;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BookTicketsPage;
import pages.LoginPage;
import pages.TicketPricePage;
import pages.TimeTablePage;
import utils.DateUtils;
import utils.Action;

public class BookTicket extends TestBase {
    private LoginPage loginPage = new LoginPage();
    private BookTicketsPage bookTicketsPage = new BookTicketsPage();
    private TimeTablePage timeTablePage = new TimeTablePage();
    private TicketPricePage ticketPricePage = new TicketPricePage();

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User can book 1 ticket at a time", dataProvider = "TicketDataProvider", dataProviderClass = DataSets.class)
    void BookTicket(Ticket ticket) {
        loginPage.login(validUser);

        bookTicketsPage.selectTab(TabName.BOOKTICKET);
        bookTicketsPage.bookTicket(ticket);

        String expectedMes = "Ticket booked successfully!";

        SoftAssert softAssertions = new SoftAssert();
        bookTicketsPage.verifyMesBookSuc(softAssertions, expectedMes);
        bookTicketsPage.verifyInfoTicket(softAssertions, ticket);
        softAssertions.assertAll();
    }

    @Test(description = "User can book many tickets at a time", dataProvider = "TicketsDataProvider", dataProviderClass = DataSets.class)
    void BookManyTickets(Ticket tickets) {
        loginPage.login(validUser);

        bookTicketsPage.selectTab(TabName.BOOKTICKET);
        bookTicketsPage.bookTicket(tickets);

        String expectedMes = "Ticket booked successfully!";

        SoftAssert softAssertions = new SoftAssert();
        bookTicketsPage.verifyMesBookSuc(softAssertions, expectedMes);
        bookTicketsPage.verifyInfoTicket(softAssertions, tickets);
        softAssertions.assertAll();
    }

    @Test(description = "User can check price of ticket from Timetable")
    void CheckPrice() {
        Station departStation = Station.DANANG;
        Station arriveStation = Station.SAIGON;
        loginPage.login(validUser);
        timeTablePage.checkTicket(departStation, arriveStation);

        String actualHeaderTicketPrice = Action.getText(ticketPricePage.header);
        String actualTableHeader = Action.getText(ticketPricePage.tableHeader);
        String actualHSPrice = ticketPricePage.getPriceBySeatType(SeatType.HS);
        String actualSSPrice = ticketPricePage.getPriceBySeatType(SeatType.SS);
        String actualSSCPrice = ticketPricePage.getPriceBySeatType(SeatType.SSC);
        String actualHBPrice = ticketPricePage.getPriceBySeatType(SeatType.HB);
        String actualSBPrice = ticketPricePage.getPriceBySeatType(SeatType.SB);
        String actualSBCPrice = ticketPricePage.getPriceBySeatType(SeatType.SBC);

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
    void BookTicketFromTimetable() {
        String departDate = DateUtils.nextDate(10);
        String departStation = "Quảng Ngãi";
        String arriveStation = "Huế";
        String ticketAmount = "5";

        loginPage.login(validUser);

        timeTablePage.bookTicket(departStation, arriveStation);

        bookTicketsPage.selectValue("Date", departDate);
        bookTicketsPage.selectValue("TicketAmount", ticketAmount);
        bookTicketsPage.submitForm();

        String expectedResult = "Ticket booked successfully!";
        String actualResult = Action.getText(bookTicketsPage.message);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
