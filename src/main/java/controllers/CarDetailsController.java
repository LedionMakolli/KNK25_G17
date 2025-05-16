package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Cars;
import repository.CarRepository;
import services.LanguageManager;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

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

    public CarDetailsController() throws SQLException {
        super.initialize();
    }

    @FXML
    public void initialize() throws SQLException {
        super.initialize();

        if(SessionManager.getInstance().isStaff()){
            btnReserveNow.setDisable(true);
            btnReserveNow.setTooltip(new Tooltip("Only clients can make reservation"));
        }
    }

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


}