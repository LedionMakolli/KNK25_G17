package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import models.Dto.CreateReservationsDto;
import models.Dto.CreateSpecialRequestsDto;
import models.Reservations;
import models.SpecialRequests;
import models.enums.ReservationStatusEnum;
import repository.ReservationsRepository;
import repository.SpecialRequestsRepository;
import services.SceneManager;
import utils.SceneLocator;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationFormController extends BaseController{

    @FXML private DatePicker dpStartDate;
    @FXML private DatePicker dpEndDate;
    @FXML private TextArea txtSpecialRequests;
    @FXML private Button btnSubmit;
    @FXML private Button btnCancel;

    private int clientId;
    private int carId;
    public ReservationFormController() throws SQLException {
        super.initialize();
    }


    public void setContext(int clientId, int carId) {
        this.clientId = clientId;
        this.carId    = carId;
    }


    @FXML
    private void onSubmit(ActionEvent event) {
        if (dpStartDate.getValue() == null || dpEndDate.getValue() == null) {
            showAlert(Alert.AlertType.WARNING, "Warning", "Please select start and end dates.");
            return;
        }

        LocalDate chosenStart = dpStartDate.getValue();
        LocalDate chosenEnd = dpEndDate.getValue();
        LocalDate today = LocalDate.now();

        if (chosenStart.isBefore(today) || chosenEnd.isBefore(today)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Dates", "You cannot reserve for dates earlier than today.");
            return;
        }

        if (!chosenStart.isBefore(chosenEnd)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Range", "Start date must be before end date.");
            return;
        }




        try {
            Date start = Date.valueOf(dpStartDate.getValue());
            Date end   = Date.valueOf(dpEndDate.getValue());
            String specialRequest = txtSpecialRequests.getText().trim();


            ReservationsRepository repo = new ReservationsRepository();
            if (repo.existsOverlap(carId, start, end)) {
                showAlert(Alert.AlertType.ERROR, "Error",
                        "This car is already reserved for the selected dates.");
                return;
            }


            CreateReservationsDto dto = new CreateReservationsDto(
                    clientId,
                    carId,
                    start,
                    end,
                    ReservationStatusEnum.ACTIVE,
                    today
            );
            Reservations reservation = repo.create(dto);


            if (reservation == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to create reservation");
                return;
            }

            if (!specialRequest.isEmpty()) {
                SpecialRequestsRepository srRepo = new SpecialRequestsRepository();
                CreateSpecialRequestsDto srDto = new CreateSpecialRequestsDto(
                        reservation.getId(), specialRequest, false
                );
                if (srRepo.create(srDto) == null) {
                    showAlert(Alert.AlertType.WARNING, "Warning", "Reservation created but special request not saved.");
                }
            }

            showAlert(Alert.AlertType.INFORMATION, "Success", "Reservation #" + reservation.getId() + " created successfully!");

            SceneManager.load(SceneLocator.HOME_PAGE);

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to create reservation: " + e.getMessage()
            );
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
