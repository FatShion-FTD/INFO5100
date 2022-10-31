import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcess {
    private static String buffer = null;        // memory buffer
    private static String display = null;       // write box display buffer

    // read the file from name in read TextBox
    public static String readFile(String fileName) {
        String res = null;
        try {
            BufferedReader inStream = new BufferedReader(new FileReader(fileName));     // IO read the file
            StringBuilder sb = new StringBuilder(), sbDisplay = new StringBuilder(), 
                            sbRes = new StringBuilder();                                // buffer for reading
            String line = inStream.readLine();                                          // read one line
            int cnt = 0;

            while (line != null) {
                String t = select3Cols(line);                                           // only select first 3 cols for each line
                if (cnt++ < 5) {                                                        // record first 5 lines
                    sbDisplay.append(t);                                                // buffer for write text box 
                    sbRes.append(line + "\n");                                                 // buffer for read text box
                }
                sb.append(t);                                                           // buffer for write context 
                line = inStream.readLine();                                             // read next line
            }
            inStream.close();
            
            buffer = sb.toString();
            display = sbDisplay.toString();
            res = sbRes.toString();
        } catch (FileNotFoundException e) {                                             // no such file exception
            res = "IOERROR: File Not Found: " + fileName + "\n";
            e.printStackTrace();
        } catch (IOException e) {                                                       // other IO exception
            res = "IOERROR: " + e.getMessage() + "\n";
            e.printStackTrace();
        }
        return res;
    }

    // select the first 3 cols
    public static String select3Cols(String s) {
        StringBuilder sb = new StringBuilder();
        String[] items = s.split(",");                                             // separte by ,
        for (int j = 0; j < 3 && j < items.length; j++) {                                 // get first 3
            sb.append(items[j]);
            if (j < 2)
                sb.append(",");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String writeFile(String readFile, String writeFile) {
        String res = null;
        try {
            FileWriter outStream = new FileWriter(writeFile);                               // IO write the file
            outStream.write(buffer);                                                        // write context buffer into file
            outStream.close();
            res = display;
        } catch (Exception e) {
            res = "IOERROR: " + e.getMessage() + "\n";
            e.printStackTrace();
        }
        return res;
    }
}