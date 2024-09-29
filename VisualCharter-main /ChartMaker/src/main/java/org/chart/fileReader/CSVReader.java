package org.chart.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private String[][] data;
    private String[] header;

    public CSVReader(String filePath) {
        readCSV(filePath);
    }

    private void readCSV(String filePath) {
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filePath));
            List<String[]> dataList = new ArrayList<>();
            int rowIdx = 0;
            int colIdx = 0;

            if ((line = reader.readLine()) != null) {
                header = line.split(";");
            }

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                colIdx = Math.max(colIdx, columns.length);
                dataList.add(columns);
                rowIdx++;
            }

            data = new String[rowIdx][colIdx];

            for (int i = 0; i < dataList.size(); i++) {
                String[] row = dataList.get(i);
                for (int j = 0; j < row.length; j++) {
                    data[i][j] = row[j];
                }
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] getHeader() {
        return header;
    }

    public int getRowCount() {
        return data.length + 1;
    }

    public int getColumnCount() {
        return data[0].length;
    }

    public String[][] getData() {
        return data;
    }

}