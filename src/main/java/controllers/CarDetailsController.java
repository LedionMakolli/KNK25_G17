package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Cars;
import repository.CarRepository;
import services.SceneManager;
import utils.SceneLocator;

public class CarDetailsController {

    @FXML private Button btnBack;
    @FXML private Label lblID;
    @FXML private Label lblLicensePlate;
    @FXML private Label lblModel;
    @FXML private Label lblColor;
    @FXML private Label lblYear;
    @FXML private Label lblMileage;
    @FXML private Label lblSeats;
    @FXML private Label lblFuel;
    @FXML private Label lblPrice;
    @FXML private Label lblStatus;
    @FXML private Label lblTransmission;
    private SceneManager sceneManager;

    public CarDetailsController() {
        sceneManager=SceneManager.getInstance();
    }

    public void setCar(Cars car) throws Exception {
        lblID.setText("ID: " + car.getId());
        lblLicensePlate.setText("Targat: " + car.getLicensePlate());
        lblModel.setText("Model: " + car.getModel());
        lblColor.setText("Ngjyra: " + car.getColor());
        lblYear.setText("Viti i Prodhimit: " + car.getYearOfManufacture());
        lblMileage.setText("Kilometrazha: " + car.getMileage() + " km");
        lblSeats.setText("Ulëset: " + car.getSeatCount());
        lblFuel.setText("Lloji i karburantit: " + car.getFuelType());
        lblPrice.setText("Çmimi ditor: " + car.getDailyPrice() + "€");
        lblStatus.setText("Statusi: " + car.getStatus());
        lblTransmission.setText("Transmisioni: " + car.getTransmissionType());
    }
    @FXML
    public void backToHomePage(ActionEvent event) throws Exception {
        SceneManager.load(SceneLocator.HOME_PAGE);
    }
}