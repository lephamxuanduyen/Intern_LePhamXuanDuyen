package models;

import utils.Date;

public class Ticket {
    String departDate;
    String departStation;
    String arriveStation;
    String seatType;
    String ticketAmount;

    public Ticket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getDepartStation() {
        return departStation;
    }

    public String getArriveStation() {
        return arriveStation;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getTicketAmount() {
        return ticketAmount;
    }
}
