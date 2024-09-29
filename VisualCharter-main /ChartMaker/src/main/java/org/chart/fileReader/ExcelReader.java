package org.chart.fileReader;



import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelReader {
    private List<List<String>> data;
    private List<String> headers;
    private int rowCount;
    private int columnCount;

    public ExcelReader(String filePath) throws Exception {
        this.data = new ArrayList<>();
        this.headers = new ArrayList<>();
        readExcelFile(filePath);
    }

    private void readExcelFile(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(new File(filePath));

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        this.rowCount = sheet.getPhysicalNumberOfRows();
        this.columnCount = 0;

        int rowIndex = 0;
        for (Row row : sheet) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowData.add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        rowData.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    default:
                        rowData.add("");
                }
            }
            if (rowIndex == 0) {
                headers.addAll(rowData); // İlk satırı başlık olarak al
                this.columnCount = rowData.size(); // Sütun sayısını belirle
            } else {
                data.add(rowData); // Diğer satırları veri olarak al
            }
            rowIndex++;
        }

        workbook.close();
        fis.close();
    }

    public List<List<String>> getData() {
        return data;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public String[][] dataToArray() {
        String[][] dataArray = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            List<String> rowData = data.get(i);
            dataArray[i] = rowData.toArray(new String[0]);
        }
        return dataArray;
    }

    public String[] headersToArray() {
        return headers.toArray(new String[0]);
    }

}

