package base;

import enums.SeatType;
import enums.Station;
import models.Ticket;
import org.testng.annotations.DataProvider;
import utils.DateUtils;

public class DataSets {
    @DataProvider(name = "TicketDataProvider")
    public Object[][] TicketData() {
        return new Object[][]{
                {new Ticket(DateUtils.nextDate(25), Station.NHATRANG, Station.HUE, SeatType.SBC, "1")},
                {new Ticket(DateUtils.nextDate(20), Station.SAIGON, Station.PHANTHIET, SeatType.HB, "1")},
                {new Ticket(DateUtils.nextDate(22), Station.QUANGNGAI, Station.DANANG, SeatType.SB, "1")}
        };
    }

    @DataProvider(name = "TicketsDataProvider")
    public Object[][] TicketsData() {
        Object[][] data = new Object[ReadJson.getTickets().size()][1];
        for (int i = 0; i < ReadJson.getTickets().size(); i++) {
            data[i][0] = ReadJson.getTickets().get(i);
        }
        return data;
    }

    @DataProvider(name = "ValidUserDataProvider")
    public Object[][] ValidUsersData() {
        Object[][] data = new Object[ReadJson.getUsers("validUsers").size()][1];
        for (int i = 0; i < ReadJson.getUsers("validUsers").size(); i++) {
            data[i][0] = ReadJson.getUsers("validUsers").get(i);
        }
        return data;
    }

    @DataProvider(name = "browserData", parallel = true)
    public Object[][] provideBrowserData() {
        return new Object[][] {
                { "chrome" },
                { "firefox" }
        };
    }
}
