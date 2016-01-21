package com.oyg;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by msllavore on 1/20/16.
 */
public class TicketMasterTraffic {
    static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss zzz");

    private String evCode;
    private Date date;
    private int edpVisits;
    private int orders;
    private int tickets; // private double avgConvPercent; // calculable: orders/edpVisits
    private BigDecimal totalValue;

    public TicketMasterTraffic(String evCode, Date date, int edpVisits, int orders, int tickets,
                               BigDecimal totalValue){
        this.evCode = evCode;
        this.date = date;
        this.edpVisits = edpVisits;
        this.orders = orders;
        this.tickets = tickets;
        this.totalValue = totalValue;
    }

    public String getEvCode() { return evCode; }

    public void setEvCode(String evCode) { this.evCode = evCode; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public int getEdpVisits() { return edpVisits; }

    public void setEdpVisits(int edpVisits) { this.edpVisits = edpVisits; }

    public int getOrders() { return orders; }

    public void setOrders(int orders) { this.orders = orders; }

    public int getTickets() { return tickets; }

    public void setTickets(int tickets) { this.tickets = tickets; }

    public BigDecimal getTotalValue() { return totalValue; }

    public void setTotalValue(BigDecimal totalValue) { this.totalValue = totalValue; }

    public String toString() {
        df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return "Evcode: " + this.evCode +
                "\nDate: " + df.format(this.date) + "\nEdpVisits: " + this.edpVisits +
                "\nOrders: " + this.orders + "\nTickets: " + this.tickets +
                "\nTotalValue: " + this.totalValue + "\n\n";
    }


}
