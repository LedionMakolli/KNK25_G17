package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Documents;
import repository.DocumentsRepository;

import java.sql.SQLException;
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
    private TableColumn<Documents, String> uploadDateColumn;

    private DocumentsRepository documentsRepository;
    public DocumentsController() throws Exception {
        this.documentsRepository=new DocumentsRepository();
    }
    @FXML
    public void initialize() {
        super.initialize();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        contractIdColumn.setCellValueFactory(new PropertyValueFactory<>("idContract"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        pathColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        uploadDateColumn.setCellValueFactory(new PropertyValueFactory<>("dataUpload"));

        loadDocuments();
    }

    private void loadDocuments() {
        try {
            List<Documents> documents = this.documentsRepository.getAll();
            documentsTable.getItems().setAll(documents);
        } catch (Exception e) {
            showErrorAlert("Error loading documents", e.getMessage());
        }
    }
}
