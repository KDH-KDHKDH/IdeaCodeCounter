package codecounter.CSVRead;
import codecounter.counderapp.AppConstant;
import javafx.scene.control.TableView;

public class CSVTableView {
    public static void updateTable(TableView<String[]> tableView) {
        if(!tableView.getItems().isEmpty()) tableView.getItems().clear();
        tableView.getItems().addAll(CSVReader.csvData);
    }

    public static void clearTable(TableView<String[]> tableView) {
        tableView.getItems().clear();
    }
}
