package in.darkempire;

import java.io.*;
import java.util.HashMap;

/**
 * This program is developed by Amit Kumar Giri.
 *
 * Email: allyamit@gmail.com
 * Portfolio: http://darkempire.in/
 */
public class Main {

    public static void printMySignature() {
        Constants c = new Constants();
        try {
            final File file = new File(c.getResourceFile("amit.signature").toURI());
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line=br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        printMySignature();

        ReadExcelFile ref = new ReadExcelFile();
        HashMap<Integer, Integer> roomIds = ref.readFile("rummy_table_ID_edit_first100K.xlsx");
        roomIds.putAll(ref.readFile("rummy_table_ID_edit_second100K.xlsx"));
        try {
            final File file = new File("tableIds.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int countFound = 0;
            while ((line=br.readLine()) != null) {
                Integer roomId = Integer.parseInt(line);
                if (roomIds.containsKey(roomId)) {
                    countFound++;
                    // do something while match
                }
            }
            fr.close();
            System.out.println("FoundCount: " + countFound);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}