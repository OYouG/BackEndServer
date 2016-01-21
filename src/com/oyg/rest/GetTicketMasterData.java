package com.oyg.rest;

import com.oyg.TicketMasterEvents;
import com.oyg.TicketMasterTraffic;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by msllavore on 1/15/16.
 */
public class GetTicketMasterData {
    public List<TicketMasterEvents> readTicketMasterEventsSummary() {
        ArrayList<TicketMasterEvents> ListOfTicketMasterEvents = new ArrayList<>();
        try
        {
            //FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan18.xls"));
            FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan18.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<ArrayList<String>> eventsData = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int numOfCols = row.getLastCellNum();

                if (numOfCols == 22)
                {
                    ArrayList<String> values = new ArrayList<>();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;

                    while (cellIterator.hasNext())
                    {
                        cell = cellIterator.next();
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date dateToAdd = cell.getDateCellValue();
                                String dateStringFormat = df.format(dateToAdd);
                                values.add(dateStringFormat);
                            }
                            else { values.add(Double.toString(cell.getNumericCellValue())); }
                        }
                        else if (cell.getCellType() == Cell.CELL_TYPE_STRING) { values.add(cell.getStringCellValue()); }
                        else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) { values.add("0"); }
                    }
                    eventsData.add(values);
                }
            }

            for (int i=0; i<eventsData.size()-1; i++)
            {
                Date dateDateFormat = df.parse(eventsData.get(i).get(7));

                DateFormat tf = new SimpleDateFormat("hh:mm a");
                Date date = tf.parse(eventsData.get(i).get(6));
                Time time = new Time(date.getTime());

                TicketMasterEvents tmevents = new TicketMasterEvents(eventsData.get(i).get(2), time,
                        dateDateFormat, Double.valueOf(eventsData.get(i).get(10)).intValue(), BigDecimal.valueOf(Double.valueOf(eventsData.get(i).get(11))),
                        Double.valueOf(eventsData.get(i).get(12)).intValue(), Double.valueOf(eventsData.get(i).get(14)).intValue(),
                        Double.valueOf(eventsData.get(i).get(15)).intValue(), BigDecimal.valueOf(Double.valueOf(eventsData.get(i).get(17))),
                        Double.valueOf(eventsData.get(i).get(19)).intValue(), Double.valueOf(eventsData.get(i).get(20)).intValue());
                ListOfTicketMasterEvents.add(tmevents);
            }

            file.close();
            System.out.println("Size of final list: " + ListOfTicketMasterEvents.size());
            for (TicketMasterEvents thing : ListOfTicketMasterEvents) { System.out.println(thing); }
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (InvalidFormatException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }
        return ListOfTicketMasterEvents;
    }

    //public List<TicketMaster> readTicketMasterWebTraffic() {
    public static void main(String[] args){
        ArrayList<TicketMasterTraffic> ListOfTicketMasterTraffic = new ArrayList<>();
        try
        {
            FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/tmOne/traffic-trends.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);

            Sheet sheet1 = workbook.getSheetAt(0);
            ArrayList<ArrayList<String>> trafficData = new ArrayList<>();
            Set<Date> uniqueDates = new HashSet<>();

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            Iterator<Row> rowIterator1 = sheet1.iterator();
            String evCode = null;
            while (rowIterator1.hasNext()) {
                Row row = rowIterator1.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();

                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    String cellStringValue = cell.getStringCellValue();
                    if (cellStringValue.toLowerCase().equals("event code")) {
                        cell = cellIterator.next();
                        evCode = cell.getStringCellValue();
                        break;
                    }
                }
            }

            Sheet sheet2 = workbook.getSheetAt(1);
            Iterator<Row> rowIterator2 = sheet2.iterator();

            while (rowIterator2.hasNext()) {
                Row row = rowIterator2.next();
                int numOfCols = row.getLastCellNum();

                if (numOfCols >= 6) // some of first rows have 7 columns even tho only 6 contain data
                {
                    ArrayList<String> values = new ArrayList<>();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    for (int i=0; i<6; i++)
                    {
                        cell = cellIterator.next();
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date dateToAdd = cell.getDateCellValue();
                                String dateStringFormat = df.format(dateToAdd);
                                values.add(dateStringFormat);
                            }
                            else { values.add(Double.toString(cell.getNumericCellValue())); }
                        }
                        else if (cell.getCellType() == Cell.CELL_TYPE_STRING) { values.add(cell.getStringCellValue()); }
                        else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) { values.add("0"); }
                        trafficData.add(values);
                    }
                }
            }

            for (int i=0; i<trafficData.size(); i++)
            {
                if (trafficData.get(i).size() == 6)
                {
                    if (!trafficData.get(i).get(0).toLowerCase().equals("date"))
                    {
                        Date dateDateFormat = df.parse(trafficData.get(i).get(0));
                        if (!uniqueDates.contains(dateDateFormat)){
                            uniqueDates.add(dateDateFormat);
                            TicketMasterTraffic tmtraffic = new TicketMasterTraffic(evCode, dateDateFormat,
                                    Double.valueOf(trafficData.get(i).get(1)).intValue(),
                                    Double.valueOf(trafficData.get(i).get(2)).intValue(),
                                    Double.valueOf(trafficData.get(i).get(3)).intValue(),
                                    BigDecimal.valueOf(Double.valueOf(trafficData.get(i).get(5))));
                            ListOfTicketMasterTraffic.add(tmtraffic);
                        }
                    }
                }
            }

            System.out.println("Size of final list: " + ListOfTicketMasterTraffic.size());
            for (TicketMasterTraffic thing : ListOfTicketMasterTraffic) { System.out.println(thing); }
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (InvalidFormatException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }
        //return ListOfTicketMasterTraffic;
    }
}


