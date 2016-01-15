package com.oyg.data;

import java.util.Date;

/**
 * Created by msllavore on 11/29/15.
 */
public class ClientTicketGross {
    private String playName;
    private long gross;
    private Date weekendDate;

    public ClientTicketGross(String name, long gross, Date date) {
        this.playName = name;
        this.gross = gross;
        this.weekendDate = date;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String name) {
        this.playName = name;
    }

    public long getGross() {
        return gross;
    }

    public void setGross(long gross) {
        this.gross = gross;
    }

    public Date getWeekendDate() {
        return weekendDate;
    }

    public void setWeekendDate(Date date) {
        this.weekendDate = date;
    }
}
