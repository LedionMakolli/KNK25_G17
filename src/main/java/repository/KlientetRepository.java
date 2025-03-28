package repository;

import database.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;


public class KlientetRepository {
    private Connection connection;

    public KlientetRepository() {
        this.connection= DBConnection.getConnection();
    }
    // definimi i 5 metodave: getAll, getById, create, update, delete

}
