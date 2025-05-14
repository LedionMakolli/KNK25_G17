package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Penalties;
import repository.PenaltiesRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
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
            List<Penalties> penalties = penaltiesRepository.getAll();
            ObservableList<Penalties> data = FXCollections.observableArrayList(penalties);
            penaltiesTable.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}