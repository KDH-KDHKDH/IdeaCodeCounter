package codecounter.counderapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// CSV文件读取器
public class CSVReader {
    static List<String[]> data;

    protected static List<String[]> readCSVFile() {
        String csvFilePath = AppConstant.csvFilePath;
        data = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(csvFilePath));
            for (String line : lines) {
                String[] elements = line.replace("\"", "").split(",");
                data.add(elements);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}