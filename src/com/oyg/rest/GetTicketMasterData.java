package com.oyg.rest;

import com.oyg.TicketMasterEvents;
import com.oyg.TicketMasterPriceLevels;
import com.oyg.TicketMasterTraffic;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
// import org.apache.poi.hssf.usermodel.HSSFWorkbook; // import org.apache.poi.xssf.usermodel.XSSFWorkbook;


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
    public List<TicketMasterEvents> readTicketMasterEventsSummary(String filePath) {
        ArrayList<TicketMasterEvents> ListOfTicketMasterEvents = new ArrayList<>();
        try
        {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<ArrayList<String>> eventsData = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            Iterator<Row> rowIterator = sheet.iterator();

            String dateTodayString;
            Date dateTodayDate = null;
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
                else {
                    if (numOfCols > 0)
                    {
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell cell;

                        while (cellIterator.hasNext())
                        {
                            cell = cellIterator.next();
                            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                if (cell.getStringCellValue().toLowerCase().equals("data as of"))
                                {
                                    cell = cellIterator.next();
                                    dateTodayString = cell.getStringCellValue().replace("Data as of ","");
                                    DateFormat dateGenForm = new SimpleDateFormat("dd-MMM-yy");
                                    dateTodayDate = dateGenForm.parse(dateTodayString);
                                }
                            }
                        }
                    }
                }
            }
            int startingRow = 0;
            for (int i=0; i<eventsData.size(); i++)
            {
                if (eventsData.get(i).get(0).equals("1.0")) {
                    startingRow = i;
                    break;
                }
            }

            for (int i=startingRow; i<eventsData.size(); i++)
            {
                if (eventsData.get(i).size() == 22)
                {
                    Date dateDateFormat = df.parse(eventsData.get(i).get(7));

                    DateFormat tf = new SimpleDateFormat("hh:mm a");
                    Date date = tf.parse(eventsData.get(i).get(6));
                    Time time = new Time(date.getTime());

                    TicketMasterEvents tmevents = new TicketMasterEvents(eventsData.get(i).get(2), time,
                            dateDateFormat, dateTodayDate, Double.valueOf(eventsData.get(i).get(10)).intValue(), BigDecimal.valueOf(Double.valueOf(eventsData.get(i).get(11))),
                            Double.valueOf(eventsData.get(i).get(12)).intValue(), Double.valueOf(eventsData.get(i).get(14)).intValue(),
                            Double.valueOf(eventsData.get(i).get(15)).intValue(), BigDecimal.valueOf(Double.valueOf(eventsData.get(i).get(17))),
                            Double.valueOf(eventsData.get(i).get(19)).intValue(), Double.valueOf(eventsData.get(i).get(20)).intValue());
                    ListOfTicketMasterEvents.add(tmevents);
                }
            }

            file.close();
            System.out.println("Size of final list: " + ListOfTicketMasterEvents.size());
            ListOfTicketMasterEvents.forEach(System.out::println);
        }
        catch (ParseException | InvalidFormatException | IOException e) { e.printStackTrace(); }
        return ListOfTicketMasterEvents;
    }

    public List<TicketMasterTraffic> readTicketMasterWebTraffic(String filePath) {
        ArrayList<TicketMasterTraffic> ListOfTicketMasterTraffic = new ArrayList<>();
        try
        {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);

            Sheet sheet1 = workbook.getSheetAt(0);
            ArrayList<ArrayList<String>> trafficData = new ArrayList<>();
            Set<Date> uniqueDates = new HashSet<>();

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            // read 1st sheet for evcode
            Iterator<Row> rowIterator1 = sheet1.iterator();
            String evCode = null;

            while (rowIterator1.hasNext()) {
                Row row = rowIterator1.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();

                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    String cellStringValue = cell.getStringCellValue();
                    if (cellStringValue.toLowerCase().equals("event code")) {
                        evCode = cellIterator.next().getStringCellValue();
                        break;
                    }
                }
            }

            // read 2nd sheet for actual edp traffic data
            Sheet sheet2 = workbook.getSheetAt(1);
            Iterator<Row> rowIterator2 = sheet2.iterator();

            while (rowIterator2.hasNext()) {
                Row row = rowIterator2.next();
                int numOfCols = row.getLastCellNum();

                if (numOfCols >= 6) // some of first rows have more than 6 (i.e.,7) columns, tho only 6 contain data
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
            ListOfTicketMasterTraffic.forEach(System.out::println);
        }
        catch (ParseException | InvalidFormatException | IOException e) { e.printStackTrace(); }
        return ListOfTicketMasterTraffic;
    }

    public List<TicketMasterPriceLevels> readTicketMasterPriceLevels(String filePath) {
        ArrayList<TicketMasterPriceLevels> ListOfTicketMasterPriceLevels = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);

            Sheet sheet1 = workbook.getSheetAt(0);
            ArrayList<ArrayList<String>> priceData = new ArrayList<>();

            //DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            // read 1st sheet for evcode and to find dateToday
            Iterator<Row> rowIterator1 = sheet1.iterator();
            String evCode = null;
            String dateTodayString;
            Date dateTodayDate = null;

            // adds all rows to priceData with each row organized in a single arraylist
            // this includes the table column headers and the footer totals/aggregations
            while (rowIterator1.hasNext()) {
                Row row = rowIterator1.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();

                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    String cellStringValue = cell.getStringCellValue();
                    if (cellStringValue.toLowerCase().equals("date generated")) {
                        cell = cellIterator.next();
                        dateTodayString = cell.getStringCellValue();
                        DateFormat dateTodayForm = new SimpleDateFormat("MM/dd/yyyy");
                        dateTodayDate = dateTodayForm.parse(dateTodayString);

                    } else if (cellStringValue.toLowerCase().equals("event code")) {
                        cell = cellIterator.next();
                        evCode = cell.getStringCellValue();
                        break;
                    }
                }
            }

            // read 2nd sheet with actual price level breakdown
            Sheet sheet2 = workbook.getSheetAt(1);
            Iterator<Row> rowIterator2 = sheet2.iterator();

            while (rowIterator2.hasNext()) {
                Row row = rowIterator2.next();
                int numOfCols = row.getLastCellNum();

                if (numOfCols >= 7) // 7 columns in table
                {
                    ArrayList<String> values = new ArrayList<>();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    for (int i=0; i<7; i++)
                    {
                        cell = cellIterator.next();
                        // not expecting dates in the table so don't check for them
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) { values.add(Double.toString(cell.getNumericCellValue())); }
                        else if (cell.getCellType() == Cell.CELL_TYPE_STRING) { values.add(cell.getStringCellValue()); }
                        else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) { values.add("0"); }
                    }
                    priceData.add(values);
                }
            }

            // skipping first and last rows (header and footer of the columns, not price level details
            for (int i=1; i<priceData.size()-1; i++)
            {
                //Date dateDateFormat = df.parse(priceData.get(i).get(0));
                TicketMasterPriceLevels tmplevels = new TicketMasterPriceLevels(evCode,
                        priceData.get(i).get(0), dateTodayDate,
                        Double.valueOf(priceData.get(i).get(1)).intValue(),
                        Double.valueOf(priceData.get(i).get(2)).intValue(),
                        BigDecimal.valueOf(Double.valueOf(priceData.get(i).get(3))),
                        Double.valueOf(priceData.get(i).get(6)));
                ListOfTicketMasterPriceLevels.add(tmplevels);
            }
            System.out.println("Size of final list: " + ListOfTicketMasterPriceLevels.size());
            ListOfTicketMasterPriceLevels.forEach(System.out::println);
        }
            catch (ParseException | InvalidFormatException | IOException e) { e.printStackTrace(); }
            return ListOfTicketMasterPriceLevels;
        }
}


