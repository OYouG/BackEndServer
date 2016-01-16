package com.oyg;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by msllavore on 1/15/16.
 */
public class TicketMaster {
    static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss zzz");

    private String evCode;
    private Time epTime;
    private Date eventDate;
    private double total;
    private double gross;
    private double opens;
    private double holds;
    private double retailAvail;

    public TicketMaster(String evCode, Time epTime, Date eventDate,
                        double total, double gross, double opens,
                        double holds, double retailAvail){
        this.evCode = evCode;
        this.epTime = epTime;
        this.eventDate = eventDate;
        this.total = total;
        this.gross = gross;
        this.opens = opens;
        this.holds = holds;
        this.retailAvail = retailAvail;
    }

    public String getEvCode() { return evCode; }

    public void setEvCode(String evCode) { this.evCode = evCode; }

    public Time getEpTime() { return epTime; }

    public void setEpTime(Time epTime) { this.epTime = epTime; }

    public Date getEventDate() { return eventDate; }

    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total; }

    public double getGross() { return gross; }

    public void setGross(double gross) { this.gross = gross; }

    public double getOpens() { return opens; }

    public void setOpens(double opens) {}

    public double getHolds() { return holds; }

    public double getRetailAvail() { return retailAvail; }

    public String toString(){
        df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return "Evcode: " + this.evCode + "\nEptime: " + this.epTime +
                "\nEventDate: " + df.format(this.eventDate) + "\nTotal: " + this.total +
                "\nGross: " + this.gross + "\nOpens: " + this.opens +
                "\nHolds: " + this.holds + "\nRetailAvail: " + this.retailAvail + "\n\n";
    }
}