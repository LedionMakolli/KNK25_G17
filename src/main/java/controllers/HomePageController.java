package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Cars;
import repository.CarRepository;
import services.CarService;
import services.CarService2;
import services.SceneManager;
import utils.SceneLocator;

import java.io.IOException;

public class HomePageController extends BaseController{

    @FXML private Button btnViewDetailsE36;
    @FXML private Button btnViewDetailsM3;
    @FXML private Button btnViewDetailsX5;
    @FXML private Button btnViewDetailsGolf8;
    @FXML private Button btnViewDetailsS60;
    @FXML private Button btnViewDetailsCClass;

    private final CarService carService;
    private final CarRepository carRepository;

    public HomePageController() throws Exception {
        this.carService=new CarService();
        this.carRepository=new CarRepository();
    }

    @FXML
    private void handleViewDetailsE36(ActionEvent event) throws Exception {
        showCarDetails(1, event);
    }

    @FXML
    private void handleViewDetailsM3(ActionEvent event) throws Exception {
        showCarDetails(2, event);
    }

    @FXML
    private void handleViewDetailsX5(ActionEvent event) throws Exception {
        showCarDetails(3, event);
    }

    @FXML
    private void handleViewDetailsGolf8(ActionEvent event) throws Exception {
        showCarDetails(4, event);
    }

    @FXML
    private void handleViewDetailsS60(ActionEvent event) throws Exception {
        showCarDetails(5, event);
    }

    @FXML
    private void handleViewDetailsCClass(ActionEvent event) throws Exception {
        showCarDetails(6, event);
    }

    private void showCarDetails(int carId, ActionEvent event) throws Exception {
        Cars car = this.carRepository.getById(carId);

        SceneManager.load(SceneLocator.RESERVATION_FORM);;
    }
}
