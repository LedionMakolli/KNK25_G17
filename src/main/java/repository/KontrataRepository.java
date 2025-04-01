package repository;

import database.DBConnection;
import models.Dto.*;
import models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public Kontrata update(UpdateKontrataDto KontrataDto){
        StringBuilder query = new StringBuilder("UPDATE KONTRATA SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (KontrataDto.getShuma() > 0){
            query.append("shuma = ?, ");
            parametrat.add(KontrataDto.getShuma());
            hasUpdate = true;
        }
        if (KontrataDto.getPagesa() != null){
            query.append("pagesa = ?, ");
            parametrat.add(KontrataDto.getPagesa());
            hasUpdate = true;
        }

        if (!hasUpdate){
            return getById(KontrataDto.getId_kontrata());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id_kontrata = ?");
        parametrat.add(KontrataDto.getId_kontrata());

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query.toString());
            for (int i = 0; i<parametrat.size(); i++){
                pstm.setObject(i+1,parametrat.get(i));
            }
            pstm.execute();
            return getById(KontrataDto.getId_kontrata());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


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
