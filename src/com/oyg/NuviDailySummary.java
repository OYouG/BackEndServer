package com.oyg;

import java.util.Date;

/*
 * Created by Madeleine K. Surjani on 1/20/2016
 */
public class NuviDailySummary {
    private String keyword;
    private String trendType;
    private Date fromHoursMs;
    private Date toHoursMs;
    private int total;

    public NuviDailySummary(String keyword, String trendType, Date fromHoursMs, Date toHoursMs, int total)
    {
        this.keyword = keyword;
        this.trendType = trendType;
        this.fromHoursMs = fromHoursMs;
        this.toHoursMs = toHoursMs;
        this.total = total;
    }

    public String toString()
    {
        return  "Keyword: " + this.keyword + "\nTrendType: " + this.trendType +
                "\nFrom Hours MS: " + this.fromHoursMs + "\nTo Hours MS: " + this.toHoursMs +
                "\nTotal: " + this.total + "\n\n";
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getTrendType()
    {
        return trendType;
    }

    public void setType(String trendType)
    {
        this.trendType = trendType;
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
