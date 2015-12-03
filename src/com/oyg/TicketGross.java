package com.oyg;

import java.util.Date;
/**
 * Created by msllavore on 11/20/15.
 * The schema of data returned from the server
 */
public class TicketGross {
    /*$TODO$ spoke to frontenders: scrap the start date; assume that inputs will always
    correspond to those listed in ibdb; rename endDate to just date*/
    private String name;
    private long gross;
    private long attendance;
    private Date date; // should we use Date class/type // also should we even be storing a start date


    public TicketGross(String name, long gross, long attendance, Date date) {
        this.name = name;
        this.gross = gross;
        this.attendance = attendance;
        this.date = date;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public long getGross() { return gross; }

    public void setGross(long gross) { this.gross = gross; }

    public long getAttendance() { return attendance; }

    public void setAttendance(long attendance) { this.attendance = attendance; }

    public Date getDate() { return date; }

    public void setDate(Date date){ this.date = date; }

}
