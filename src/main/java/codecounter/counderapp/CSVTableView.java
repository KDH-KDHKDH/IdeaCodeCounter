package codecounter.counderapp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        tableView.getItems().addAll(CSVReader.data);
    }

    protected static void clearTable() {
        tableView.getItems().clear();
    }
}
