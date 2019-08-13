/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelRead {

    public static void main(String[] args) throws Exception {
//  
// An excel file name. You can create a file name with a full  
// path information.  
//  
        String filename = "D:\\data.xls";
//  
// Create an ArrayList to store the data read from excel sheet.  
//  
        List sheetData = new ArrayList();
        FileInputStream fis = null;
        try {
//  
// Create a FileInputStream that will be use to read the  
// excel file.  
//  
            fis = new FileInputStream(filename);
//  
// Create an excel workbook from the file system.  
//  
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
//  
// Get the first sheet on the workbook.  
//  
            HSSFSheet sheet = workbook.getSheetAt(0);
//  
// When we have a sheet object in hand we can iterator on  
// each sheet's rows and on each row's cells. We store the  
// data read on an ArrayList so that we can printed the  
// content of the excel to the console.  
//  
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        showExelData(sheetData);
        insertData(sheetData);
    }

    private static void insertData(List sheetData) {
        String rank = null;
        String militryid = null;
        String name = null;
        String specialization = null;
        String idnumber = null;
        String unitinforce = null;
        Connection con = DatabaseConnector.dbConnector();
        PreparedStatement sql_statement = null;
        String jdbc_insert_sql = "INSERT INTO formation"
                + "(`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`SPECIALIZATION`,`UNIT_IN_FORCE`) VALUES"
                + "(?,?,?,?,?,?)";
        try {
            sql_statement = con.prepareStatement(jdbc_insert_sql);
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                for (int j = 0; j < list.size(); j++) {
                     Cell cell = (Cell) list.get(j);
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    sql_statement.setString(1, (String) list.get(1));
                    sql_statement.setString(2, (String) list.get(2));
                    sql_statement.setString(3, (String) list.get(0));
                    sql_statement.setString(4, (String) list.get(4));
                    sql_statement.setString(5, (String) list.get(3));
                    sql_statement.setString(6, (String) list.get(5));
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue());
                }
                    
                    if (j < list.size() - 1) {
                        System.out.print(", ");
                    }
                }
                sql_statement.executeUpdate(); //we can execute the statement before  
                con.commit();
                con.close();
                System.out.println("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExcelRead.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void showExelData(List sheetData) {

        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                Cell cell = (Cell) list.get(j);
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(cell.getRichStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue());
                }
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
}
