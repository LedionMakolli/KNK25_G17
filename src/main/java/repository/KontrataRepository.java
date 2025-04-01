package repository;

import database.DBConnection;
import models.Kontrata;

import java.sql.*;
import java.util.ArrayList;

public class KontrataRepository {
    private Connection connection;

    public KontrataRepository() throws SQLException{
        this.connection = DBConnection.getConnection();
        if (connection.isValid(1000)) {
            System.out.println("DB Connected");
        }
    }

    // metoda getAll

    public ArrayList<Kontrata> getAll(){
        ArrayList<Kontrata> kontrata = new ArrayList<>();
        String query = "SELECT * FROM KONTRATA";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                kontrata.add(Kontrata.getInstace(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return kontrata;
    }

    // metoda getById

    public Kontrata getById(int kontarta_id) {
        String query = "SELECT * FROM KONTRATA WHERE id_kontrata = ?";
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1,kontarta_id);
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()){
                return Kontrata.getInstace(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
