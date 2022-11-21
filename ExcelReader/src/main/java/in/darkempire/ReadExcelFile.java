package in.darkempire;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.HashMap;

public class ReadExcelFile {

    public HashMap<Integer, Integer> readFile(String fileName) {
        HashMap<Integer, Integer> roomIdsMap = new HashMap<>();
        try {
            File file = new File(fileName);   //creating a new file instance
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            int i = 0;
            for (Row row : sheet) {
                Integer roomId = null, type = null;
                for (Cell cell : row) {
                    int index = cell.getColumnIndex();
                    if (index == 0) {
                        roomId = Double.valueOf(cell.getNumericCellValue()).intValue();
                    }
                    if (index == 5) {
                        type = Double.valueOf(cell.getNumericCellValue()).intValue();
                    }
                }
                roomIdsMap.put(roomId, type);
                i++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return roomIdsMap;
    }
}
