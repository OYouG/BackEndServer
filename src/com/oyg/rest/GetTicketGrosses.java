package com.oyg.rest;

import com.oyg.TicketGross;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by msllavore on 11/20/15.
 */
public class GetTicketGrosses {
    public static void main(String[] args){
        try {
            FileInputStream file = new FileInputStream(new File("MyUpcomingEvents_20160108_154954.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
            FileOutputStream out =
                    new FileOutputStream(new File("C:\\test.xls"));
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public List<TicketGross> getGrossesFromServer(String date) { // make these Dates

        //$TODO$ use start and end date when actually talking to the correct server

        //CREATING DUMMY DATA

        List<TicketGross> dummyList = new ArrayList<>();
        //TicketGross(String name, long attendance, String startDate, String endDate)

        //An American in Paris, Gross, Attendance, and Date
        TicketGross aaipWeek1  = new TicketGross("An American In Paris", new Date(2015,3,15), 317917, 3161);
        TicketGross aaipWeek2  = new TicketGross("An American In Paris", new Date(2015,3,22), 737241, 9050);
        TicketGross aaipWeek3  = new TicketGross("An American In Paris", new Date(2015,3,29), 859761, 10620);
        TicketGross aaipWeek4  = new TicketGross("An American In Paris", new Date(2015,4,5), 967150, 12114);
        TicketGross aaipWeek5  = new TicketGross("An American In Paris", new Date(2015,4,12), 826416, 11559);
        TicketGross aaipWeek6  = new TicketGross("An American In Paris", new Date(2015,4,19), 1149324, 12546);
        TicketGross aaipWeek7  = new TicketGross("An American In Paris", new Date(2015,4,26), 1235247, 12819);
        TicketGross aaipWeek8  = new TicketGross("An American In Paris", new Date(2015,5,3), 1220230, 13026);
        TicketGross aaipWeek9  = new TicketGross("An American In Paris", new Date(2015,5,10), 1298817, 13187);
        TicketGross aaipWeek10 = new TicketGross("An American In Paris", new Date(2015,5,17), 1280110, 13417);

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
        TicketGross aladdinWeek1  = new TicketGross("Aladdin", new Date(2015,3,15), 1320261, 13785);
        TicketGross aladdinWeek2  = new TicketGross("Aladdin", new Date(2015,3,22), 1445641, 13786);
        TicketGross aladdinWeek3  = new TicketGross("Aladdin", new Date(2015,3,29), 1569812, 13785);
        TicketGross aladdinWeek4  = new TicketGross("Aladdin", new Date(2015,4,5), 2024667, 15508);
        TicketGross aladdinWeek5  = new TicketGross("Aladdin", new Date(2015,4,12), 1768354, 13786);
        TicketGross aladdinWeek6  = new TicketGross("Aladdin", new Date(2015,4,19), 1534573, 13703);
        TicketGross aladdinWeek7  = new TicketGross("Aladdin", new Date(2015,4,26), 1492453, 13786);
        TicketGross aladdinWeek8  = new TicketGross("Aladdin", new Date(2015,5,3), 1408343, 13785);
        TicketGross aladdinWeek9  = new TicketGross("Aladdin", new Date(2015,5,10), 1422347, 13766);
        TicketGross aladdinWeek10 = new TicketGross("Aladdin", new Date(2015,5,17), 1467089, 13788);

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
        TicketGross bomWeek1  = new TicketGross("The Book of Mormon", new Date(2015,3,15), 1540949, 8752);
        TicketGross bomWeek2  = new TicketGross("The Book of Mormon", new Date(2015,3,22), 1547574, 8752);
        TicketGross bomWeek3  = new TicketGross("The Book of Mormon", new Date(2015,3,29), 1529584, 8751);
        TicketGross bomWeek4  = new TicketGross("The Book of Mormon", new Date(2015,4,5), 1517640, 8751);
        TicketGross bomWeek5  = new TicketGross("The Book of Mormon", new Date(2015,4,12), 1517969, 8746);
        TicketGross bomWeek6  = new TicketGross("The Book of Mormon", new Date(2015,4,19), 1467289, 8716);
        TicketGross bomWeek7  = new TicketGross("The Book of Mormon", new Date(2015,4,26), 1469646, 8744);
        TicketGross bomWeek8  = new TicketGross("The Book of Mormon", new Date(2015,5,3), 1407987, 8749);
        TicketGross bomWeek9  = new TicketGross("The Book of Mormon", new Date(2015,5,10), 1446130, 8744);
        TicketGross bomWeek10 = new TicketGross("The Book of Mormon", new Date(2015,5,17), 1534408, 8743);

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
        TicketGross lionKingWeek1  = new TicketGross("The Lion King", new Date(2015,3,15), 1824626, 13587);
        TicketGross lionKingWeek2  = new TicketGross("The Lion King", new Date(2015,3,22), 1901829, 13499);
        TicketGross lionKingWeek3  = new TicketGross("The Lion King", new Date(2015,3,29), 2064202, 13494);
        TicketGross lionKingWeek4  = new TicketGross("The Lion King", new Date(2015,4,5), 2633531, 15295);
        TicketGross lionKingWeek5  = new TicketGross("The Lion King", new Date(2015,4,12), 2293061, 13436);
        TicketGross lionKingWeek6  = new TicketGross("The Lion King", new Date(2015,4,19), 1843464, 13187);
        TicketGross lionKingWeek7  = new TicketGross("The Lion King", new Date(2015,4,26), 1972747, 13557);
        TicketGross lionKingWeek8  = new TicketGross("The Lion King", new Date(2015,5,3), 1908299, 12937);
        TicketGross lionKingWeek9  = new TicketGross("The Lion King", new Date(2015,5,10), 1701798, 11480);
        TicketGross lionKingWeek10 = new TicketGross("The Lion King", new Date(2015,5,17), 1966567, 13508);

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
        TicketGross wickedWeek1  = new TicketGross("Wicked", new Date(2015,3,15), 1818766, 15024);
        TicketGross wickedWeek2  = new TicketGross("Wicked", new Date(2015,3,22), 1855247, 15214);
        TicketGross wickedWeek3  = new TicketGross("Wicked", new Date(2015,3,29), 1872149, 14604);
        TicketGross wickedWeek4  = new TicketGross("Wicked", new Date(2015,4,5), 2358372, 15857);
        TicketGross wickedWeek5  = new TicketGross("Wicked", new Date(2015,4,12), 2181861, 14678);
        TicketGross wickedWeek6  = new TicketGross("Wicked", new Date(2015,4,19), 1655748, 14065);
        TicketGross wickedWeek7  = new TicketGross("Wicked", new Date(2015,4,26), 1741459, 14847);
        TicketGross wickedWeek8  = new TicketGross("Wicked", new Date(2015,5,3), 1387456, 12512);
        TicketGross wickedWeek9  = new TicketGross("Wicked", new Date(2015,5,10), 1469322, 13067);
        TicketGross wickedWeek10 = new TicketGross("Wicked", new Date(2015,5,17), 1601725, 13959);

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
        TicketGross somethingRottenWeek1  = new TicketGross("Something Rotten", new Date(2015,3,15), 0, 0);
        TicketGross somethingRottenWeek2  = new TicketGross("Something Rotten", new Date(2015,3,22), 0, 0);
        TicketGross somethingRottenWeek3  = new TicketGross("Something Rotten", new Date(2015,3,29), 363873, 10307);
        TicketGross somethingRottenWeek4  = new TicketGross("Something Rotten", new Date(2015,4,5), 507102, 10257);
        TicketGross somethingRottenWeek5  = new TicketGross("Something Rotten", new Date(2015,4,12), 619159, 9310);
        TicketGross somethingRottenWeek6  = new TicketGross("Something Rotten", new Date(2015,4,19), 702924, 9834);
        TicketGross somethingRottenWeek7  = new TicketGross("Something Rotten", new Date(2015,4,26), 716593, 12031);
        TicketGross somethingRottenWeek8  = new TicketGross("Something Rotten", new Date(2015,5,3), 801033, 11243);
        TicketGross somethingRottenWeek9  = new TicketGross("Something Rotten", new Date(2015,5,10), 903211, 11691);
        TicketGross somethingRottenWeek10 = new TicketGross("Something Rotten", new Date(2015,5,17), 950418, 12436);

        dummyList.add(somethingRottenWeek1);
        dummyList.add(somethingRottenWeek2);
        dummyList.add(somethingRottenWeek3);
        dummyList.add(somethingRottenWeek4);
        dummyList.add(somethingRottenWAddedeek4);
        dummyList.add(somethingRottenWeek5);
        dummyList.add(somethingRottenWeek6);
        dummyList.add(somethingRottenWeek7);
        dummyList.add(somethingRottenWeek8);
        dummyList.add(somethingRottenWeek9);
        dummyList.add(somethingRottenWeek10);

        //The King And I, Gross, Attendance, and Date
        TicketGross theKingAndIWeek1  = new TicketGross("The King And I", new Date(2015,3,15), 420879, 4188);
        TicketGross theKingAndIWeek2  = new TicketGross("The King And I", new Date(2015,3,22), 814492, 8316);
        TicketGross theKingAndIWeek3  = new TicketGross("The King And I", new Date(2015,3,29), 776946, 8377);
        TicketGross theKingAndIWeek4  = new TicketGross("The King And I", new Date(2015,4,5), 828367, 8376);
        TicketGross theKingAndIWeek5  = new TicketGross("The King And I", new Date(2015,4,12), 761311, 8376);
        TicketGross theKingAndIWeek6  = new TicketGross("The King And I", new Date(2015,4,19), 764035, 8376);
        TicketGross theKingAndIWeek7  = new TicketGross("The King And I", new Date(2015,4,26), 981217, 8376);
        TicketGross theKingAndIWeek8  = new TicketGross("The King And I", new Date(2015,5,3), 998387, 8376);
        TicketGross theKingAndIWeek9  = new TicketGross("The King And I", new Date(2015,5,10), 951532, 8376);
        TicketGross theKingAndIWeek10 = new TicketGross("The King And I", new Date(2015,5,17), 1001947, 8376);

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
        TicketGross beautifulTheCaroleKingWeek1  = new TicketGross("Beautiful The Carole King", new Date(2015,3,15), 955472, 7004);
        TicketGross beautifulTheCaroleKingWeek2  = new TicketGross("Beautiful The Carole King", new Date(2015,3,22), 992794, 7512);
        TicketGross beautifulTheCaroleKingWeek3  = new TicketGross("Beautiful The Carole King", new Date(2015,3,29), 979932, 7279);
        TicketGross beautifulTheCaroleKingWeek4  = new TicketGross("Beautiful The Carole King", new Date(2015,4,5), 835956, 7312);
        TicketGross beautifulTheCaroleKingWeek5  = new TicketGross("Beautiful The Carole King", new Date(2015,4,12), 1057901, 7890);
        TicketGross beautifulTheCaroleKingWeek6  = new TicketGross("Beautiful The Carole King", new Date(2015,4,19), 1045281, 7427);
        TicketGross beautifulTheCaroleKingWeek7  = new TicketGross("Beautiful The Carole King", new Date(2015,4,26), 1049011, 7536);
        TicketGross beautifulTheCaroleKingWeek8  = new TicketGross("Beautiful The Carole King", new Date(2015,5,3), 1033009, 7421);
        TicketGross beautifulTheCaroleKingWeek9  = new TicketGross("Beautiful The Carole King", new Date(2015,5,10), 1075886, 7503);
        TicketGross beautifulTheCaroleKingWeek10 = new TicketGross("Beautiful The Carole King", new Date(2015,5,17), 1124463, 7979);

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
    }*/
}
