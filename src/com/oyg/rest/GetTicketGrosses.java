package com.oyg.rest;

import com.oyg.TicketGross;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by msllavore on 11/20/15.
 */
public class GetTicketGrosses {
    public List<TicketGross> getGrossesFromServer(String date) { // make these Dates

        //$TODO$ use start and end date when actually talking to the correct server

        //CREATING DUMMY DATA

        List<TicketGross> dummyList = new ArrayList<>();
        //TicketGross(String name, long attendance, String startDate, String endDate)

        //An American in Paris, Gross, Attendance, and Date
        TicketGross aaipWeek1  = new TicketGross("An American In Paris", 317917, 3161, new Date(2015,3,15));
        TicketGross aaipWeek2  = new TicketGross("An American In Paris", 737241, 9050, new Date(2015,3,22));
        TicketGross aaipWeek3  = new TicketGross("An American In Paris", 859761, 10620, new Date(2015,3,29));
        TicketGross aaipWeek4  = new TicketGross("An American In Paris", 967150, 12114, new Date(2015,4,5));
        TicketGross aaipWeek5  = new TicketGross("An American In Paris", 826416, 11559, new Date(2015,4,12));
        TicketGross aaipWeek6  = new TicketGross("An American In Paris", 1149324, 12546, new Date(2015,4,19));
        TicketGross aaipWeek7  = new TicketGross("An American In Paris", 1235247, 12819, new Date(2015,4,26));
        TicketGross aaipWeek8  = new TicketGross("An American In Paris", 1220230, 13026, new Date(2015,5,3));
        TicketGross aaipWeek9  = new TicketGross("An American In Paris", 1298817, 13187, new Date(2015,5,10));
        TicketGross aaipWeek10 = new TicketGross("An American In Paris", 1280110, 13417, new Date(2015,5,17));

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

        //Aladdin, Gross, Attendance, and Date
        TicketGross aladdinWeek1  = new TicketGross("Aladdin", 1320261, 13785, new Date(2015,3,15));
        TicketGross aladdinWeek2  = new TicketGross("Aladdin", 1445641, 13786, new Date(2015,3,22));
        TicketGross aladdinWeek3  = new TicketGross("Aladdin", 1569812, 13785, new Date(2015,3,29));
        TicketGross aladdinWeek4  = new TicketGross("Aladdin", 2024667, 15508, new Date(2015,4,5));
        TicketGross aladdinWeek5  = new TicketGross("Aladdin", 1768354, 13786, new Date(2015,4,12));
        TicketGross aladdinWeek6  = new TicketGross("Aladdin", 1534573, 13703, new Date(2015,4,19));
        TicketGross aladdinWeek7  = new TicketGross("Aladdin", 1492453, 13786, new Date(2015,4,26));
        TicketGross aladdinWeek8  = new TicketGross("Aladdin", 1408343, 13785, new Date(2015,5,3));
        TicketGross aladdinWeek9  = new TicketGross("Aladdin", 1422347, 13766, new Date(2015,5,10));
        TicketGross aladdinWeek10 = new TicketGross("Aladdin", 1467089, 13788, new Date(2015,5,17));

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

        //The Book of Mormon, Gross, Attendance, and Date
        TicketGross bomWeek1  = new TicketGross("The Book of Mormon", 1540949, 8752, new Date(2015,3,15));
        TicketGross bomWeek2  = new TicketGross("The Book of Mormon", 1547574, 8752, new Date(2015,3,22));
        TicketGross bomWeek3  = new TicketGross("The Book of Mormon", 1529584, 8751, new Date(2015,3,29));
        TicketGross bomWeek4  = new TicketGross("The Book of Mormon", 1517640, 8751, new Date(2015,4,5));
        TicketGross bomWeek5  = new TicketGross("The Book of Mormon", 1517969, 8746, new Date(2015,4,12));
        TicketGross bomWeek6  = new TicketGross("The Book of Mormon", 1467289, 8716, new Date(2015,4,19));
        TicketGross bomWeek7  = new TicketGross("The Book of Mormon", 1469646, 8744, new Date(2015,4,26));
        TicketGross bomWeek8  = new TicketGross("The Book of Mormon", 1407987, 8749, new Date(2015,5,3));
        TicketGross bomWeek9  = new TicketGross("The Book of Mormon", 1446130, 8744, new Date(2015,5,10));
        TicketGross bomWeek10 = new TicketGross("The Book of Mormon", 1534408, 8743, new Date(2015,5,17));

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

        //The Lion King, Gross, Attendance, and Date
        TicketGross lionKingWeek1  = new TicketGross("The Lion King", 1824626, 13587, new Date(2015,3,15));
        TicketGross lionKingWeek2  = new TicketGross("The Lion King", 1901829, 13499, new Date(2015,3,22));
        TicketGross lionKingWeek3  = new TicketGross("The Lion King", 2064202, 13494, new Date(2015,3,29));
        TicketGross lionKingWeek4  = new TicketGross("The Lion King", 2633531, 15295, new Date(2015,4,5));
        TicketGross lionKingWeek5  = new TicketGross("The Lion King", 2293061, 13436, new Date(2015,4,12));
        TicketGross lionKingWeek6  = new TicketGross("The Lion King", 1843464, 13187, new Date(2015,4,19));
        TicketGross lionKingWeek7  = new TicketGross("The Lion King", 1972747, 13557, new Date(2015,4,26));
        TicketGross lionKingWeek8  = new TicketGross("The Lion King", 1908299, 12937, new Date(2015,5,3));
        TicketGross lionKingWeek9  = new TicketGross("The Lion King", 1701798, 11480, new Date(2015,5,10));
        TicketGross lionKingWeek10 = new TicketGross("The Lion King", 1966567, 13508, new Date(2015,5,17));

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

        //Wicked, Gross, Attendance, and Date
        TicketGross wickedWeek1  = new TicketGross("Wicked", 1818766, 15024, new Date(2015,3,15));
        TicketGross wickedWeek2  = new TicketGross("Wicked", 1855247, 15214, new Date(2015,3,22));
        TicketGross wickedWeek3  = new TicketGross("Wicked", 1872149, 14604, new Date(2015,3,29));
        TicketGross wickedWeek4  = new TicketGross("Wicked", 2358372, 15857, new Date(2015,4,5));
        TicketGross wickedWeek5  = new TicketGross("Wicked", 2181861, 14678, new Date(2015,4,12));
        TicketGross wickedWeek6  = new TicketGross("Wicked", 1655748, 14065, new Date(2015,4,19));
        TicketGross wickedWeek7  = new TicketGross("Wicked", 1741459, 14847, new Date(2015,4,26));
        TicketGross wickedWeek8  = new TicketGross("Wicked", 1387456, 12512, new Date(2015,5,3));
        TicketGross wickedWeek9  = new TicketGross("Wicked", 1469322, 13067, new Date(2015,5,10));
        TicketGross wickedWeek10 = new TicketGross("Wicked", 1601725, 13959, new Date(2015,5,17));

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

        //Something Rotten, Gross, Attendance, and Date
        TicketGross somethingRottenWeek1  = new TicketGross("Something Rotten", 0, 0, new Date(2015,3,15));
        TicketGross somethingRottenWeek2  = new TicketGross("Something Rotten", 0, 0, new Date(2015,3,22));
        TicketGross somethingRottenWeek3  = new TicketGross("Something Rotten", 363873, 10307, new Date(2015,3,29));
        TicketGross somethingRottenWeek4  = new TicketGross("Something Rotten", 507102, 10257, new Date(2015,4,5));
        TicketGross somethingRottenWeek5  = new TicketGross("Something Rotten", 619159, 9310, new Date(2015,4,12));
        TicketGross somethingRottenWeek6  = new TicketGross("Something Rotten", 702924, 9834, new Date(2015,4,19));
        TicketGross somethingRottenWeek7  = new TicketGross("Something Rotten", 716593, 12031, new Date(2015,4,26));
        TicketGross somethingRottenWeek8  = new TicketGross("Something Rotten", 801033, 11243, new Date(2015,5,3));
        TicketGross somethingRottenWeek9  = new TicketGross("Something Rotten", 903211, 11691, new Date(2015,5,10));
        TicketGross somethingRottenWeek10 = new TicketGross("Something Rotten", 950418, 12436, new Date(2015,5,17));

        dummyList.add(somethingRottenWeek1);
        dummyList.add(somethingRottenWeek2);
        dummyList.add(somethingRottenWeek3);
        dummyList.add(somethingRottenWeek4);
        dummyList.add(somethingRottenWeek5);
        dummyList.add(somethingRottenWeek6);
        dummyList.add(somethingRottenWeek7);
        dummyList.add(somethingRottenWeek8);
        dummyList.add(somethingRottenWeek9);
        dummyList.add(somethingRottenWeek10);

        //The King And I, Gross, Attendance, and Date
        TicketGross theKingAndIWeek1  = new TicketGross("The King And I", 420879, 4188, new Date(2015,3,15));
        TicketGross theKingAndIWeek2  = new TicketGross("The King And I", 814492, 8316, new Date(2015,3,22));
        TicketGross theKingAndIWeek3  = new TicketGross("The King And I", 776946, 8377, new Date(2015,3,29));
        TicketGross theKingAndIWeek4  = new TicketGross("The King And I", 828367, 8376, new Date(2015,4,5));
        TicketGross theKingAndIWeek5  = new TicketGross("The King And I", 761311, 8376, new Date(2015,4,12));
        TicketGross theKingAndIWeek6  = new TicketGross("The King And I", 764035, 8376, new Date(2015,4,19));
        TicketGross theKingAndIWeek7  = new TicketGross("The King And I", 981217, 8376, new Date(2015,4,26));
        TicketGross theKingAndIWeek8  = new TicketGross("The King And I", 998387, 8376, new Date(2015,5,3));
        TicketGross theKingAndIWeek9  = new TicketGross("The King And I", 951532, 8376, new Date(2015,5,10));
        TicketGross theKingAndIWeek10 = new TicketGross("The King And I", 1001947, 8376, new Date(2015,5,17));

        dummyList.add(theKingAndIWeek1);
        dummyList.add(theKingAndIWeek2);
        dummyList.add(theKingAndIWeek3);
        dummyList.add(theKingAndIWeek4);
        dummyList.add(theKingAndIWeek5);
        dummyList.add(theKingAndIWeek6);
        dummyList.add(theKingAndIWeek7);
        dummyList.add(theKingAndIWeek8);
        dummyList.add(theKingAndIWeek9);
        dummyList.add(theKingAndIWeek10);

        //couldn't find the right data for beautiful. still need to change the gross and attendance
        TicketGross beautifulTheCaroleKingWeek1  = new TicketGross("Beautiful The Carole King", 955472, 7004, new Date(2015,3,15));
        TicketGross beautifulTheCaroleKingWeek2  = new TicketGross("Beautiful The Carole King", 992794, 7512, new Date(2015,3,22));
        TicketGross beautifulTheCaroleKingWeek3  = new TicketGross("Beautiful The Carole King", 979932, 7279, new Date(2015,3,29));
        TicketGross beautifulTheCaroleKingWeek4  = new TicketGross("Beautiful The Carole King", 835956, 7312, new Date(2015,4,5));
        TicketGross beautifulTheCaroleKingWeek5  = new TicketGross("Beautiful The Carole King", 1057901, 7890, new Date(2015,4,12));
        TicketGross beautifulTheCaroleKingWeek6  = new TicketGross("Beautiful The Carole King", 1045281, 7427, new Date(2015,4,19));
        TicketGross beautifulTheCaroleKingWeek7  = new TicketGross("Beautiful The Carole King", 1049011, 7536, new Date(2015,4,26));
        TicketGross beautifulTheCaroleKingWeek8  = new TicketGross("Beautiful The Carole King", 1033009, 7421, new Date(2015,5,3));
        TicketGross beautifulTheCaroleKingWeek9  = new TicketGross("Beautiful The Carole King", 1075886, 7503, new Date(2015,5,10));
        TicketGross beautifulTheCaroleKingWeek10 = new TicketGross("Beautiful The Carole King", 1124463, 7979, new Date(2015,5,17));

        dummyList.add(beautifulTheCaroleKingWeek1);
        dummyList.add(beautifulTheCaroleKingWeek2);
        dummyList.add(beautifulTheCaroleKingWeek3);
        dummyList.add(beautifulTheCaroleKingWeek4);
        dummyList.add(beautifulTheCaroleKingWeek5);
        dummyList.add(beautifulTheCaroleKingWeek6);
        dummyList.add(beautifulTheCaroleKingWeek7);
        dummyList.add(beautifulTheCaroleKingWeek8);
        dummyList.add(beautifulTheCaroleKingWeek9);
        dummyList.add(beautifulTheCaroleKingWeek10);

        return dummyList;
    }
}
