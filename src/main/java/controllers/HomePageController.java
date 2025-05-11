package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import models.Cars;
import services.SceneManager;
import utils.SceneLocator;

import java.io.IOException;

public class HomePageController {

//    private javafx.scene.control.ScrollPane scrollPane;

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
    private void handleViewDetailsE36(ActionEvent e) {
        Cars c = carService.findById( /* the  E36’s ID */ );
        openReservationForm(c);
    }

    @FXML
    private void handleViewDetailsM3(ActionEvent event) {
        handleViewDetails("BMW M3", "2018");
    }

    @FXML
    private void handleViewDetailsX5(ActionEvent event) {
        handleViewDetails("BMW X5", "2023");
    }

    @FXML
    private void handleViewDetailsGolf8(ActionEvent event) {
        handleViewDetails("Golf 8", "2020");
    }

    @FXML
    private void handleViewDetailsS60(ActionEvent event) {
        handleViewDetails("Volvo S60", "2023");
    }

    @FXML
    private void handleViewDetailsCClass(ActionEvent event) {
        handleViewDetails("Mercedes C-Class", "2020");
    }

    private void openReservationForm(Cars car) {
        try {
            SceneManager.load(SceneLocator.RESERVATION_FORM);

            // now hand over the Car instance
//            ctrl.setCar(car);

        } catch(Exception ex) {
            ex.printStackTrace();
            // show error…
        }
    }

}
