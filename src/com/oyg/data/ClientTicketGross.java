package com.oyg.data;

import java.util.Date;

/**
 * Created by msllavore on 11/29/15.
 */
public class ClientTicketGross {
    private String name;
    private long gross;
    private Date date;

    public ClientTicketGross(String name, long gross, Date date) {
        this.name = name;
        this.gross = gross;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
