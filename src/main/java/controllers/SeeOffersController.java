package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Offers;
import repository.OffersRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class SeeOffersController extends BaseController{

    @FXML private TableView<Offers> tblOffers;
    @FXML private TableColumn<Offers, String> colCarModel;
    @FXML private TableColumn<Offers, Double> colDiscount;
    @FXML private TableColumn<Offers, LocalDate> colStartDate;
    @FXML private TableColumn<Offers, LocalDate> colEndDate;

    private final OffersRepository repo;

    public SeeOffersController() {
        try {
            this.repo = new OffersRepository();
        } catch (SQLException e) {
            throw new RuntimeException("Could not initialize OffersRepository", e);
        }
    }

    @FXML
    public void initialize() throws SQLException {
        super.initialize();
        colCarModel.setCellValueFactory(new PropertyValueFactory<>("carId"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));


        LocalDate today = LocalDate.now();
        List<Offers> active = repo.getAll().stream()
                .filter(o -> {
                    LocalDate s = o.getStartDate().toLocalDate();
                    LocalDate e = o.getEndDate().toLocalDate();
                    return (! today.isBefore(s)) && (! today.isAfter(e));
                })
                .collect(Collectors.toList());

        tblOffers.setItems(FXCollections.observableArrayList(active));
    }

}
