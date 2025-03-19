module com.example.projket_knk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projket_knk to javafx.fxml;
    exports com.example.projket_knk;
}