package in.darkempire;

import java.io.*;

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
            while((line=br.readLine())!=null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println(sb);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printMySignature();
    }
}