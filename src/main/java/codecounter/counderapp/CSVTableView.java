package codecounter.counderapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class CSVTableView {
    static ArrayList<TableColumn<String[], String>>  ColList;
    static TableView<String[]> tableView;

    static void initTable() {
        int n=0;
        for(String header : AppConstant.initHeader) {
            TableColumn<String[], String> colTemp = new TableColumn<>(header);
            final int finalN = n;
            colTemp.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[finalN]));
            n++;
            tableView.getColumns().add(colTemp);
        }
    }

    protected static void updateTable() {
        tableView.getItems().clear();
        tableView.getItems().addAll(CSVReader.csvData);
    }

    protected static void clearTable() {
        tableView.getItems().clear();
    }
}
