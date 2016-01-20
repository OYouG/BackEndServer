package com.oyg;

import java.math.BigDecimal;
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
    private int todaySold;
    private BigDecimal todayGross;
    private int toDateSold; //private double toDatePercentSold; // calculable: toDateSold/1695
    private int toDateZeroFace;
    private int toDateTotal; //private double toDatePercentTotal; // calculable: toDateTotal/1695
    private BigDecimal toDateGross;
    private int opens;
    private int holds; //private int preprints; // all values of zero

    public TicketMaster(String evCode, Time epTime, Date eventDate, int todaySold, BigDecimal todayGross,
                        int toDateSold, int toDateZeroFace, int toDateTotal, BigDecimal toDateGross,
                        int opens, int holds){
        this.evCode = evCode;
        this.epTime = epTime;
        this.eventDate = eventDate;
        this.todaySold = todaySold;
        this.todayGross = todayGross;
        this.toDateSold = toDateSold;
        this.toDateZeroFace = toDateZeroFace;
        this.toDateTotal = toDateTotal;
        this.toDateGross = toDateGross;
        this.opens = opens;
        this.holds = holds;
    }

    public String getEvCode() { return evCode; }

    public void setEvCode(String evCode) { this.evCode = evCode; }

    public Time getEpTime() { return epTime; }

    public void setEpTime(Time epTime) { this.epTime = epTime; }

    public Date getEventDate() { return eventDate; }

    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public int getTodaySold() { return todaySold; }

    public void setTodaySold() { this.todaySold = todaySold; }

    public BigDecimal getTodayGross() { return todayGross; }

    public void setTodayGross() { this.todayGross = todayGross; }

    public int getToDateSold() { return toDateSold; }

    public void setToDateSold() { this.toDateSold = toDateSold; }

    public int getToDateZeroFace() { return toDateZeroFace; }

    public void setToDateZeroFace() { this.toDateZeroFace = toDateZeroFace; }

    public int getToDateTotal() { return toDateTotal; }

    public void setToDateTotal() { this.toDateTotal = toDateTotal; }

    public BigDecimal getToDateGross() { return toDateGross; }

    public void setToDateGross() { this.toDateGross = toDateGross; }

    public int getOpens() { return opens; }

    public void setOpens() { this.opens = opens; }

    public int getHolds() { return holds; }

    public void setHolds() { this.holds = holds; }

    public String toString(){
        df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return "Evcode: " + this.evCode + "\nEptime: " + this.epTime +
                "\nEventDate: " + df.format(this.eventDate) + "\nTodaySold: " + this.todaySold +
                "\nTodayGross: " + this.todayGross + "\nToDateSold: " + this.toDateSold +
                "\nToDateZeroFace: " + this.toDateZeroFace + "\nToDateTotal: " + this.toDateTotal +
                "\ntoDateGross: " + this.toDateGross +
                "\nOpens: " + this.opens + "\nHolds: " + this.holds + "\n\n";
    }

}