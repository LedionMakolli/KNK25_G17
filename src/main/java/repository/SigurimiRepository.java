package repository;

import database.DBConnection;
import models.Dto.CreateSigurimiDto;
import models.Dto.UpdateSigurimiDto;
import models.Sigurimi;
import models.enums.Kompania;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SigurimiRepository {
    private Connection connection;

    public SigurimiRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
        if (connection.isValid(1000)) {
            System.out.println("DB Connected");
        }
    }

    public ArrayList<Sigurimi> getAll() {
        ArrayList<Sigurimi> sigurimet = new ArrayList<>();
        String query = "SELECT * FROM SIGURIMI";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                sigurimet.add(Sigurimi.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sigurimet;
    }

    public Sigurimi getById(int id_sigurimi) {
        String query = "SELECT * FROM Sigurimi WHERE id_sigurimi=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_sigurimi);
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return Sigurimi.getInstance(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sigurimi create(CreateSigurimiDto sigurimiDto) {
        String query = """
            INSERT INTO SIGURIMI (ID_Vetura,KOMPANIA, DATA_FILLIMIT, DATA_MBARIMIT, KOSTO)
            VALUES (?, ?, ?, ?,?)
        """;
        try {
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, sigurimiDto.getIdVetura());
            pstm.setString(2, sigurimiDto.getKompania().toString());
            pstm.setDate(3, new java.sql.Date(sigurimiDto.getDataFillimit().getTime()));
            pstm.setDate(4, new java.sql.Date(sigurimiDto.getDataMbarimit().getTime()));
            pstm.setDouble(5, sigurimiDto.getKosto());

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

    public Sigurimi update(UpdateSigurimiDto sigurimiDto) {
        StringBuilder query = new StringBuilder("UPDATE SIGURIMI SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (sigurimiDto.getDataFillimit() != null) {
            query.append("data_fillimit = ?, ");
            parametrat.add(sigurimiDto.getDataFillimit());
            hasUpdates = true;
        }
        if (sigurimiDto.getDataMbarimit() != null) {
            query.append("data_mbarimit = ?, ");
            parametrat.add(sigurimiDto.getDataMbarimit());
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(sigurimiDto.getIDSigurimi());
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE id_sigurimi=?");
        parametrat.add(sigurimiDto.getIDSigurimi());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                pstm.setObject(i + 1, parametrat.get(i));
            }
            pstm.executeUpdate();
            return getById(sigurimiDto.getIDSigurimi());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit!", e);
        }
    }

    public boolean delete(int id_sigurimi) {
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

    public ArrayList<Sigurimi> filter(Kompania kompania, Date dataFillimit, Date dataMbarimit, double kosto) {
        ArrayList<Sigurimi> sigurimet = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM SIGURIMI WHERE 1=1");
        List<Object> parametrat = new ArrayList<>();

        if (kompania != null) {
            query.append(" AND kompania::text = ?");
            parametrat.add(kompania.toString());
        }

        if (dataFillimit != null) {
            query.append(" AND data_fillimit >= ?");
            parametrat.add(dataFillimit);
        }

        if (dataMbarimit != null) {
            query.append(" AND data_mbarimit <= ?");
            parametrat.add(dataMbarimit);
        }

        if (kosto > 0) {
            query.append(" AND kosto = ?");
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
                sigurimet.add(Sigurimi.getInstance(resultSet));
            }
            if (sigurimet.isEmpty()) {
                System.out.println("Nuk u gjeten te dhenat ne baze te filtrimit tuaj.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sigurimet;
    }
}