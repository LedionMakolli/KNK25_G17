package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Cars;
import repository.CarRepository;
import services.SceneManager;
import utils.SceneLocator;

public class CarDetailsController extends BaseController{

    @FXML private Label lblId;
    @FXML private Label lblPlate;
    @FXML private Label lblModel;
    @FXML private Label lblColor;
    @FXML private Label lblYear;
    @FXML private Label lblMileage;
    @FXML private Label lblSeats;
    @FXML private Label lblFuel;
    @FXML private Label lblPrice;
    @FXML private Label lblStatus;
    @FXML private Label lblTransmission;
    @FXML private Label lblStatus;
    @FXML private ImageView imgCar;

    private SceneManager sceneManager;

    public void setCar(Cars car) throws Exception {
        lblPlate.setText("Targat: " + car.getLicensePlate());
        lblModel.setText("Model: " + car.getModel());
        lblColor.setText("Ngjyra: " + car.getColor());
        lblYear.setText("Viti i Prodhimit: " + car.getYearOfManufacture());
        lblMileage.setText("Kilometrazha: " + car.getMileage() + " km");
        lblPrice.setText("Çmimi ditor: " + car.getDailyPrice() + "€");
        lblTransmission.setText("Transmisioni: " + car.getTransmissionType());
        lblSeats.setText("Ulëset: " + car.getSeatCount());
        lblFuel.setText("Lloji i karburantit: " + car.getFuelType());
        lblStatus.setText("Statusi: " + car.getStatus());
        Image image = new Image(
                getClass().getResourceAsStream(car.getImagePath())
        );
        imgCar.setImage(image);
    }
    @FXML
    public void backToHomePage(ActionEvent event) throws Exception {
        SceneManager.load(SceneLocator.HOME_PAGE);
    }
}