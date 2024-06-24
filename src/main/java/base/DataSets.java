package base;

import enums.SeatType;
import enums.Station;
import models.Ticket;
import org.testng.annotations.DataProvider;
import utils.DateUtils;

public class DataSets {
    @DataProvider(name="TicketDataProvider")
    public Object[][] TicketData(){
        return  new Object[][] {
                {new Ticket(DateUtils.nextDate(25), Station.NHATRANG, Station.HUE, SeatType.SBC, "1")},
                {new Ticket(DateUtils.nextDate(20), Station.SAIGON, Station.PHANTHIET, SeatType.HB, "1")},
                {new Ticket(DateUtils.nextDate(22), Station.QUANGNGAI, Station.DANANG, SeatType.SB, "1")}
        };
    }

    @DataProvider(name="TicketsDataProvider")
    public Object[][] TicketsData(){
        return new Object[][]{
                {new Ticket(DateUtils.nextDate(25), Station.NHATRANG, Station.SAIGON, SeatType.SSC, "5")}
        };
    }
}
