module com.example.projket_knk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens com.example.projket_knk to javafx.fxml;
    opens app to javafx.fxml;
    opens controllers to javafx.fxml;
    opens testim to javafx.fxml;

    opens models to javafx.base;

    exports com.example.projket_knk;
    exports app;
    exports controllers;
    exports testim;
    exports models;
}