package controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Cars;
import models.Dto.CreateReviewsDto;
import repository.ReviewsRepository;
import services.CarService;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewController extends BaseController{

    @FXML private ComboBox<Cars>     cmbCar;
    @FXML private ChoiceBox<Integer> choiceRating;
    @FXML private TextArea           txtReview;
    @FXML private Button             btnSubmitReview;
    @FXML private Button             btnCancelReview;

    private final ReviewsRepository repo;

    public ReviewController() {
        try {
            this.repo = new ReviewsRepository();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to initialize ReviewsRepository", e);
        }
    }

    @FXML
    public void initialize() {
        List<Cars> cars = new CarService().getAllCars();
        cmbCar.setItems(FXCollections.observableArrayList(cars));

        cmbCar.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Cars car, boolean empty) {
                super.updateItem(car, empty);
                setText(empty || car == null ? null : car.getModel());
            }
        });

        // e rregullon qe me dal modeli pasi te selektohet
        cmbCar.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Cars car, boolean empty) {
                super.updateItem(car, empty);
                setText(empty || car == null ? null : car.getModel());
            }
        });

        choiceRating.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    }

    @FXML
    private void onSubmitReview(ActionEvent event) {
        Cars selectedCar = cmbCar.getValue();
        Integer rating   = choiceRating.getValue();
        String  text     = txtReview.getText();


        if (selectedCar == null || rating == null || text == null || text.isBlank()) {
            new Alert(Alert.AlertType.WARNING,
                    "Please select a car, a rating, and enter your review text.")
                    .showAndWait();
            return;
        }


        CreateReviewsDto dto = new CreateReviewsDto(
                SessionManager.getInstance().getCurrentClient().getId(),
                selectedCar.getId(),
                rating,
                text,
                Timestamp.valueOf(LocalDateTime.now())
        );


        try {
            if (repo.create(dto) != null) {
                new Alert(Alert.AlertType.INFORMATION,
                        "Thank you! Your review has been submitted.")
                        .showAndWait();
                SceneManager.load(SceneLocator.HOME_PAGE);
            } else {
                new Alert(Alert.AlertType.ERROR,
                        "Failed to save your review. Please try again.")
                        .showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,
                    "Error saving review: " + e.getMessage())
                    .showAndWait();
        }
    }

    @FXML
    private void onCancelReview(ActionEvent event) {
        try {
            SceneManager.load(SceneLocator.HOME_PAGE);
        } catch (Exception ignored) {}
    }
}
