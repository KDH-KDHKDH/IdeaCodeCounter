package codecounter.counderapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class CSVTableView extends Application {


    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        TableView<String[]> tableView = new TableView<>();

        // 创建列
        TableColumn<String[], String> col1 = new TableColumn<>("Column 1");
        col1.setCellValueFactory(new PropertyValueFactory<>("Column1"));
        tableView.getColumns().add(col1);

        // 根据CSV的列数添加更多的列...

        // 打开文件选择器
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            List<String[]> csvData = CSVReader.readCSVFile(selectedFile.getAbsolutePath());
            tableView.getItems().addAll(csvData);
        }

        root.getChildren().add(tableView);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("CSV Table View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
