package repository;

import database.DBConnection;
import models.Dto.*;
import models.*;


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
                kontrata.add(Kontrata.getInstance(resultSet));
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
                return Kontrata.getInstance(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    // metoda create

    public Kontrata create(CreateKontrataDto KontrataDto){
        String query = " INSERT INTO KONTRATA ";

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setDouble(1,KontrataDto.getShuma());
            pstm.setObject(2,KontrataDto.getPagesa(), Types.OTHER);
            pstm.execute();
            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda update



    // metoda delete

    public boolean delete(int id_kontrata){
        String query = "DELETE FROM KONTRATA WHERE id_kontrata = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1,id_kontrata);

            return pstm.executeUpdate() == 1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
