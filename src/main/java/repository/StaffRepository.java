package repository;

import models.Staff;
import models.Dto.CreateStafDto;
import models.Dto.UpdateStafDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository extends BaseRepository<Staff, CreateStafDto, UpdateStafDto> {

    public StaffRepository() throws SQLException {
        super("stafi");
    }

    @Override
    public Staff fromResultSet(ResultSet rs) {
        try {
            return Staff.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metoda Create
    public Staff create(CreateStafDto stafiDto) {
        String query = """
                INSERT INTO STAFI (EMRI, MBIEMRI, EMAIL, PASSWORD, NRTELEFONIT, POZITA, DATAPUNESIMIT)
                VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, stafiDto.getFirstName());
            pstm.setString(2, stafiDto.getLastName());
            pstm.setString(3, stafiDto.getEmail());
            pstm.setString(4, stafiDto.getPassword());
            pstm.setString(5, stafiDto.getTelephoneNumber());
            pstm.setString(6, stafiDto.getPosition());
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
    public Staff update(UpdateStafDto stafiDto) {
        StringBuilder query = new StringBuilder("UPDATE STAFF SET ");
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
        if (stafiDto.getTelephoneNumber() != null) {
            query.append("NRTELEFONIT = ?, ");
            parametrat.add(stafiDto.getTelephoneNumber());
            hasUpdates = true;
        }
        if (stafiDto.getPosition() != null) {
            query.append("POZITA = ?, ");
            parametrat.add(stafiDto.getPosition());
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
            throw new RuntimeException("Error during staf update!", e);
        }
    }


}