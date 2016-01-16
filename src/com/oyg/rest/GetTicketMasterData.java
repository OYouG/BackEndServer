package com.oyg.rest;

import com.oyg.TicketMaster;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

/**
 * Created by msllavore on 1/15/16.
 */
public class GetTicketMasterData {

    public static void main(String[] args) {
        try {
            ArrayList<TicketMaster> TicketMasterData = new ArrayList<>();

            FileInputStream file = new FileInputStream(new File("/Users/msllavore/IdeaProjects/BackEndServer/MyUpcomingEvents_20160108_154954.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            // skip non-tabular data and column titles
            for (int i=0; i<7; i++){
                rowIterator.next();
            }

            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                ArrayList<String> values = new ArrayList<>();
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd zzz");
                df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                    {
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            Date dateToAdd = cell.getDateCellValue();
                            String dateStringFormat = df.format(dateToAdd);
                            //System.out.println("date added: " + df.format(dateToAdd));
                            values.add(dateStringFormat);
                        } else {
                            values.add(Double.toString(cell.getNumericCellValue()));
                        }
                    }
                    else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
                    {
                        values.add(cell.getStringCellValue());
                    }
                }

                if(values.size() != 0) {
                    try{
                        Date dateDateFormat = df.parse(values.get(7));

                        DateFormat tf = new SimpleDateFormat("hh:mm a"); //DateFormat date24Format = new SimpleDateFormat("HH:mm");
                        Date date = tf.parse(values.get(6));
                        Time time = new Time(date.getTime());

                        TicketMaster tmsales = new TicketMaster(values.get(2), time,
                                dateDateFormat, Double.valueOf(values.get(8)),
                                Double.valueOf(values.get(9)), Double.valueOf(values.get(10)),
                                Double.valueOf(values.get(11)), Double.valueOf(values.get(13)));
                        TicketMasterData.add(tmsales);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            file.close();
            FileOutputStream out =
                    new FileOutputStream(new File("/Users/msllavore/IdeaProjects/BackEndServer/MyUpcomingEvents_20160108_154954.xls"));
            workbook.write(out);
            out.close();

            for (TicketMaster thing: TicketMasterData)
            {
                System.out.println(thing);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
