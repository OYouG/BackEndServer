package com.oyg;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by msllavore on 1/21/16.
 */
public class TicketMasterPriceLevels {
    static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss zzz");

    private String evCode;
    private String priceLevel;
    private Date dateToday;
    private int netCap;
    private int totalTickets;
    private BigDecimal totalFace;
    private double retailAvail;

    public TicketMasterPriceLevels(String evCode, String priceLevel,
                                   Date dateToday, int netCap, int totalTickets,
                                   BigDecimal totalFace, double retailAvail) {
        this.evCode = evCode;
        this.priceLevel = priceLevel;
        this.dateToday = dateToday;
        this.netCap = netCap;
        this.totalTickets = totalTickets;
        this.totalFace = totalFace;
        this.retailAvail = retailAvail;
    }

    public String getEvCode() { return evCode; }

    public void setEvCode(String evCode) { this.evCode = evCode; }

    public String getPriceLevel() { return priceLevel; }

    public void setPriceLevel(String priceLevel) { this.priceLevel = priceLevel; }

    public Date getDate() { return dateToday; }

    public void setDate(Date dateToday) { this.dateToday = dateToday; }

    public int getNetCap() { return netCap; }

    public void setNetCap(int netCap) { this.netCap = netCap; }

    public int getTotalTickets() { return totalTickets; }

    public void setTotalTickets(int totalTickets) { this.totalTickets = totalTickets; }

    public BigDecimal getTotalFace() { return totalFace; }

    public void setTotalFace(BigDecimal totalFace) { this.totalFace = totalFace; }

    public double getRetailAvail() { return retailAvail; }

    public void setRetailAvail(double retailAvail) { this.retailAvail = retailAvail; }

    public String toString() {
        df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return "Evcode: " + this.evCode + "\nPriceLevel: " + this.priceLevel +
                "\nDate: " + df.format(this.dateToday) + "\nNetCap: " + this.netCap +
                "\nTotalTickets: " + this.totalTickets + "\nTotalFace: " + this.totalFace +
                "\nRetailAvail: " + this.retailAvail + "\n\n";
    }
}
