package repository;

import database.DBConnection;
import models.Stafi;
import models.Dto.CreateStafiDto;
import models.Dto.UpdateStafiDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StafiRepository extends BaseRepository<Stafi, CreateStafiDto, UpdateStafiDto> {

    public StafiRepository() throws SQLException {
        super("stafi");
    }

    @Override
    public Stafi fromResultSet(ResultSet rs) {
        try {
            return Stafi.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metoda Create
    public Stafi create(CreateStafiDto stafiDto) {
        String query = """
                INSERT INTO STAFI (EMRI, MBIEMRI, EMAIL, PASSWORD, NRTELEFONIT, ROLI, POZITA, DATAPUNESIMIT)
                VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, stafiDto.getEmri());
            pstm.setString(2, stafiDto.getMbiemri());
            pstm.setString(3, stafiDto.getEmail());
            pstm.setString(4, stafiDto.getPassword());
            pstm.setString(5, stafiDto.getNrTelefonit());
            pstm.setString(6, stafiDto.getRoli());
            pstm.setString(7, stafiDto.getPozita());
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
    public Stafi update(UpdateStafiDto stafiDto) {
        StringBuilder query = new StringBuilder("UPDATE STAFI SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (stafiDto.getEmail() != null) {
            query.append("EMAIL = ?, ");
            parametrat.add(stafiDto.getEmail());
            hasUpdates = true;
        }
        if (stafiDto.getPassword() != null) {
            query.append("PASSWORD = ?, ");
            parametrat.add(stafiDto.getPassword());
            hasUpdates = true;
        }
        if (stafiDto.getNrTelefonit() != null) {
            query.append("NRTELEFONIT = ?, ");
            parametrat.add(stafiDto.getNrTelefonit());
            hasUpdates = true;
        }
        if (stafiDto.getRoli() != null) {
            query.append("ROLI = ?, ");
            parametrat.add(stafiDto.getRoli());
            hasUpdates = true;
        }
        if (stafiDto.getPozita() != null) {
            query.append("POZITA = ?, ");
            parametrat.add(stafiDto.getPozita());
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(stafiDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE ID = ?");
        parametrat.add(stafiDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                preparedStatement.setObject(i + 1, parametrat.get(i));
            }
            preparedStatement.executeUpdate();
            return getById(stafiDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gabim gjate perditesimit te stafit!", e);
        }
    }


}