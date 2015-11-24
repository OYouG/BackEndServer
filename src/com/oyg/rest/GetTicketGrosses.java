package com.oyg.rest;

import com.oyg.TicketGross;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by msllavore on 11/20/15.
 */
public class GetTicketGrosses {
    public List<TicketGross> getGrossesFromServer(String startDate, String endDate) { // make these Dates

        //$TODO$ use start and end date when actually talking to the correct server

        //CREATING DUMMY DATA

        List<TicketGross> dummyList = new ArrayList<>();
        //TicketGross(String name, long attendance, String startDate, String endDate)

        TicketGross aaipWeek1 = new TicketGross("An American In Paris", 317917, 3161, null, new Date(2015,3,15));
        TicketGross aaipWeek2 = new TicketGross("An American In Paris", 737241, 9050, null, new Date(2015,3,22));
        TicketGross aaipWeek3 = new TicketGross("An American In Paris", 859761, 10620, null, new Date(2015,3,29));
        TicketGross aaipWeek4 = new TicketGross("An American In Paris", 967150, 12114, null, new Date(2015,4,5));
        TicketGross aaipWeek5 = new TicketGross("An American In Paris", 826416, 11559, null, new Date(2015,4,12));
        TicketGross aaipWeek6 = new TicketGross("An American In Paris", 1149324, 12546, null, new Date(2015,4,19));
        TicketGross aaipWeek7 = new TicketGross("An American In Paris", 1235247, 12819, null, new Date(2015,4,26));
        TicketGross aaipWeek8 = new TicketGross("An American In Paris", 1220230, 13026, null, new Date(2015,5,3));
        TicketGross aaipWeek9 = new TicketGross("An American In Paris", 1298817, 13187, null, new Date(2015,5,10));
        TicketGross aaipWeek10 = new TicketGross("An American In Paris", 1280110, 13417, null, new Date(2015,5,17));

        dummyList.add(aaipWeek1);
        dummyList.add(aaipWeek2);
        dummyList.add(aaipWeek3);
        dummyList.add(aaipWeek4);
        dummyList.add(aaipWeek5);
        dummyList.add(aaipWeek6);
        dummyList.add(aaipWeek7);
        dummyList.add(aaipWeek8);
        dummyList.add(aaipWeek9);
        dummyList.add(aaipWeek10);

        TicketGross aladdinWeek1 = new TicketGross("Aladdin", 1320261, 13785, null, new Date(2015,3,15));
        TicketGross aladdinWeek2 = new TicketGross("Aladdin", 1445641, 13786, null, new Date(2015,3,22));
        TicketGross aladdinWeek3 = new TicketGross("Aladdin", 1569812, 13785, null, new Date(2015,3,29));
        TicketGross aladdinWeek4 = new TicketGross("Aladdin", 2024667, 15508, null, new Date(2015,4,5));
        TicketGross aladdinWeek5 = new TicketGross("Aladdin", 1768354, 13786, null, new Date(2015,4,12));
        TicketGross aladdinWeek6 = new TicketGross("Aladdin", 1534573, 13703, null, new Date(2015,4,19));
        TicketGross aladdinWeek7 = new TicketGross("Aladdin", 1492453, 13786, null, new Date(2015,4,26));
        TicketGross aladdinWeek8 = new TicketGross("Aladdin", 1408343, 13785, null, new Date(2015,5,3));
        TicketGross aladdinWeek9 = new TicketGross("Aladdin", 1422347, 13766, null, new Date(2015,5,10));
        TicketGross aladdinWeek10 = new TicketGross("Aladdin", 1467089, 13788, null, new Date(2015,5,17));

        dummyList.add(aladdinWeek1);
        dummyList.add(aladdinWeek2);
        dummyList.add(aladdinWeek3);
        dummyList.add(aladdinWeek4);
        dummyList.add(aladdinWeek5);
        dummyList.add(aladdinWeek6);
        dummyList.add(aladdinWeek7);
        dummyList.add(aladdinWeek8);
        dummyList.add(aladdinWeek9);
        dummyList.add(aladdinWeek10);

        TicketGross bomWeek1 = new TicketGross("The Book of Mormon", 1540949, 8752, null, new Date(2015,3,15));
        TicketGross bomWeek2 = new TicketGross("The Book of Mormon", 1547574, 8752, null, new Date(2015,3,22));
        TicketGross bomWeek3 = new TicketGross("The Book of Mormon", 1529584, 8751, null, new Date(2015,3,29));
        TicketGross bomWeek4 = new TicketGross("The Book of Mormon", 1517640, 8751, null, new Date(2015,4,5));
        TicketGross bomWeek5 = new TicketGross("The Book of Mormon", 1517969, 8746, null, new Date(2015,4,12));
        TicketGross bomWeek6 = new TicketGross("The Book of Mormon", 1467289, 8716, null, new Date(2015,4,19));
        TicketGross bomWeek7 = new TicketGross("The Book of Mormon", 1469646, 8744, null, new Date(2015,4,26));
        TicketGross bomWeek8 = new TicketGross("The Book of Mormon", 1407987, 8749, null, new Date(2015,5,3));
        TicketGross bomWeek9 = new TicketGross("The Book of Mormon", 1446130, 8744, null, new Date(2015,5,10));
        TicketGross bomWeek10 = new TicketGross("The Book of Mormon", 1534408, 8743, null, new Date(2015,5,17));

        dummyList.add(bomWeek1);
        dummyList.add(bomWeek2);
        dummyList.add(bomWeek3);
        dummyList.add(bomWeek4);
        dummyList.add(bomWeek5);
        dummyList.add(bomWeek6);
        dummyList.add(bomWeek7);
        dummyList.add(bomWeek8);
        dummyList.add(bomWeek9);
        dummyList.add(bomWeek10);

        TicketGross lionKingWeek1 = new TicketGross("The Lion King", 1824626, 13587, null, new Date(2015,3,15));
        TicketGross lionKingWeek2 = new TicketGross("The Lion King", 1901829, 13499, null, new Date(2015,3,22));
        TicketGross lionKingWeek3 = new TicketGross("The Lion King", 2064202, 13494, null, new Date(2015,3,29));
        TicketGross lionKingWeek4 = new TicketGross("The Lion King", 2633531, 15295, null, new Date(2015,4,5));
        TicketGross lionKingWeek5 = new TicketGross("The Lion King", 2293061, 13436, null, new Date(2015,4,12));
        TicketGross lionKingWeek6 = new TicketGross("The Lion King", 1843464, 13187, null, new Date(2015,4,19));
        TicketGross lionKingWeek7 = new TicketGross("The Lion King", 1972747, 13557, null, new Date(2015,4,26));
        TicketGross lionKingWeek8 = new TicketGross("The Lion King", 1908299, 12937, null, new Date(2015,5,3));
        TicketGross lionKingWeek9 = new TicketGross("The Lion King", 1701798, 11480, null, new Date(2015,5,10));
        TicketGross lionKingWeek10 = new TicketGross("The Lion King", 1966567, 13508, null, new Date(2015,5,17));

        dummyList.add(lionKingWeek1);
        dummyList.add(lionKingWeek2);
        dummyList.add(lionKingWeek3);
        dummyList.add(lionKingWeek4);
        dummyList.add(lionKingWeek5);
        dummyList.add(lionKingWeek6);
        dummyList.add(lionKingWeek7);
        dummyList.add(lionKingWeek8);
        dummyList.add(lionKingWeek9);
        dummyList.add(lionKingWeek10);

        TicketGross wickedWeek1 = new TicketGross("Wicked", 1818766, 15024, null, new Date(2015,3,15));
        TicketGross wickedWeek2 = new TicketGross("Wicked", 1855247, 15214, null, new Date(2015,3,22));
        TicketGross wickedWeek3 = new TicketGross("Wicked", 1872149, 14604, null, new Date(2015,3,29));
        TicketGross wickedWeek4 = new TicketGross("Wicked", 2358372, 15857, null, new Date(2015,4,5));
        TicketGross wickedWeek5 = new TicketGross("Wicked", 2181861, 14678, null, new Date(2015,4,12));
        TicketGross wickedWeek6 = new TicketGross("Wicked", 1655748, 14065, null, new Date(2015,4,19));
        TicketGross wickedWeek7 = new TicketGross("Wicked", 1741459, 14847, null, new Date(2015,4,26));
        TicketGross wickedWeek8 = new TicketGross("Wicked", 1387456, 12512, null, new Date(2015,5,3));
        TicketGross wickedWeek9 = new TicketGross("Wicked", 1469322, 13067, null, new Date(2015,5,10));
        TicketGross wickedWeek10 = new TicketGross("Wicked", 1601725, 13959, null, new Date(2015,5,17));

        dummyList.add(wickedWeek1);
        dummyList.add(wickedWeek2);
        dummyList.add(wickedWeek3);
        dummyList.add(wickedWeek4);
        dummyList.add(wickedWeek5);
        dummyList.add(wickedWeek6);
        dummyList.add(wickedWeek7);
        dummyList.add(wickedWeek8);
        dummyList.add(wickedWeek9);
        dummyList.add(wickedWeek10);

        return dummyList;
    }
}
