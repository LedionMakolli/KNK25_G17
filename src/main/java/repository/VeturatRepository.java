package repository;

import database.DBConnection;
import models.*;
import models.Dto.*;
import models.enums.Statusi_Vetura;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class VeturatRepository {
    private Connection connection;

    public VeturatRepository() throws SQLException {
        this.connection= DBConnection.getConnection();
        if(connection.isValid(1000)) {
            System.out.println("DB Connected");
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
                KILOMETRAZHA, NUMRI_ULESEVE, KARBURANTI, CMIMI_DITOR, STATUSI)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, veturatDto.getTargat());
            pstm.setString(2, veturatDto.getModeli());
            pstm.setString(3, veturatDto.getNgjyra());
            pstm.setInt(4, veturatDto.getVitiProdhimit());
            pstm.setBigDecimal(5, veturatDto.getKilometrazha());
            pstm.setInt(6, veturatDto.getNumriUleseve());
            pstm.setObject(7, veturatDto.getKarburanti(), Types.OTHER);
            pstm.setInt(8, veturatDto.getCmimiDitor());
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
    public Veturat update(UpdateVeturatDto VeturatDto) {
        StringBuilder query = new StringBuilder("UPDATE veturat SET ");
        boolean hasUpdates=false;
        List<Object> parametrat = new ArrayList<>();

        if (VeturatDto.getNgjyra() != null) {
            query.append("ngjyra = ?, ");
            parametrat.add(VeturatDto.getNgjyra());
            hasUpdates=true;
        }
        if (VeturatDto.getKilometrazha() != null) {
            query.append("kilometrazha = ?, ");
            parametrat.add(VeturatDto.getKilometrazha());
            hasUpdates=true;
        }
        if (VeturatDto.getCmimiDitor() > 0) {
            query.append("cmimi_ditor = ?, ");
            parametrat.add(VeturatDto.getCmimiDitor());
            hasUpdates=true;
        }
        if (VeturatDto.getStatusi() != null) {
            query.append("statusi = ?, ");
            parametrat.add(VeturatDto.getStatusi());
            hasUpdates=true;
        }
        if (!hasUpdates) {
            return getById(VeturatDto.getIDVetura());
        }
        query.setLength(query.length() - 2);

        query.append(" WHERE ID_VETURA=?");
        parametrat.add(VeturatDto.getIDVetura());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for(int i=0; i<parametrat.size(); i++) {
                pstm.setObject(i+1, parametrat.get(i));
            }
            pstm.executeUpdate();
            return getById(VeturatDto.getIDVetura());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit!", e);
        }
    }
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
