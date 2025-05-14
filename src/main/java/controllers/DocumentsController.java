package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Documents;
import repository.DocumentsRepository;

import java.util.Date;
import java.util.List;

public class DocumentsController extends BaseController {

    @FXML
    private TableView<Documents> documentsTable;
    @FXML
    private TableColumn<Documents, Integer> idColumn;
    @FXML
    private TableColumn<Documents, Integer> contractIdColumn;
    @FXML
    private TableColumn<Documents, String> typeColumn;
    @FXML
    private TableColumn<Documents, String> pathColumn;
    @FXML
    private TableColumn<Documents, Date> uploadDateColumn;

    private final DocumentsRepository documentsRepository;

    public DocumentsController() {
        try {
            this.documentsRepository = new DocumentsRepository();
        } catch (Exception e) {
            showErrorAlert("Initialization Error", "Failed to initialize Documents repository: " + e.getMessage());
            throw new RuntimeException("Failed to initialize DocumentsRepository", e);
        }
    }

    @FXML
    public void initialize() {
        try {
            super.initialize();
            setupTableColumns();
            refreshDocuments();
        } catch (Exception e) {
            showErrorAlert("Initialization Error", "Failed to initialize Documents view: " + e.getMessage());
            e.printStackTrace();
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
            showErrorAlert("Column Setup Error", "Failed to setup table columns: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshDocuments() {
        try {
            List<Documents> documents = documentsRepository.getAll();
            documentsTable.getItems().setAll(documents);
        } catch (Exception e) {
            showErrorAlert("Load Error", "Failed to load documents: " + e.getMessage());
            e.printStackTrace();
        }
    }
}