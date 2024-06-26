
import enums.SeatType;
import enums.Station;
import enums.TabName;
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
    void BookTicket(){
        loginPage.login(validUser);

        String departDate = DateUtils.nextDate(12);
        Station departStation = Station.NHATRANG;
        Station arriveStation = Station.HUE;
        SeatType seatType = SeatType.SBC;
        String ticketAmount = "1";

        Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);

        bookTicketsPage.selectTab(TabName.BOOKTICKET);
        bookTicketsPage.bookTicket(ticket);

        String expectedMes = "Ticket booked successfully!";

        SoftAssert softAssertions = new SoftAssert();
        bookTicketsPage.verifyMesBookSuc(softAssertions, expectedMes);
        bookTicketsPage.verifyInfoTicket(softAssertions, ticket);
        softAssertions.assertAll();
    }

    @Test(description = "User can book many tickets at a time")
    void BookManyTickets(){
        loginPage.login(validUser);

        String departDate = DateUtils.nextDate(25);
        Station departStation = Station.NHATRANG;
        Station arriveStation = Station.SAIGON;
        SeatType seatType = SeatType.SSC;
        String ticketAmount = "5";
        Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);


        bookTicketsPage.selectTab(TabName.BOOKTICKET);
        bookTicketsPage.bookTicket(ticket);

        String expectedMes = "Ticket booked successfully!";

        SoftAssert softAssertions = new SoftAssert();
        bookTicketsPage.verifyMesBookSuc(softAssertions, expectedMes);
        bookTicketsPage.verifyInfoTicket(softAssertions, ticket);
        softAssertions.assertAll();
    }

    @Test(description = "User can check price of ticket from Timetable")
    void CheckPrice(){
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
    void BookTicketFromTimetable(){
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
