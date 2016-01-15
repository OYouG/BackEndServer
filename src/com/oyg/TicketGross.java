package com.oyg;

import java.util.Date;
/**
 * Created by msllavore on 11/20/15.
 * The schema of data returned from the server
 */
public class TicketGross {
    /*$TODO$ spoke to frontenders: scrap the start date; assume that inputs will always
    correspond to those listed in ibdb; rename endDate to just date*/
    private String playName;
    private Date weekendDate;
    private long gross;
    private long attendance;



    public TicketGross(String playName, Date date, long gross, long attendance) {
        this.playName = playName;
        this.gross = gross;
        this.attendance = attendance;
        this.weekendDate = date;
    }

    public String getPlayName() { return playName; }

    public void setPlayName(String name) { this.playName = name; }

    public long getGross() { return gross; }

    public void setGross(long gross) { this.gross = gross; }

    public long getAttendance() { return attendance; }

    public void setAttendance(long attendance) { this.attendance = attendance; }

    public Date getWeekendDate() { return weekendDate; }

    public void setWeekendDate(Date date){ this.weekendDate = date; }

}
