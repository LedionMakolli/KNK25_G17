package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Dto.CreateOffersDto;
import services.AddOfferService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddOffersController extends BaseController {

    @FXML private TextField carId;
    @FXML private TextField discount;
    @FXML private DatePicker dpStartDate;
    @FXML private DatePicker dpEndDate;

    private final AddOfferService offerService = new AddOfferService();

    @FXML
    public void initialize() {
        try {
            super.initialize();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSaveClick() {
        if (!inputsValid()) return;

        CreateOffersDto offer = new CreateOffersDto(
                Integer.parseInt(carId.getText()),
                Double.parseDouble(discount.getText()),
                Date.valueOf(dpStartDate.getValue()),
                Date.valueOf(dpEndDate.getValue())
        );

        boolean saved = offerService.createOffer(offer);
        if (saved) {
            showAlertBasedOnLanguage(
                    AlertType.INFORMATION,
                    "alert.success",
                    "offer.added"
            );
        } else {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "offer.exists"
            );
        }
    }

    private boolean inputsValid() {
        String carIdText    = carId.getText();
        String discountText = discount.getText();
        LocalDate startDate = dpStartDate.getValue();
        LocalDate endDate   = dpEndDate.getValue();

        if (carIdText.isEmpty() || discountText.isEmpty()
                || startDate == null || endDate == null) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.fillAllFields"
            );
            return false;
        }

        try {
            Integer.parseInt(carIdText);
        } catch (NumberFormatException e) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.invalidCarId"
            );
            return false;
        }

        try {
            double disc = Double.parseDouble(discountText);
            if (disc <= 0 || disc > 100) {
                showAlertBasedOnLanguage(
                        AlertType.ERROR,
                        "alert.error",
                        "error.invalidDiscountRange"
                );
                return false;
            }
        } catch (NumberFormatException e) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.invalidDiscountNumber"
            );
            return false;
        }

        if (startDate.isBefore(LocalDate.now())) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.startDatePast"
            );
            return false;
        }

        if (!endDate.isAfter(startDate)) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.endBeforeStart"
            );
            return false;
        }

        return true;
    }
}
