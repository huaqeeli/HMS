/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Exporter {

    public ArrayList<Object[]> getTableData() throws IOException {
        ArrayList<Object[]> tableDataList = null;
        ResultSet rs = DataMng.getAllData("mandate");
        tableDataList = new ArrayList<>();
        try {
            while (rs.next()) {
                Object[] objArray = new Object[9];
                objArray[0] = rs.getString("ORDERID");
                objArray[1] = rs.getString("ORDERDATE");
                objArray[2] = rs.getString("ENFROM");
                objArray[3] = rs.getString("ENTO");
                objArray[4] = rs.getString("ENDATEFROM");
                objArray[5] = rs.getString("ENDATETO");
                objArray[6] = rs.getString("ENPLASE");
                objArray[7] = rs.getString("MILITARYTAYP");
                objArray[8] = rs.getString("ENTAYP");
                tableDataList.add(objArray);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tableDataList;
    }

    public void doExport(ArrayList<Object[]> dataList) {
        if (dataList != null && !dataList.isEmpty()) {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet();
            HSSFRow headingRow = sheet.createRow(0);
            headingRow.createCell((short) 0).setCellValue("رقم الطلب");
            headingRow.createCell((short) 1).setCellValue("تاريخ الطلب");
            headingRow.createCell((short) 2).setCellValue("الانتداب من");
            headingRow.createCell((short) 3).setCellValue("الانتداب الى");
            headingRow.createCell((short) 4).setCellValue("تاريخ الانتداب من");
            headingRow.createCell((short) 5).setCellValue("تاريخ الانتداب الى");
            headingRow.createCell((short) 6).setCellValue("مكان الانتداب");
            headingRow.createCell((short) 7).setCellValue("نوع المستفيد");
            headingRow.createCell((short) 8).setCellValue("نوع الانتداب");
            short rowNo = 1;
            for (Object[] objects : dataList) {
                HSSFRow row = sheet.createRow(rowNo);
                row.createCell((short) 0).setCellValue(objects[0].toString());
                row.createCell((short) 1).setCellValue(objects[1].toString());
                row.createCell((short) 2).setCellValue(objects[2].toString());
                row.createCell((short) 3).setCellValue(objects[3].toString());
                row.createCell((short) 4).setCellValue(objects[4].toString());
                row.createCell((short) 5).setCellValue(objects[5].toString());
                row.createCell((short) 6).setCellValue(objects[6].toString());
                row.createCell((short) 7).setCellValue(objects[7].toString());
                row.createCell((short) 8).setCellValue(objects[8].toString());
                rowNo++;
            }
          
            String file = "D:/entdab.xls";
            try {
                FileOutputStream fos = new FileOutputStream(file);
                workBook.write(fos);
                fos.flush();
            } catch (FileNotFoundException e) {
                System.out.println("Invalid directory or file not found");
            } catch (IOException e) {
                System.out.println("Error occurred while writting excel file to directory");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Exporter exporter = new Exporter();
        ArrayList<Object[]> dataList = exporter.getTableData();
        if (dataList != null && dataList.size() > 0) {
            exporter.doExport(dataList);
        } else {
            System.out.println("There is no data available in the table to export");
        }
      
    }
}
