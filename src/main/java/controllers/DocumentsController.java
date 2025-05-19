package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Documents;
import repository.DocumentsRepository;
import services.DocumentService;

import java.util.Date;
import java.util.List;

public class DocumentsController extends BaseController {

    @FXML private TableView<Documents> documentsTable;
    @FXML private TableColumn<Documents, Integer> idColumn;
    @FXML private TableColumn<Documents, Integer> contractIdColumn;
    @FXML private TableColumn<Documents, String> typeColumn;
    @FXML private TableColumn<Documents, String> pathColumn;
    @FXML private TableColumn<Documents, Date> uploadDateColumn;

    private final DocumentService documentService;

    public DocumentsController() {
        try {
            this.documentService = new DocumentService();
            super.initialize();
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.initDocumentsRepo");
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {
        try {
            super.initialize();
            setupTableColumns();
            refreshDocuments();
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.initDocumentsView");
        }
    }

    private void setupTableColumns() {
        try {
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            contractIdColumn.setCellValueFactory(new PropertyValueFactory<>("idContract"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            pathColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
            uploadDateColumn.setCellValueFactory(new PropertyValueFactory<>("dataUpload"));
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.columnSetup");
        }
    }

    @FXML
    private void refreshDocuments() {
        try {
            List<Documents> documents = documentService.getAllDocuments();
            documentsTable.getItems().setAll(documents);
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.loadDocuments");
        }
    }
}
