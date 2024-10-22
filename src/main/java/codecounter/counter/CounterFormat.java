package codecounter.counter;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CounterFormat {
    static ArrayList<String[]> fileStatsEntries = updateFileStatsEntries(CodeLineCounter.fileStatsMap);

    /**
     * 获取数据，将HashMap转换为String[]的ArrayList
     * @param fileStatsMap
     * @return datas
     */
    private static ArrayList<String[]> updateFileStatsEntries(Map<String, FileStats> fileStatsMap) {
        ArrayList<String[]> fileStatsEntries = new ArrayList<>();
        for (Map.Entry<String, FileStats> entry : fileStatsMap.entrySet()) {
            String[] temp = new String[7];
            FileStats stats = entry.getValue();

            temp[0] = entry.getKey();
            temp[1] = Integer.toString(stats.fileCnt);
            temp[2] = Integer.toString(stats.totalLines);
            temp[3] = Integer.toString(stats.emptyLines);
            temp[4] = Integer.toString(stats.singleCommentLines);
            temp[5] = Integer.toString(stats.multiCommentLines);
            temp[6] = Integer.toString(stats.codeLines);

            fileStatsEntries.add(temp);
        }

        return fileStatsEntries;
    }

//    /**
//     * 在系统默认应用中打开CSV
//     * @param csvFile
//     */
//    protected static void openCSV(String csvFile) {
//        File file = new File(csvFile);
//
//        try {
//            if (file.exists()) {
//                Desktop.getDesktop().open(file);
//            } else {
//                System.out.println("文件不存在");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 输出数据表格CSV
     */
    protected static void outPutSummaryCSV() {
        fileStatsEntries = updateFileStatsEntries(CodeLineCounter.fileStatsMap);
        if(fileStatsEntries.isEmpty()) {
            return;
        }

        String outDirectoryPath = Constant.projectRoot + File.separator + "output";
        String csvFilePath = outDirectoryPath + File.separator + "output.csv";

        // 创建File对象
        File directory = new File(outDirectoryPath);
        File file = new File(csvFilePath);

        // 检查out目录是否存在，如果不存在则创建
        if (!directory.exists() && !directory.mkdirs()) {
            System.out.println("Failed to create out directory.");
            return;
        }

        String[] header = Constant.initHeader;

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {   // 生成CSV
            writer.writeNext(header);
            for(String[] entry : fileStatsEntries) {
                writer.writeNext(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
