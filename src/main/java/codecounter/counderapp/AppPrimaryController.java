package codecounter.counderapp;

import codecounter.counter.CodeLineCounter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AppPrimaryController {

    @FXML
    private TextField filePathField;

    @FXML
    private TextArea resultArea;

    @FXML
    private ListView<String> fileListView;

    @FXML
    private Button browseButton;

    @FXML
    private Button startButton;

    @FXML
    private Button clearButton;

    private File selectedFile;

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
        }
    }

    // 点击开始统计按钮时统计代码
    @FXML
    void onStartButtonClick(ActionEvent event) {
        if (selectedFile != null) {
            CodeLineCounter.init();
            // 统计并显示
            try {
                CodeLineCounter.countFilesLines(new File(filePathField.getText()));
                //显示

            } catch (IOException e) {
                resultArea.setText("无法读取文件内容: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            resultArea.setText("请选择一个文件！");
        }
    }

    // 点击清空按钮时清空所有输入和结果
    @FXML
    void onClearButtonClick(ActionEvent event) {
        filePathField.clear();
        resultArea.clear();
        fileListView.getItems().clear();
        selectedFile = null;
    }
}
