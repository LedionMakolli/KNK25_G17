package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import models.Cars;
import repository.CarRepository;
import services.CarService;
import services.CarService2;
import services.LanguageManager;
import services.SceneManager;
import utils.SceneLocator;

import java.io.IOException;
import java.util.Locale;

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

    public void showCarDetails(int carId, ActionEvent event) throws Exception {
        Cars car = this.carRepository.getById(carId);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/car-details.fxml"));
        Parent root = loader.load(); // Kjo inicializon komponentët nga FXML
        CarDetailsController controller = loader.getController(); // Merr kontrolluesin që u inicializua nga FXML

        controller.setCar(car); // Thirr metodën pasi FXML komponentët janë inicializuar

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
