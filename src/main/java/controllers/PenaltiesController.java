package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Penalties;
import repository.PenaltiesRepository;
import services.SessionManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PenaltiesController extends BaseController {
    @FXML
    private TableView<Penalties> penaltiesTable;

    @FXML
    private TableColumn<Penalties, Integer> idColumn;

    @FXML
    private TableColumn<Penalties, Integer> reservationIdColumn;

    @FXML
    private TableColumn<Penalties, String> reasonColumn;

    @FXML
    private TableColumn<Penalties, BigDecimal> amountColumn;

    @FXML
    private TableColumn<Penalties, LocalDateTime> dateColumn;

    @FXML
    private TableColumn<Penalties, Boolean> paidColumn;

    private PenaltiesRepository penaltiesRepository;

    @FXML
    public void initialize() {
        try {
            this.penaltiesRepository = new PenaltiesRepository();
            super.initialize();
            setupTableColumns();
            loadPenalties();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reasonOfPenalty"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("moneyAmount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        paidColumn.setCellValueFactory(new PropertyValueFactory<>("paid"));
    }

    private void loadPenalties() {
        try {
            List<Penalties> penalties;

            String role = SessionManager.getInstance().getCurrentRole();
            if ("client".equals(role)) {
                int clientId = SessionManager.getInstance().getCurrentClient().getId();
                penalties = penaltiesRepository.getByClientId(clientId);
            } else {
                penalties = penaltiesRepository.getAll();
            }

            ObservableList<Penalties> data = FXCollections.observableArrayList(penalties);
            penaltiesTable.setItems(data);
        } catch (Exception e) {
            showAlertBasedOnLanguage(Alert.AlertType.ERROR,
                    "alert.error",
                    "error.loadPenalties"
            );
        }
    }
}
