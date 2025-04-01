package repository;

import database.DBConnection;
import models.Dto.CreateSigurimiDto;
import models.Dto.CreateVeturatDto;
import models.Dto.UpdateSigurimiDto;
import models.Dto.UpdateVeturatDto;
import models.Rezervimet;
import models.Sigurimi;
import models.Veturat;
import models.enums.Karburanti;
import models.enums.Kompania;
import models.enums.Statusi_Vetura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.DBConnection.connection;

public class SigurimiRepository {
    private Connection connection;

    public SigurimiRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
        if (connection.isValid(1000)) {
            System.out.println("DB Connected");
        }

        public ArrayList<Sigurimi> getAll () {
            ArrayList<Sigurimi> Sigurimi = new ArrayList<>();
            String query = "SELECT * FROM SIGURIMI";
            try {
                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    sigurimi.add(Sigurimi.getInstance(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return sigurimi;
        }
        public Veturat getById ( int vetura_id){
            String query = "SELECT * FROM Sigurimi WHERE id_sigurimi=?";
            try {
                PreparedStatement pstm = connection.prepareStatement(query);
                pstm.setInt(1, vetura_id);
                ResultSet resultSet = pstm.executeQuery();
                if (resultSet.next()) {
                    return Veturat.getInstance(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        public Veturat create (CreateSigurimiDto sigurimiDto){
            String query = """
                    INSERT INTO SIGURIMI (KOMPANIA, DATA_FILLIMIT, DATA_MBARIMIT,KOSTO )
                    VALUES (?, ?, ?, ?)
                    """;
            try {
                PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pstm.setString(1, sigurimiDto.getKompania());
                pstm.setDate(2, sigurimiDto.getDataFillimit());
                pstm.setDate(3, sigurimiDto.getDataMbarimit());
                pstm.setDouble(4, sigurimiDto.getKosto());

                pstm.execute();
                ResultSet result = pstm.getGeneratedKeys();
                if (result.next()) {
                    int id = result.getInt(1);
                    return this.getById(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        public Veturat update (UpdateSigurimiDto SigurimiDto){
            StringBuilder query = new StringBuilder("UPDATE SIGURIMI SET ");
            List<Object> parametrat = new ArrayList<>();
            boolean hasUpdates = false;

            if (SigurimiDto.getDataFillimit() != null) {
                query.append("data_fillimit = ?, ");
                parametrat.add(SigurimiDto.getDataFillimit());
                hasUpdates = true;
            }
            if (SigurimiDto.getDataMbarimit() != null) {
                query.append("data_mbarimit = ?, ");
                parametrat.add(SigurimiDto.getDataMbarimit());
                hasUpdates = true;
            }

            if (!hasUpdates) {
                return getById(SigurimiDto.getIDSigurimi());
            }
            query.setLength(query.length() - 2);
            query.append(" WHERE ID_VETURA=?");
            parametrat.add(SigurimiDto.getIDSigurimi());

            try {
                PreparedStatement pstm = connection.prepareStatement(query.toString());
                for (int i = 0; i < parametrat.size(); i++) {
                    pstm.setObject(i + 1, parametrat.get(i));
                }
                pstm.executeUpdate();
                return getById(SigurimiDto.getIDSigurimi());
            } catch (SQLException e) {
                throw new RuntimeException("Gabim gjate perditesimit!", e);
            }
        }
        // 5. metoda delete
        public boolean delete ( int id_sigurimi){
            String query = "DELETE FROM SIGURIMI WHERE id_sigurimi=?";
            try {
                PreparedStatement pstm = connection.prepareStatement(query);
                pstm.setInt(1, id_sigurimi);
                return pstm.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        public ArrayList<Sigurimi> filter (Kompania kompania, Date dataFillimit, Date dataMbarimit,double kosto){
            ArrayList<Sigurimi> veturat = new ArrayList<Sigurimi>();
            StringBuilder query = new StringBuilder("SELECT * FROM SIGURIMI WHERE 1=1");
            List<Object> parametrat = new ArrayList<>();

            if (kompania != null) {
                query.append(" kompania::text = ?");
                parametrat.add(kompania);
            }

            if (dataFillimit != null) {
                query.append(" dataFillimit >= ?");
                parametrat.add(dataFillimit);
            }

            if (dataMbarimit != null) {
                query.append(" dataMbarimit <= ?");
                parametrat.add(dataMbarimit);
            }

            if (kosto > 0) {
                query.append(" kosto = ?");
                parametrat.add(kosto);
            } else if (kosto < 0) {
                throw new IllegalArgumentException("Kosto eshte jo valide");
            }

            try {
                PreparedStatement pstm = connection.prepareStatement(query.toString());
                for (int i = 0; i < parametrat.size(); i++) {
                    pstm.setObject(i + 1, parametrat.get(i));
                }
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    veturat.add(Sigurimi.getInstance(resultSet));
                }
                if (veturat.isEmpty()) {
                    System.out.println("Nuk u gjeten te dhenat ne baze te filtrimit tuaj.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return veturat;
        }

    }
}
