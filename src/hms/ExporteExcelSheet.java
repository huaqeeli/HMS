
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

public class ExporteExcelSheet {

    ResultSet rs;
    String[] feild;
    String[] titel;

    public ExporteExcelSheet(ResultSet rs, String[] feild, String[] titel) {
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
                    objArray[i] = rs.getString(feild[i]);
                }
                tableDataList.add(objArray);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tableDataList;
    }

    public void doExport(ArrayList<Object[]> dataList,String saveFile) {
        if (dataList != null && !dataList.isEmpty()) {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet();
            HSSFRow headingRow = sheet.createRow(0);
            for (int i = 0; i < titel.length; i++) {
                headingRow.createCell((short) i).setCellValue(titel[i]);
            }
            short rowNo = 1;
            for (Object[] objects : dataList) {
                HSSFRow row = sheet.createRow(rowNo);
                for (int i = 0; i < feild.length; i++) {
                    row.createCell((short) i).setCellValue(objects[i].toString());
                }
                rowNo++;
            }

            String file = saveFile+".xls";
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
}
