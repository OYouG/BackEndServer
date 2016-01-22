package com.oyg;

import java.util.Date;

/*
 * Created by Madeleine K. Surjani on 1/20/2016
 */
public class NuviDailySummary {
    private String sourceID;
    private String sourceName;
    private String keyword;
    private String type;
    private Date fromHoursMs;
    private Date toHoursMs;
    private int total;

    public NuviDailySummary(String sourceID, String sourceName, String keyword, String type, Date fromHoursMs, Date toHoursMs, int total)
    {
        this.sourceID = sourceID;
        this.sourceName = sourceName;
        this.keyword = keyword;
        this.type = type;
        this.fromHoursMs = fromHoursMs;
        this.toHoursMs = toHoursMs;
        this.total = total;
    }

    public String toString()
    {
        return "Source ID: " + this.sourceID + "\nSource Name: " + this.sourceName +
                "\nKeyword: " + this.keyword + "\nType: " + this.type +
                "\nFrom Hours MS: " + this.fromHoursMs + "\nTo Hours MS: " + this.toHoursMs +
                "\nTotal: " + this.total + "\n\n";
    }

    public String getSourceID()
    {
        return sourceID;
    }

    public void setSourceID(String sourceID)
    {
        this.sourceID = sourceID;
    }

    public String getSourceName()
    {
        return sourceName;
    }

    public void setSourceName(String sourceName)
    {
        this.sourceName = sourceName;
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Date getFromHoursMs()
    {
        return fromHoursMs;
    }

    public void setFromHoursMs(Date fromHoursMs)
    {
        this.fromHoursMs = fromHoursMs;
    }

    public Date getToHoursMs()
    {
        return toHoursMs;
    }

    public void setToHoursMs(Date toHoursMs)
    {
        this.toHoursMs = toHoursMs;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }
}
