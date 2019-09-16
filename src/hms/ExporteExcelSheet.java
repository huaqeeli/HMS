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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExporteExcelSheet {
    ResultSet rs;
    String[] feild;
    String[] titel;

    public ExporteExcelSheet(ResultSet rs, String[] feild,String[] titel) {
        this.rs = rs;
        this.feild = feild;
        this.titel = titel;
    }
   

    public ArrayList<Object[]> getTableData() throws IOException {
        ArrayList<Object[]> tableDataList = null;
        tableDataList = new ArrayList<>();
        try {
            while (rs.next()) {
                Object[] objArray = new Object[feild.length];
                for (int i = 0; i < feild.length; i++) {
                     objArray[i]= rs.getString(feild[i]);
                }
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
            for (int i = 0; i < titel.length; i++) {
                headingRow.createCell((short) i).setCellValue(titel[i]);
            }
//            short rowNo = 1;
//            for (Object[] objects : dataList) {
//                HSSFRow row = sheet.createRow(rowNo);
//                row.createCell((short) rowNo-1).setCellValue(objects[rowNo-1].toString());
//                rowNo++;
//            }
            for (int i = 0; i < dataList.size(); i++) {
                HSSFRow row = sheet.createRow(i+1);
                row.createCell((short) i).setCellValue(Arrays.toString(dataList.get(i)));
            }
          
            String file = "D:/entdab1.xls";
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
        /* headingRow.createCell((short) 0).setCellValue("رقم الطلب","تاريخ الطلب","الانتداب من","الانتداب الى","تاريخ الانتداب من","تاريخ الانتداب الى","مكان الانتداب","نوع المستفيد","نوع الانتداب");*/
          ResultSet rs = DataMng.getAllData("mandate");
           String[] feild = {"ORDERDATE","ENFROM","ENTO","ENDATEFROM","ENDATETO","ENPLASE","MILITARYTAYP","ENTAYP"};
          String[] titel={"رقم الطلب","تاريخ الطلب","الانتداب من","الانتداب الى","تاريخ الانتداب من","تاريخ الانتداب الى","مكان الانتداب","نوع المستفيد","نوع الانتداب"};
        ExporteExcelSheet exporter = new ExporteExcelSheet(rs,feild,titel);
        ArrayList<Object[]> dataList = exporter.getTableData();
        if (dataList != null && dataList.size() > 0) {
            exporter.doExport(dataList);
        } else {
            System.out.println("There is no data available in the table to export");
        }
      
    }
}
