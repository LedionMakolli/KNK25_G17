package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import models.Cars;
import services.*;
import utils.SceneLocator;

public class HomePageController extends BaseController{

    @FXML private Button btnViewDetailsE36;
    @FXML private Button btnViewDetailsM3;
    @FXML private Button btnViewDetailsX5;
    @FXML private Button btnViewDetailsGolf8;
    @FXML private Button btnViewDetailsS60;
    @FXML private Button btnViewDetailsCClass;

    private final CarService carService;

    public HomePageController() throws Exception {
        this.carService=new CarService();
        super.initialize();
    }

    @FXML
    private void handleCarButtonClick(ActionEvent event) {
        try {
            int carId = Integer.parseInt(
                    ((Button) event.getSource()).getUserData().toString()
            );

            CarDetailsController detailsCtrl =
                    SceneManager.<CarDetailsController>loadWithController(
                            SceneLocator.CAR_DETAILS
                    );

            Cars car = carService.getById(carId);

            SessionManager.getInstance().setSelectedCar(car);

            detailsCtrl.setCar(car);
            detailsCtrl.PopupSale();

        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert(
                    "Unable to load car details",
                    "An error occurred while loading details for car ID " +
                            ((Button) event.getSource()).getUserData()
            );
        }
    }

}

