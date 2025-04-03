package repository;

import database.DBConnection;
import models.*;
import models.Dto.*;
import java.sql.*;
import java.util.ArrayList;

public class KlientetRepository {
    private Connection connection;

    public KlientetRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
        if(connection.isValid(1000)) {
            System.out.println("Lidhja me bazen e te dhenave eshte krijuar me sukes");
        }
    }

    // definimi i 5 metodave: getAll, getById, create, update, delete
    // 1. metoda getAll
    public ArrayList<Klientet> getAll() {
        ArrayList<Klientet> klientet = new ArrayList<>();
        String query = "SELECT * FROM KLIENTET";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                klientet.add(Klientet.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return klientet;
    }

    // 2. Metoda getById

    public Klientet getById(int idKlienti) {
        String query="SELECT * FROM KLIENTET WHERE id_klienti=?";
        try {
            PreparedStatement pstm=this.connection.prepareStatement(query);
            pstm.setInt(1, idKlienti);
            ResultSet resultSet=pstm.executeQuery();
            if(resultSet.next()) {
                return Klientet.getInstance(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 3. Metoda Create
    public Klientet create(CreateKlientetDto klientetDto) {
        String query= """
                INSERT INTO KLIENTET (emri, mbiemri, nr_personal, telefoni) 
                values (?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm=this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, klientetDto.getEmri());
            pstm.setString(2, klientetDto.getMbiemri());
            pstm.setString(3, klientetDto.getNrPersonal());
            pstm.setString(4, klientetDto.getNrTelefoni());
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
    // Metoda 4. Update
    public Klientet update(UpdateKlientetDto klientetDto) {
        String query= """
                UPDATE KLIENTET
                SET telefoni=?
                WHERE id_klienti=?
                """;
        try {
            PreparedStatement pstm=this.connection.prepareStatement(query);
            pstm.setString(1, klientetDto.getNrTelefoni());
            pstm.setInt(2, klientetDto.getIdKlienti());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getById(klientetDto.getIdKlienti());
    }

    // Metoda 5. delete Klient
    public boolean delete(int id) {
        String query="DELETE FROM KLIENTET WHERE ID=?";

        try {
            PreparedStatement pstm=this.connection.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}