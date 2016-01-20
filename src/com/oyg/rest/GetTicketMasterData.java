package com.oyg.rest;

import com.oyg.TicketMaster;

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

    public static ArrayList<ArrayList<String>> readSheet(Sheet sheet) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            ArrayList<String> values = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date dateToAdd = cell.getDateCellValue();
                        String dateStringFormat = df.format(dateToAdd);
                        values.add(dateStringFormat);
                    } else {
                        values.add(Double.toString(cell.getNumericCellValue()));
                    }
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    values.add(cell.getStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    values.add("0");
                }
            }
            result.add(values);
        }
        return result;
    }
    //public List<TicketMaster> readTicketMasterEventsSummary() {
    public static void main(String[] args){
        ArrayList<TicketMaster> ListOfTicketMasterData = new ArrayList<>();
        try
        {
            //FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan18.xls"));
            FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan18.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<ArrayList<String>> values = readSheet(sheet);
            for (int i=0; i<values.size(); i++)
            {
                if (values.get(i).size() == 22) {
                    try {
                        // if you have all necessary values, create an object to put into database
                        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                        Date dateDateFormat = df.parse(values.get(i).get(7));

                        DateFormat tf = new SimpleDateFormat("hh:mm a");
                        Date date = tf.parse(values.get(i).get(6));
                        Time time = new Time(date.getTime());

                        TicketMaster tmsales = new TicketMaster(values.get(i).get(2), time,
                                dateDateFormat, Double.valueOf(values.get(i).get(10)).intValue(), BigDecimal.valueOf(Double.valueOf(values.get(i).get(11))),
                                Double.valueOf(values.get(i).get(12)).intValue(), Double.valueOf(values.get(i).get(14)).intValue(),
                                Double.valueOf(values.get(i).get(15)).intValue(), BigDecimal.valueOf(Double.valueOf(values.get(i).get(17))),
                                Double.valueOf(values.get(i).get(19)).intValue(), Double.valueOf(values.get(i).get(20)).intValue());

                        ListOfTicketMasterData.add(tmsales);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            file.close();
            System.out.println("Size of final list: " + ListOfTicketMasterData.size());
            for (TicketMaster thing : ListOfTicketMasterData) {
                System.out.println(thing);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        //return ListOfTicketMasterData;
    }
    /*
    //public List<TicketMaster> readTicketMasterEventsSummary() {
    public static void main(String[] args){
        ArrayList<TicketMaster> ListOfTicketMasterData = new ArrayList<>();
        try
        {
            //FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan18.xls"));
            FileInputStream file = new FileInputStream(new File("/Users/msllavore/Desktop/Inf191/ticketMaster/BasicSummary_Jan18.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                ArrayList<String> values = new ArrayList<>();
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                //df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date dateToAdd = cell.getDateCellValue();
                            String dateStringFormat = df.format(dateToAdd);
                            values.add(dateStringFormat);
                        } else {
                            values.add(Double.toString(cell.getNumericCellValue()));
                        }
                    } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        values.add(cell.getStringCellValue());
                    } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        values.add("0");
                    }
                }

                if (values.size() == 22) {
                    try {
                        // if you have all necessary values, create an object to put into database
                        Date dateDateFormat = df.parse(values.get(7));

                        DateFormat tf = new SimpleDateFormat("hh:mm a");
                        Date date = tf.parse(values.get(6));
                        Time time = new Time(date.getTime());

                        TicketMaster tmsales = new TicketMaster(values.get(2), time,
                                dateDateFormat, Double.valueOf(values.get(10)).intValue(), BigDecimal.valueOf(Double.valueOf(values.get(11))),
                                Double.valueOf(values.get(12)).intValue(), Double.valueOf(values.get(14)).intValue(),
                                Double.valueOf(values.get(15)).intValue(), BigDecimal.valueOf(Double.valueOf(values.get(17))),
                                Double.valueOf(values.get(19)).intValue(), Double.valueOf(values.get(20)).intValue());

                        ListOfTicketMasterData.add(tmsales);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            file.close();
            System.out.println("Size of final list: " + ListOfTicketMasterData.size());
            for (TicketMaster thing : ListOfTicketMasterData) {
                System.out.println(thing);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        //return ListOfTicketMasterData;
    }
    */
}
