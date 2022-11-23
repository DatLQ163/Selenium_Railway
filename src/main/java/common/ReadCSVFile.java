package common;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {
    private static final String COMMA_DELIMITER = ",";
    public static List<CSVFile> getListDataCSV(){
        BufferedReader br;
        List<CSVFile> result = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader(new FileReader("src/main/resources/route.csv"));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(COMMA_DELIMITER);
                result.add(new CSVFile(splitData));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDepartByLine(String lineNumber){
        return getListDataCSV().get(Integer.parseInt(lineNumber)-1).getDepart();
    }

    public static String getArriveByLine(String lineNumber){
        return getListDataCSV().get(Integer.parseInt(lineNumber)-1).getArrive();
    }
}
