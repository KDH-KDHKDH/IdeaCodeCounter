package codecounter.counderapp;
import javafx.scene.control.TableView;

public class CSVTableView {
    protected static void updateTable(TableView<String[]> tableView) {
        if(!tableView.getItems().isEmpty()) tableView.getItems().clear();
        tableView.getItems().addAll(CSVReader.csvData);
    }

    protected static void clearTable(TableView<String[]> tableView) {
        tableView.getItems().clear();
    }
}
