package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import services.SceneManager;
import utils.SceneLocator;

import java.io.IOException;

public class HomePageController {

    @FXML
    private javafx.scene.control.ScrollPane scrollPane;

    @FXML
    private javafx.scene.control.Button btnReserveE36;

    @FXML
    private javafx.scene.control.Button btnReserveM3;

    @FXML
    private javafx.scene.control.Button btnReserveX5;

    @FXML
    private javafx.scene.control.Button btnReserveGolf8;

    @FXML
    private javafx.scene.control.Button btnReserveS60;

    @FXML
    private javafx.scene.control.Button btnReserveCClass;


    @FXML
    private void onReserveE36(ActionEvent event) {
        handleViewDetails("BMW E36 Cabrio", "1995");
    }

    @FXML
    private void onReserveM3(ActionEvent event) {
        handleViewDetails("BMW M3", "2018");
    }

    @FXML
    private void onReserveX5(ActionEvent event) {
        handleViewDetails("BMW X5", "2023");
    }

    @FXML
    private void onReserveGolf8(ActionEvent event) {
        handleViewDetails("Golf 8", "2020");
    }

    @FXML
    private void onReserveVolvo(ActionEvent event) {
        handleViewDetails("Volvo S60", "2023");
    }

    @FXML
    private void onReserveMerC(ActionEvent event) {
        handleViewDetails("Mercedes C-Class", "2020");
    }

    private void handleViewDetails(String modelName, String year) {
        try {
            SceneManager.load(SceneLocator.RESERVATION_FORM);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
