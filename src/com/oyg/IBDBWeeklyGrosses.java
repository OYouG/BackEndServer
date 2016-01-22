package com.oyg;

import java.util.Date;

/**
 * Created by GessicaTan-Torres on 1/20/16.
 */
public class IBDBWeeklyGrosses {
    private Date weekEnding;
    private String gross;
    private int grossPotential;
    private String attendance;
    private int capacity;

    public IBDBWeeklyGrosses(Date weekEnding, String gross, int grossPotential, String attendance, int capacity)
    {
        this.weekEnding = weekEnding;
        this.gross = gross;
        this.grossPotential = grossPotential;
        this.attendance = attendance;
        this.capacity = capacity;
    }

    public String toString() {
        return "Week Ending: " + this.weekEnding + "\nGross: " + this.gross +
                "\n% Gross Potential: " + this.grossPotential + "\nAttendance: " + this.attendance +
                "\n% Capacity: " + this.capacity + "\n\n";
    }

    public Date getWeekEnding()
    {
        return weekEnding;
    }

    public void setWeekEnding(Date weekEnding)
    {
        this.weekEnding = weekEnding;
    }

    public String getGross()
    {
        return gross;
    }

    public void setGross(String gross)
    {
        this.gross = gross;
    }

    public int getGrossPotential()
    {
        return grossPotential;
    }

    public void setGrossPotential(int grossPotential)
    {
        this.grossPotential = grossPotential;
    }

    public String getAttendance()
    {
        return attendance;
    }

    public void setAttendance(String attendance)
    {
        this.attendance = attendance;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
}
