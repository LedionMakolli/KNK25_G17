package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Cars;
import models.Dto.CreateReviewsDto;
import services.CarService;
import services.ReviewsService;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddReviewController extends BaseController{

    @FXML private ComboBox<String> cmbCar;
    @FXML private ChoiceBox<Integer> choiceRating;
    @FXML private TextArea txtReview;
    @FXML private Button btnSubmitReview;
    @FXML private Button btnCancelReview;

    private final ReviewsService reviewsService;
    private Map<String, Cars> modelToCarMap = new HashMap<>();

    public AddReviewController() {
        try {
            this.reviewsService = new ReviewsService();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to initialize ReviewsRepository", e);
        }
    }

    @FXML
    public void initialize() throws SQLException{
        super.initialize();
        List<Cars> allCars = new CarService().getAllCars();
        ObservableList<String> carModels = FXCollections.observableArrayList();
        for (Cars car : allCars) {
            modelToCarMap.put(car.getModel(), car);
            carModels.add(car.getModel());
        }
        cmbCar.setItems(carModels);
        choiceRating.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    }

    @FXML
    private void onSubmitReview(ActionEvent event) {
        String selectedModel = cmbCar.getValue();
        Cars selectedCar = modelToCarMap.get(selectedModel);
        Integer rating = choiceRating.getValue();
        String text = txtReview.getText();


        if (selectedCar == null || rating == null || text == null || text.isBlank()) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.WARNING,
                    "warning.reviewFields.header",
                    "warning.reviewFields.content"
            );
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
            if (reviewsService.createReivew(dto) != null) {
                showAlertBasedOnLanguage(
                        Alert.AlertType.INFORMATION,
                        "info.reviewSubmitted.header",
                        "info.reviewSubmitted.content"
                );
                SceneManager.load(SceneLocator.HOME_PAGE);
            } else {
                showAlertBasedOnLanguage(
                        Alert.AlertType.ERROR,
                        "error.reviewSaveFail.header",
                        "error.reviewSaveFail.content"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.saveReviewException.header",
                    "error.saveReviewException.content"
            );
        }
    }

    @FXML
    private void onCancelReview(ActionEvent event) {
        try {
            SceneManager.load(SceneLocator.HOME_PAGE);
        } catch (Exception ignored) {}
    }
}
