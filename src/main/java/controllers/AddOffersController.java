package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Dto.CreateOffersDto;
import services.AddOfferService;

import java.sql.Date;
import java.time.LocalDate;

public class AddOffersController extends BaseController {

    @FXML private TextField carId;
    @FXML private TextField discount;
    @FXML private DatePicker dpStartDate;
    @FXML private DatePicker dpEndDate;

    private final AddOfferService offerService = new AddOfferService();

    @FXML
    public void initialize() {
        dpStartDate.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()));
            }
        });

        dpStartDate.valueProperty().addListener((obs, vjetra, reja) -> {
            if (reja != null) {
                dpEndDate.setValue(reja.plusDays(1));
            }
        });
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
            showMessage("Sukses", "Oferta u shtua me sukses!");
            clearFields();
        } else {
            showMessage("Gabim", "Oferta nuk u shtua. Ka mundësi që makina ka ofertë ekzistuese.");
        }
    }

    private boolean inputsValid() {
        String carIdText = carId.getText();
        String discountText = discount.getText();
        LocalDate startDate = dpStartDate.getValue();
        LocalDate endDate = dpEndDate.getValue();

        if (carIdText.isEmpty() || discountText.isEmpty() || startDate == null || endDate == null) {
            showMessage("Gabim", "Ju lutem plotësoni të gjitha fushat.");
            return false;
        }

        try {
            Integer.parseInt(carIdText);
        } catch (NumberFormatException e) {
            showMessage("Gabim", "ID e makinës duhet të jetë numër.");
            return false;
        }

        try {
            double discount = Double.parseDouble(discountText);
            if (discount <= 0 || discount > 100) {
                showMessage("Gabim", "Zbritja duhet të jetë midis 0 dhe 100.");
                return false;
            }
        } catch (NumberFormatException e) {
            showMessage("Gabim", "Zbritja duhet të jetë numër valid.");
            return false;
        }

        if (endDate.isBefore(startDate)) {
            showMessage("Gabim", "Data e mbarimit duhet të jetë pas datës së fillimit.");
            return false;
        }

        return true;
    }

    @FXML
    private void handleCancelClick() {
        clearFields();
    }

    private void clearFields() {
        carId.clear();
        discount.clear();
        dpStartDate.setValue(null);
        dpEndDate.setValue(null);
    }

    private void showMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
