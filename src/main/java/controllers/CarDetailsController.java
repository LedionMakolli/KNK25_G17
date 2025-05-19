package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Cars;
import repository.CarRepository;
import services.CarDetailsSerivce;
import services.LanguageManager;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    @FXML private Button btnReserveNow;

    @FXML private ImageView imgCar;

    private SceneManager sceneManager;
    private Cars currentCar;
    private CarDetailsSerivce carDetailsSerivce;
    private BigDecimal carPrice;
    private BigDecimal RealCarPrice;

    public CarDetailsController() throws SQLException {
        super.initialize();
        this.carDetailsSerivce = new CarDetailsSerivce();
    }

    @FXML
    public void initialize() {

        if (SessionManager.getInstance().isStaff()) {
            btnReserveNow.setDisable(true);
            btnReserveNow.setTooltip(new Tooltip("Only clients can make reservation"));
        }

        Cars selected = SessionManager.getInstance().getSelectedCar();
        if (selected != null) {
            try {
                setCar(selected);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void setCar(Cars car) throws Exception {
        this.currentCar = car;
        lblPlates.setText("Plates: " + car.getLicensePlate());
        lblModel.setText("Model: " + car.getModel());
        lblColor.setText("Color: " + car.getColor());
        lblYear.setText("Year: " + car.getYearOfManufacture());
        lblMileage.setText("Mileage: " + car.getMileage() + " km");
        lblSeats.setText("Seats: " + car.getSeatCount());
        lblFuel.setText("Fuel: " + car.getFuelType());
        carPrice = carDetailsSerivce.getDailyPrice(car);
        RealCarPrice = BigDecimal.valueOf(car.getDailyPrice());
        lblPriceDay.setText("Price/Day: " + carPrice + "€");
        lblStatus.setText("Status: " + car.getStatus());
        lblTransmissionType.setText("Transmission Type: " + car.getTransmissionType());
        Image image = new Image(
                getClass().getResourceAsStream(car.getImagePath())
        );
        imgCar.setImage(image);
        this.PopupSale();
    }
    @FXML
    public void goToHomepage(ActionEvent event) throws Exception {
        SceneManager.load(SceneLocator.HOME_PAGE);
    }

    @FXML
    private void onReserveNow(ActionEvent event) {
        try {
            var formCtrl = SceneManager
                    .<ReservationFormController>loadWithController(SceneLocator.RESERVATION_FORM);


            int clientId = SessionManager.getInstance()
                    .getCurrentClient()
                    .getId();


            formCtrl.setContext(clientId, this.currentCar.getId());

        } catch(Exception ex) {
            ex.printStackTrace();
            showErrorAlert("…", "…");
        }
    }

    private void setupReserveButton() {
        SessionManager sessionManager = SessionManager.getInstance();
        ResourceBundle rb = LanguageManager.getInstance().getResourceBundle();

        if (sessionManager.isClient()) {
            btnReserveNow.setDisable(false);
            btnReserveNow.setVisible(true);
        } else if (sessionManager.isStaff()) {
            btnReserveNow.setDisable(true);
            btnReserveNow.setVisible(false);
            btnReserveNow.setTooltip(new Tooltip(rb.getString("tooltip.staffCannotReserve")));
        } else {
            btnReserveNow.setDisable(true);
            btnReserveNow.setTooltip(new Tooltip("Please log in as a client to reserve"));
        }
    }

    private void PopupSale(){
        if (carPrice.compareTo(RealCarPrice) < 0 ) {
            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Zbritje në këtë veturë!",
                    "Makina është në ofertë." +
                            " Çmimi me zbritje është " + carPrice + "€ %txt.carSaleDetailForm " + RealCarPrice + "€!"
            );
        }
    }

}