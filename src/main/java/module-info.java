module codecounter.codecounder {
    requires javafx.controls;
    requires javafx.fxml;
    //requires java.desktop;
    //requires com.opencsv;

    opens codecounter.counderapp to javafx.fxml;

    exports codecounter.counderapp;
}

