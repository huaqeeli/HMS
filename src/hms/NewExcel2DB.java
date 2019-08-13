/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.*;
import java.sql.SQLException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewExcel2DB {

    public static void main(String[] args) throws Exception {
        String rank = null;
        String militryid = null;
        String name = null;
        String specialization = null;
        String idnumber = null;
        String unitinforce = null;
        try {

            Connection con = DatabaseConnector.dbConnector();
            PreparedStatement sql_statement = null;
            String jdbc_insert_sql = "INSERT INTO formation"
                    + "(`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`SPECIALIZATION`,`UNIT_IN_FORCE`) VALUES"
                    + "(?,?,?,?,?,?)";
            sql_statement = con.prepareStatement(jdbc_insert_sql);
            FileInputStream input = new FileInputStream("D:\\data.xls");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                HSSFRow HSSFRow = sheet.getRow(i);
                HSSFRow row = null;
                rank = row.getCell(0).getStringCellValue();
                militryid = row.getCell(1).getStringCellValue();
                name = row.getCell(2).getStringCellValue();
                specialization = row.getCell(3).getStringCellValue();
                idnumber = row.getCell(4).getStringCellValue();
                unitinforce = row.getCell(5).getStringCellValue();

                System.out.println("Import rows " + i);
            }
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                    sql_statement.setString(1, militryid);
                    sql_statement.setString(2, name);
                    sql_statement.setString(3, rank);
                    sql_statement.setString(4, idnumber);
                    sql_statement.setString(5, specialization);
                    sql_statement.setString(6, unitinforce);
                }
            }
            sql_statement.executeUpdate(); //we can execute the statement before  
            con.commit();
            con.close();
            input.close();
            System.out.println("Success import excel to mysql table");
        } catch (SQLException | IOException e) {
            System.out.println(e);
        }
    }
}
