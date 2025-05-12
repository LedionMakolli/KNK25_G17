package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import models.Dto.CreateReservationsDto;
import models.Reservations;
import models.enums.ReservationStatusEnum;
import repository.ReservationsRepository;
import services.SceneManager;
import utils.SceneLocator;

import java.sql.Date;

public class ReservationFormController extends BaseController{

    @FXML private DatePicker dpStartDate;
    @FXML private DatePicker dpEndDate;
    @FXML private TextArea txtSpecialRequests;
    @FXML private Button btnSubmit;
    @FXML private Button btnCancel;

    private int clientId;
    private int carId;


    public void setContext(int clientId, int carId) {
        this.clientId = clientId;
        this.carId    = carId;
    }


    @FXML
    private void onSubmit(ActionEvent event) {
        if (dpStartDate.getValue() == null || dpEndDate.getValue() == null) {
            new Alert(Alert.AlertType.WARNING, "Please select start and end dates.").showAndWait();
            return;
        }

        try {
            CreateReservationsDto dto = new CreateReservationsDto(
                    clientId,
                    carId,
                    Date.valueOf(dpStartDate.getValue()),
                    Date.valueOf(dpEndDate.getValue()),
                    ReservationStatusEnum.ACTIVE
            );

            ReservationsRepository repo = new ReservationsRepository();
            Reservations reservation = repo.create(dto);

            if (reservation != null) {
                new Alert(Alert.AlertType.INFORMATION,
                        "Reservation confirmed! ID: " + reservation.getId()
                ).showAndWait();
                SceneManager.load(SceneLocator.HOME_PAGE);
            } else {
                new Alert(Alert.AlertType.ERROR,
                        "Failed to create reservation. Please try again."
                ).showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,
                    "Error creating reservation: " + e.getMessage()
            ).showAndWait();
        }
    }


    @FXML
    private void onCancel(ActionEvent event) {
        try {
            SceneManager.load(SceneLocator.HOME_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
