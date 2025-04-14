package repository;

import database.DBConnection;
import models.Dto.CreateInsuranceDto;
import models.Dto.UpdateInsuranceDto;
import models.Payments;
import models.enums.InsuranceCompanyEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceRepository {
    private Connection connection;

    public InsuranceRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
        if (connection.isValid(1000)) {
            System.out.println("DB Connected");
        }
    }

    public ArrayList<Payments> getAll() {
        ArrayList<Payments> insurances = new ArrayList<>();
        String query = "SELECT * FROM INSURANCE";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                insurances.add(Payments.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insurances;
    }

    public Payments getById(int idInsurance) {
        String query = "SELECT * FROM Sigurimi WHERE idInsurance=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, idInsurance);
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return Payments.getInstance(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Payments create(CreateInsuranceDto InsuranceDto) {
        String query = """
            INSERT INTO SIGURIMI (IDINSURANCE,COMPANY, STARTDATE, ENDDATE, COST)
            VALUES (?, ?, ?, ?,?)
        """;
        try {
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, InsuranceDto.getIdCar());
            pstm.setString(2, InsuranceDto.getCompany().toString());
            pstm.setDate(3, new java.sql.Date(InsuranceDto.getStartDate().getTime()));
            pstm.setDate(4, new java.sql.Date(InsuranceDto.getEndDate().getTime()));
            pstm.setDouble(5, InsuranceDto.getCost());

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

    public Payments update(UpdateInsuranceDto insuranceDto) {
        StringBuilder query = new StringBuilder("UPDATE INSURANCE SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (insuranceDto.getStartDate() != null) {
            query.append("startdate = ?, ");
            parametrat.add(insuranceDto.getStartDate());
            hasUpdates = true;
        }
        if (insuranceDto.getEndDate() != null) {
            query.append("enddate = ?, ");
            parametrat.add(insuranceDto.getEndDate());
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(insuranceDto.getIDInsurance());
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE idinsurance=?");
        parametrat.add(insuranceDto.getIDInsurance());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                pstm.setObject(i + 1, parametrat.get(i));
            }
            pstm.executeUpdate();
            return getById(insuranceDto.getIDInsurance());
        } catch (SQLException e) {
            throw new RuntimeException("Error during update!", e);
        }
    }

    public boolean delete(int idInsurance) {
        String query = "DELETE FROM INSURANCE WHERE idinsurance=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, idInsurance);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Payments> filter(InsuranceCompanyEnum company, Date startDate, Date endDate, double cost) {
        ArrayList<Payments> insurances = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM INSURANCE WHERE 1=1");
        List<Object> parametrat = new ArrayList<>();

        if (company != null) {
            query.append(" AND company::text = ?");
            parametrat.add(company.toString());
        }

        if (startDate != null) {
            query.append(" AND startdate >= ?");
            parametrat.add(startDate);
        }

        if (endDate != null) {
            query.append(" AND enddate <= ?");
            parametrat.add(endDate);
        }

        if (cost > 0) {
            query.append(" AND cost = ?");
            parametrat.add(cost);
        } else if (cost < 0) {
            throw new IllegalArgumentException("cost is invalid");
        }

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                pstm.setObject(i + 1, parametrat.get(i));
            }
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                insurances.add(Payments.getInstance(resultSet));
            }
            if (insurances.isEmpty()) {
                System.out.println("No items found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insurances;
    }
}