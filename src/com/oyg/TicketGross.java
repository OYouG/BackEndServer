package com.oyg;

import java.util.Date;
/**
 * Created by msllavore on 11/20/15.
 * The schema of data returned from the server
 */
public class TicketGross {

    private String name;
    private long gross;
    private long attendance;
    private Date startDate; // should we use Date class/type // also should we even be storing a start date
    private Date endDate;


    public TicketGross(String name, long gross, long attendance, Date startDate, Date endDate) {
        this.name = name;
        this.gross = gross;
        this.attendance = attendance;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGross() {
        return gross;
    }

    public void setGross(long gross) {
        this.gross = gross;
    }

    public long getAttendance() {
        return attendance;
    }

    public void setAttendance(long attendance) {
        this.attendance = attendance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
