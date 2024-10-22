package codecounter.counderapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("tet.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        initScene();

        stage.setTitle("CodeCounter");
        stage.setScene(scene);
        stage.show();
    }

    private void initScene() {
        CSVTableView.initTable();
    }

    public static void main(String[] args) {
        launch();
    }
}