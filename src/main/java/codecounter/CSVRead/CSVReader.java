package codecounter.CSVRead;

import codecounter.counderapp.AppConstant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// CSV文件读取器
public class CSVReader {
    public static List<String[]> csvData;

    public static void readCSVFile(String csvFilePath) {
        csvData = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(csvFilePath));
            for (String line : lines) {
                String[] elements = line.replace("\"", "").split(",");
                csvData.add(elements);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}