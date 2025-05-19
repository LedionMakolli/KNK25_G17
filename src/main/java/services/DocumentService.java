package services;

import models.Documents;
import repository.DocumentsRepository;

import java.sql.SQLException;
import java.util.List;

public class DocumentService {
    private DocumentsRepository documentsRepository;

    public DocumentService() {
        try {
            this.documentsRepository = new DocumentsRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Documents> getAllDocuments(){
        return this.documentsRepository.getAll();
    }
}
