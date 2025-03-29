package repository;

import database.DBConnection;
import models.*;
import models.Dto.*;
import java.sql.*;
import java.util.ArrayList;

public class VeturatRepository {
    private Connection connection;

    public VeturatRepository() throws SQLException {
        this.connection= DBConnection.getConnection();
        if(connection.isValid(1000)) {
            System.out.println("Lidhja me bazen e te dhenave eshte krijuar me sukes");
        }
    }
    // 1. metoda getAll
    public ArrayList<Veturat> getAll() {
        ArrayList<Veturat> veturat=new ArrayList<>();
        String query="SELECT * FROM VETURAT";
        try {
            Statement statement=this.connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()) {
                veturat.add(Veturat.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veturat;
    }
    // 2. metoda getById
    public Veturat getById(int vetura_id) {
        String query="SELECT * FROM VETURAT WHERE id_vetura=?";
        try {
            PreparedStatement pstm=connection.prepareStatement(query);
            pstm.setInt(1, vetura_id);
            ResultSet resultSet=pstm.executeQuery();
            if(resultSet.next()) {
                return Veturat.getInstance(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 3. metoda create
    public Veturat create(CreateVeturatDto veturatDto) {
        String query= """
                INSERT INTO VETURAT (TARGAT, MODELI, NGJYRA, VITI_PRODHIMIT,
                KILOMETRAZHA, KAPACITETI, KARBURANTI, CMIMI_DITOR, STATUSI)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, veturatDto.getTargat());
            pstm.setString(2, veturatDto.getModeli());
            pstm.setString(3, veturatDto.getNgjyra());
            pstm.setInt(4, veturatDto.getVitiProdhimit());
            pstm.setBigDecimal(5, veturatDto.getKilometrazha());
            pstm.setInt(6, veturatDto.getKapaciteti());
            pstm.setObject(7, veturatDto.getKarburanti(), Types.OTHER);            pstm.setInt(8, veturatDto.getCmimiDitor());
            pstm.setObject(9, veturatDto.getStatusi().name(), Types.OTHER);
            pstm.execute();
            ResultSet result=pstm.getGeneratedKeys();
            if(result.next()) {
                int id=result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 4. metoda update
//    public Veturat update(UpdateVeturatDto veturatDto) {
//        String query= """
//                update users
//                set email=?
//                where id=?
//                """;
//    } qysh me mundesu me ndryshu prej atyne qe mujn mu ndryshu veq ata qe don perdoruesi
    // 5. metoda delete
    public boolean delete(int id_vetura) {
        String query="DELETE FROM VETURAT WHERE id_vetura=?";
        try {
            PreparedStatement pstm=connection.prepareStatement(query);
            pstm.setInt(1, id_vetura);
            return pstm.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
