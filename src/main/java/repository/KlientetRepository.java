package repository;

import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< Updated upstream
import models.Klientet;

=======
import models.Dto.CreateKlientetDto;
import models.Dto.UpdateKlientetDto;
import models.Klientet;
>>>>>>> Stashed changes

public class KlientetRepository {
    private Connection connection;

    public KlientetRepository() {
        this.connection= DBConnection.getConnection();
    }
    // definimi i 5 metodave: getAll, getById, create, update, delete
    public ArrayList<Klientet> getAll() {
        ArrayList<Klientet> klientet=new ArrayList<>();
        String query= "SELECT * FROM KLIENTET";
        try {
            Statement statement=this.connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()) {
                klientet.add(Klientet.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return klientet;
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
