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
import services.SessionManager;
import utils.SceneLocator;

public class CarDetailsController extends BaseController{

    @FXML private Label lblPlates;
    @FXML private Label lblModel;
    @FXML private Label lblColor;
    @FXML private Label lblYear;
    @FXML private Label lblMileage;
    @FXML private Label lblSeats;
    @FXML private Label lblFuel;
    @FXML private Label lblPriceDay;
    @FXML private Label lblStatus;
    @FXML private Label lblTransmissionType;

    @FXML private ImageView imgCar;

    private SceneManager sceneManager;
    private Cars currentCar;


    public void setCar(Cars car) throws Exception {
        this.currentCar = car;
        lblPlates.setText("Targat: " + car.getLicensePlate());
        lblModel.setText("Model: " + car.getModel());
        lblColor.setText("Ngjyra: " + car.getColor());
        lblYear.setText("Viti i Prodhimit: " + car.getYearOfManufacture());
        lblMileage.setText("Kilometrazha: " + car.getMileage() + " km");
        lblSeats.setText("Ulëset: " + car.getSeatCount());
        lblFuel.setText("Lloji i karburantit: " + car.getFuelType());
        lblPriceDay.setText("Çmimi ditor: " + car.getDailyPrice() + "€");
        lblStatus.setText("Statusi: " + car.getStatus());
        lblTransmissionType.setText("Transmisioni: " + car.getTransmissionType());
        Image image = new Image(
                getClass().getResourceAsStream(car.getImagePath())
        );
        imgCar.setImage(image);
    }
    @FXML
    public void goToHomepage(ActionEvent event) throws Exception {
        SceneManager.load(SceneLocator.HOME_PAGE);
    }

    @FXML
    private void onReserveNow(ActionEvent event) {
        try {
            // load the reservation form and get its controller...
            var formCtrl = SceneManager
                    .<ReservationFormController>loadWithController(SceneLocator.RESERVATION_FORM);

            // grab the currently logged-in client ID from SessionManager:
            int clientId = SessionManager.getInstance()
                    .getCurrentClient()
                    .getId();

            // and the car ID you already have:
            formCtrl.setContext(clientId, this.currentCar.getId());

        } catch(Exception ex) {
            ex.printStackTrace();
            showErrorAlert("…", "…");
        }
    }


}