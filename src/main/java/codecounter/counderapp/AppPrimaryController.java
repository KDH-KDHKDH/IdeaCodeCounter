package codecounter.counderapp;

import codecounter.counter.CodeLineCounter;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AppPrimaryController {

    @FXML
    private TextField filePathField;

    @FXML
    private TableView<String[]> resultTable;

    @FXML
    private ListView<String> fileListView;

    @FXML
    private Button browseButton;

    @FXML
    private Button startButton;

    @FXML
    private Button clearButton;

    @FXML
    private File selectedFile;

    @FXML
    TableView<String[]> tableView;

    @FXML
    void initialize() {
        int n = 0;
        for (String header : AppConstant.initHeader) {
            TableColumn<String[], String> colTemp = new TableColumn<>(header);
            final int finalN = n;
            colTemp.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[finalN]));
            n++;
            tableView.getColumns().add(colTemp);
        }
    }

    // 点击浏览按钮时打开文件选择对话框
    @FXML
    void onBrowseButtonClick(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("选择文件夹");

        // 设置初始目录（可选）
        File initialDirectory = new File(System.getProperty("user.home"));
        directoryChooser.setInitialDirectory(initialDirectory);

        // 打开文件夹选择对话框
        Stage stage = (Stage) browseButton.getScene().getWindow();
        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
            String fpath = selectedDirectory.getAbsolutePath();
            filePathField.setText(fpath);
            selectedFile = new File(filePathField.getText());
        }
    }

    // 点击开始统计按钮时统计代码
    @FXML
    void onStartButtonClick(ActionEvent event) {
        CSVTableView.clearTable(tableView); // 清空表格
        if (selectedFile != null) {
            CodeLineCounter.init();
            // 统计并显示
            try {
                CodeLineCounter.countFilesLines(selectedFile); // 统计
                CodeLineCounter.outputTable();
                CSVReader.readCSVFile();    // 读取CSV
                if(CSVReader.csvData != null) CSVTableView.updateTable(tableView);  // 更新表格
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    // 点击清空按钮时清空所有输入和结果
    @FXML
    void onClearButtonClick(ActionEvent event) {
        filePathField.clear();
        CSVTableView.clearTable(tableView);
        fileListView.getItems().clear();
        selectedFile = null;
    }
}
