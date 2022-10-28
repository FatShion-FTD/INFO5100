import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcess {
    private static String buffer = null;        // memory buffer
    private static String display = null;       // display buffer

    // read the file from name
    public static String readFile(String fileName) {
        String res = null;
        try {
            BufferedReader inStream = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder(), sbDisplay = new StringBuilder();
            String line = inStream.readLine();
            int cnt = 0;

            while (line != null) {
                String t = select3Cols(line);
                if (cnt++ < 5) {
                    sbDisplay.append(t);
                }
                sb.append(t);
                line = inStream.readLine();
            }
            inStream.close();

            buffer = sb.toString();
            display = sbDisplay.toString();
            res = display;
        } catch (FileNotFoundException e) {
            res = "IOERROR: File Not Found: " + fileName + "\n";
            e.printStackTrace();
        } catch (IOException e) {
            res = "IOERROR: " + e.getMessage() + "\n";
            e.printStackTrace();
        }
        return res;
    }

    public static String select3Cols(String s) {
        StringBuilder sb = new StringBuilder();
        String[] items = s.split(",");
        for (int j = 0; j < 3 && j < items.length; j++) {
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
            // wirte
            FileWriter outStream = new FileWriter(writeFile);
            outStream.write(buffer);
            outStream.close();
            res = display;
        } catch (Exception e) {
            res = "IOERROR: " + e.getMessage() + "\n";
            e.printStackTrace();
        }
        return res;
    }
}